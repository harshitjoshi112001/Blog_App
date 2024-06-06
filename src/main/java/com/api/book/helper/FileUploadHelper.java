package com.api.book.helper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR="C:\\Users\\User\\OneDrive\\Documents\\GitHub\\MyJavaIntern\\BooksApi\\src\\main\\resources\\static\\Image";
	public final String UPLOAD_DIR= new ClassPathResource("static/Image/").getFile().getAbsolutePath(); //for dynamic Upload
	
	
	public FileUploadHelper() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean uploadFile(MultipartFile file)
	{
		boolean status = false;
		
		try {
//			InputStream is = file.getInputStream();
//			byte data[] = new byte[is.available()]; //collect file in byte array form
//			is.read(data);
//			
//			//write in folder
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"\\"+file.getOriginalFilename());  //to write the file in folder
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();
			
			//alternative method of above code
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+"\\"+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);   //in , target , option
			
			status = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
