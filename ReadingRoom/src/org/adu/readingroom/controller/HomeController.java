package org.adu.readingroom.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {
	
	@RequestMapping( value={"/", "/home"}, method=RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		Date date = new Date();
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
		String serverTime = formatter.format(date);
		model.addAttribute("serverTime", serverTime);		
		return "home";
	}
	
	@RequestMapping(value="/todo", method=RequestMethod.GET)
	public String toDo(Locale locale, Model model) {		
		return "todo";
	}

}
