package org.adu.readingroom.controller;

import java.io.IOException;

import org.adu.readingroom.model.Document;
import org.adu.readingroom.service.DocumentService;
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
	

	@RequestMapping(value="/documents/edit", method=RequestMethod.GET)
	public String getDocumentEditor(Model model, @RequestParam(value="documentId", required=false) String documentId) {
		Document documentToEdit=null;
		if (documentId==null) {
			documentToEdit=new Document();
		} else {
			documentToEdit=documentService.getById(documentId);
		}
		model.addAttribute("documentToEdit", documentToEdit);
		System.out.println("DocCont-GET:" + documentToEdit.toString());
		return "documentEditor";
	}
	

	@RequestMapping(value="/documents/edit", method=RequestMethod.POST)
	public String processDocumentEditor(
			@ModelAttribute("documentToEdit") Document document, 
			@RequestParam("fileData") MultipartFile multipartFile) throws IOException {
		
		if (multipartFile!=null) {			
			handleFileData(document, multipartFile);
		}
		
		//if this is a new document to be created:
		if (document.getId()==0) {
			documentService.save(document);
		} else {
			System.out.println("DocCont-POST:" + document.toString());
			documentService.update(document);
		}

		return "redirect:/documents";
	}


	private void handleFileData(Document newDocument, MultipartFile multipartFile) throws IOException {
		
		int fileSize = (int)multipartFile.getSize();
		byte[] fileContent = new byte[fileSize];
		try {
			multipartFile.getInputStream().read(fileContent);
		} catch (IOException e) {
			throw new IOException("Unable to convert file to byte array. " + e.getMessage());
		} 		
		newDocument.setFileData(fileContent);
		newDocument.setFileName(multipartFile.getOriginalFilename());		
	}

	
	@RequestMapping(value="/documents/delete", method=RequestMethod.GET)
	public String getDocumentEditor(@RequestParam("documentId") String documentId) {
		documentService.deleteById(documentId);
		return "redirect:/documents";
	}

	
}
