package edu.ictt.course.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExcelloadController {

	@RequestMapping("/testupload")
	public ModelAndView excelupload(ModelAndView model){
		model.setViewName("excelupload");
		return model;
	}
}
