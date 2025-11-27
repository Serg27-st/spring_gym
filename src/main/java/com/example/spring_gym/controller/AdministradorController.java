package com.example.spring_gym.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.model.Venta;
import com.example.spring_gym.services.IInventarioService;
import com.example.spring_gym.services.ISocioService;
import com.example.spring_gym.services.IVentaService;



@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private IInventarioService inventarioService;
	
	@Autowired
	private ISocioService socioService;
	
	@Autowired
	private IVentaService ventaService;
	
	private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

	@GetMapping("")
	public String home(Model model) {

		List<Inventario> inventarios = inventarioService.findAll();
		model.addAttribute("inventarios", inventarios);


		return "administrador/home";
	}

    @GetMapping("/socios")
	public String socios(Model model) {
		model.addAttribute("socios", socioService.findAll());
		return "administrador/socios";
	}
	
	@GetMapping("/ventas")
	public String ventas(Model model) {
		model.addAttribute("ventas", ventaService.findAll());
		return "administrador/ventas";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable Integer id) {
		logg.info("Id de la venta {}",id);
		Venta venta= ventaService.findById(id).get();
		
		model.addAttribute("detalles", venta.getDetalles());
		
		return "administrador/detalleventa";
	}
	

}
