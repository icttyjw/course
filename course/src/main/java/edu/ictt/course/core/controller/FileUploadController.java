package edu.ictt.course.core.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ictt.course.core.storage.StorageFileNotFoundException;
import edu.ictt.course.core.storage.StorageService;
import edu.ictt.course.service.SendService;


@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }
    @Autowired
    private SendService sendService;

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
    	List<Path> ps=storageService.loadAll().collect(Collectors.toList());
    	List<String> ls=new ArrayList<String>();
    	for(Path p:ps){
    		ls.add(p.getFileName().toString());
    	}
        model.addAttribute("files", ls);//.map(
        
                //path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                  //      "serveFile", path.getFileName().toString()).build().toString())
                //.collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    
    @PostMapping("/send")
    public String Testsend(@RequestParam("file") String file,@RequestParam("fname") String course,
            RedirectAttributes redirectAttributes){
    	System.out.println(file);
    	System.out.println(course);
    	sendService.send(storageService.load(file), course);
    	redirectAttributes.addFlashAttribute("message",
                "test ");
    	return "redirect:/";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
