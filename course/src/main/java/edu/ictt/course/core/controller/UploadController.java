package edu.ictt.course.core.controller;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.ictt.course.service.SendService;


@RestController
public class UploadController {

	@Resource
	private SendService sendService;
	
	@PostMapping("/upload")
	public Message upload(MultipartFile fileUpload,String name){
		
		 String fileName = fileUpload.getOriginalFilename();
		 try {
	        	File path = new File(ResourceUtils.getURL("classpath:").getPath());
	        	 if(!path.getParentFile().exists()){
	                 path.getParentFile().mkdirs();//创建父级文件路径
	                 path.createNewFile();//创建文件
	                 System.out.println(path.exists());
	             }
	    		System.out.println("path:"+path.getAbsolutePath());

	    		//如果上传目录为/static/images/upload/，则可以如下获取：
	    		File upload = new File(path.getAbsolutePath(),"static/upload/"+fileName);
	    		if(!upload.getParentFile().exists()){ 
	    			upload.getParentFile().mkdirs();
	    			upload.createNewFile();
	    		}
	            //将图片保存到static文件夹里
	            fileUpload.transferTo(upload);
	            sendService.send(fileName, name);
	            return new Message(0,"success to upload");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new Message(-1,"fail to upload");
	        } 
		
	}
}
