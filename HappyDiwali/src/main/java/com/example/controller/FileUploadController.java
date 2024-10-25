package com.example.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fileInsert.ResponseEntity.FileResponse;
import com.fileInsert.service.FileUpdloadService;

@RestController
@RequestMapping("upload/")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUpdloadService fileUploadService;

    @PostMapping("/multiple-file-upload")
    public ResponseEntity<List<FileResponse>> handleMultipleFileUpload(
            @RequestParam("file") MultipartFile[] files) {
        logger.info("Received {} files for upload", files.length);

        try {
            List<FileResponse> responses = fileUploadService.uploadFile(files);
            logger.info("Successfully uploaded {} files", responses.size());
            return new ResponseEntity<>(responses, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("File upload failed: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
