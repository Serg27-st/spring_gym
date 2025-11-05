package com.example.spring_gym.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_gym.services.InventarioService;

@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private InventarioService inventarioService;

	@GetMapping("")
	public String home(Model model) {
				
		model.addAttribute("inventarios", inventarioService.findAll());
		
		return "socio/home";
	}
}