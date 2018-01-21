package org.adu.cbl.controller;

import java.io.IOException;

import org.adu.cbl.model.Document;
import org.adu.cbl.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DocumentController {
	
	@Autowired
	DocumentService documentService;	
	
	@RequestMapping(value="/documents", method=RequestMethod.GET)
	public String getDocuments(Model model) {			
		model.addAttribute("documents", documentService.getDocumentList() );
		return "documents";
	}

	@RequestMapping(value="/documents/add", method=RequestMethod.GET)
	public String getAddDocumentForm(Model model) {
		Document d = new Document();
		d.setTitle("fareli  köy");
		model.addAttribute("newDocument", d);
		return "addDocument";
	}

	@RequestMapping(value="/documents/add", method=RequestMethod.POST)
	public String processAddDocumentForm(
			@ModelAttribute("newDocument") Document newDocument, 
			@RequestParam("fileData") MultipartFile multipartFile) throws IOException {
		
		System.out.println("i am in processAddDocumentForm");
		System.out.println(multipartFile.getOriginalFilename());
		newDocument.setFileName(multipartFile.getOriginalFilename());
		
		int fileSize = (int)multipartFile.getSize();
		byte[] fileContent = new byte[fileSize];
		try {
			multipartFile.getInputStream().read(fileContent);
		} catch (IOException e) {
			throw new IOException("Unable to convert file to byte array. " + e.getMessage());
		} 
		System.out.println(newDocument.toString());
		
		newDocument.setFileData(fileContent);

		System.out.println(newDocument.toString());
		documentService.save(newDocument);
		return "redirect:/documents";
	}

}
