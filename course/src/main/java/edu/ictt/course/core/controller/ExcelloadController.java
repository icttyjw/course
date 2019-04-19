package edu.ictt.course.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExcelloadController {

	@RequestMapping("/upload")
	public String excelupload(){
		return "excelupload";
	}
}
