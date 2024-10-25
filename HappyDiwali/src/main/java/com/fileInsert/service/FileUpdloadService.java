package com.fileInsert.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fileInsert.ResponseEntity.FileResponse;

@Service
public class FileUpdloadService {

	public List<FileResponse> uploadFile(MultipartFile[] file) {
		List<FileResponse> fileResponseList = new ArrayList<>();
       for(MultipartFile fil :file){
		FileResponse fileResponse = new FileResponse();
		fileResponse.setFileName(fil.getOriginalFilename());
		fileResponse.setFileSize(fil.getSize());
		fileResponse.setFileType(fil.getContentType());
		fileResponseList.add(fileResponse);
		}		
       return fileResponseList;
	}
       

}
