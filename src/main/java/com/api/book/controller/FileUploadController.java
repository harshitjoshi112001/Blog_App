package com.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadHelper fileUploadHelper;
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		try {
			//validation
			if(file.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file...");
			}
			if(!(file.getContentType().contains("jpg")) && !(file.getContentType().contains("jpeg")))
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPG file are allowed..!!!");
			}
			
			//file upload code where to store file
			boolean check = this.fileUploadHelper.uploadFile(file);
			if(check)
			{
//				return ResponseEntity.ok("Successfully uploaded the file...!!!!");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Image/").path(file.getOriginalFilename()).toUriString());  //create link to open file in server
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Oops...Something gone wrong..!!!");
	}
}
