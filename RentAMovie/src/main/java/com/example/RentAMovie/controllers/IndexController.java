package com.example.RentAMovie.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@GetMapping("/")
	public ModelAndView goToDoc() {
		return new ModelAndView("redirect:/swagger-ui.html");
	}
}
