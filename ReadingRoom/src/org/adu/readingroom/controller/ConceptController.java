package org.adu.readingroom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.adu.readingroom.model.Concept;
import org.adu.readingroom.service.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ConceptController {
	
	@Autowired
	ConceptService conceptService;
	
//	private static final Logger logger = LoggerFactory.getLogger(ConceptsController.class);

	@RequestMapping(value="/concepts", method=RequestMethod.GET)
	public String getConcepts(Locale locale, Model model) {
		//logger.info("Welcome to concepts page! The client locale is {}.", locale);
	
		List<Concept> concepts = new ArrayList<Concept>();		
		concepts = conceptService.getConceptList();		
		model.addAttribute("concepts", concepts );
		return "concepts";
	}
	
	@RequestMapping(value="/concepts/edit", method=RequestMethod.GET)
	public String getConceptEditor(Model model, Locale locale, @RequestParam(value="conceptId", required=false) String conceptId) {
		Concept conceptToEdit;
		if (conceptId==null) { 
			conceptToEdit=new Concept(); 
		} else {
			conceptToEdit=conceptService.getById(conceptId);
		}
		model.addAttribute("conceptToEdit", conceptToEdit);
		return "conceptEditor";
	}


	@RequestMapping(value="/concepts/edit", method=RequestMethod.POST)
	public String processConceptEditor(@ModelAttribute("conceptToEdit") Concept concept) {
		
		//if this is a new concept to be created:
		if (concept.getId()==0) {
			conceptService.save(concept);
		} else {
			conceptService.update(concept);
		}
		return "redirect:/concepts";	
	}
	
	

	@RequestMapping(value="/concepts/delete", method=RequestMethod.GET)
	public String deleteConcept(@RequestParam("conceptId") String conceptId) {
		
		//(MISUSE OF GET METHOD. IT SHOULD NOT CAUSE DATA MODIFICATION.) 
		
		conceptService.deleteById(conceptId);
		return "redirect:/concepts";	
	}
	
}
