package com.spring.fileupload.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.fileupload.dao.FileUploadDao;
import com.spring.fileupload.entity.FIleUpload;

@Controller
public class FileController {

	@Autowired
	private FileUploadDao fud;
	
	public String savepath="C:/Users/Rakesh/project/SpringMvcFileUpload/src/main/webapp/resource";
	
	@GetMapping("/")
	public String getIndex(Model model) {
		
		model.addAttribute("msg","welcome to File Upload Demo");
		model.addAttribute("fileupload",new FIleUpload());
		
		return "index";
	}
	
	@PostMapping("/save")
	public String getFileUpolad(@RequestParam("file")MultipartFile file,Model model) throws Exception {
		
		FIleUpload f=new FIleUpload();
		
		File dir=new File(savepath);
		
		f.setFilename(file.getOriginalFilename());
		f.setSavepath(savepath);
		
		byte[] bytes=file.getBytes();
		
		if(!dir.exists()){
			dir.mkdir();
		}
		File uoload=new File(dir.getAbsolutePath()+File.separator+file.getOriginalFilename());
		BufferedOutputStream output=new BufferedOutputStream(new FileOutputStream(uoload));
		
		output.write(bytes);
		output.close();
		
		fud.save(f);
		
		model.addAttribute("Location",uoload);
		
		List<FIleUpload> flist=fud.list();
		
		model.addAttribute("fileup",flist);
		return "success";
	}
	
	@GetMapping("/fileup")
	public String getResult(Model model) {
		
        List<FIleUpload> flist=fud.list();
		
		model.addAttribute("fileup",flist);
		
		return "success";
	}
}
