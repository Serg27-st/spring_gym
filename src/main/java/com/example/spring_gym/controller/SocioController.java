package com.example.spring_gym.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_gym.model.Socio;
import com.example.spring_gym.model.Venta;
import com.example.spring_gym.services.ISocioService;
import com.example.spring_gym.services.IVentaService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/socio")
public class SocioController {
  private final Logger logger= LoggerFactory.getLogger(SocioController.class);
	
	@Autowired
	private ISocioService socioService;
	
	@Autowired
	private IVentaService ventaService;
	
  BCryptPasswordEncoder passEncode = new BCryptPasswordEncoder();
	
	
	// /usuario/registro
	@GetMapping("/registro")
	public String create() {
		return "socio/registro";
	}
	
	@PostMapping("/save")
	public String save(Socio socio) {
		logger.info("Socio registro: {}", socio);
		socio.setTipo("USER");
    socio.setPassword(passEncode.encode(socio.getPassword()));
		socioService.save(socio);		
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "socio/login";
	}
	
	@PostMapping("/acceder")
	public String acceder(Socio socio, HttpSession session) {
		logger.info("Accesos : {}", socio);
		
		Optional<Socio> user =socioService.findByEmail(socio.getEmail());
		//logger.info("Usuario de db: {}", user.get());
		
		if (user.isPresent()) {
			session.setAttribute("idsocio", user.get().getIdSocio());
			
			if (user.get().getTipo().equals("ADMIN")) {
				return "redirect:/administrador";
			}else {
				return "redirect:/";
			}
		}else {
			logger.info("Usuario no existe");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/compras")
	public String obtenerCompras(Model model, HttpSession session) {
		model.addAttribute("sesion", session.getAttribute("idsocio"));
		
		Socio socio= socioService.findById(  Integer.parseInt(session.getAttribute("idsocio").toString()) ).get();
		List<Venta> ventas= ventaService.findBySocio(socio);
		logger.info("ventas {}", ventas);
		
		model.addAttribute("ventas", ventas);
		
		return "socio/compras";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalleCompra(@PathVariable Integer id, HttpSession session, Model model) {
		logger.info("Id de la orden: {}", id);
		Optional<Venta> venta=ventaService.findById(id);
		
		model.addAttribute("detalles", venta.get().getDetalles());
		
		
		//session
		model.addAttribute("sesion", session.getAttribute("idsocio"));
		return "socio/detallecompra";
	}
	
	@GetMapping("/cerrar")
	public String cerrarSesion( HttpSession session ) {
		session.removeAttribute("idsocio");
		return "redirect:/";
	}
}
