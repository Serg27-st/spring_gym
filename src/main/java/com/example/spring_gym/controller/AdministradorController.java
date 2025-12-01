package com.example.spring_gym.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.model.Socio;
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
		model.addAttribute("page", "home");

		return "administrador/home";
	}

    @GetMapping("/socios")
	public String socios(Model model) {
		model.addAttribute("socios", socioService.findAll());
		model.addAttribute("page", "socios");
		return "administrador/socios";
	}
	
	@GetMapping("/ventas")
	public String ventas(Model model) {
		model.addAttribute("ventas", ventaService.findAll());
		model.addAttribute("page", "ventas");

		return "administrador/ventas";
	}
@GetMapping("/ventas/cambiarEstado/{id}")
public String cambiarEstado(@PathVariable Integer id) {
    
    Venta venta = ventaService.findById(id).orElse(null);

    if (venta != null) {
        // Evita NullPointerException
        venta.setEstado(
            "PENDIENTE".equals(venta.getEstado()) ? "COMPLETA" : "PENDIENTE"
        );
        ventaService.save(venta);
    }

    return "redirect:/administrador/ventas";
}

	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable Integer id) {
		logg.info("Id de la venta {}",id);
		Venta venta= ventaService.findById(id).get();
		
		model.addAttribute("detalles", venta.getDetalles());
		model.addAttribute("page", "detalle");
		
		return "administrador/detalleventa";
	}
	

	
// BUSCAR PRODUCTOS EN HOME
@PostMapping("/searchProductos")
public String searchProductos(@RequestParam String nombre, Model model) {
    // Normalizar término de búsqueda
    String busqueda = (nombre == null) ? "" : nombre.trim().toLowerCase();

    List<Inventario> inventarios = inventarioService.findAll().stream()
            .filter(p -> p.getNombre() != null && p.getNombre().trim().toLowerCase().contains(busqueda))
            .collect(Collectors.toList());

    model.addAttribute("inventarios", inventarios);
    model.addAttribute("page", "home");
    return "administrador/home";
}


// BUSCAR SOCIOS EN socios.html
@PostMapping("/searchSocios")
public String searchSocios(@RequestParam String nombre, Model model) {
    // Validar y normalizar el término de búsqueda
    String busqueda = (nombre == null) ? "" : nombre.trim().toLowerCase();

    List<Socio> socios = socioService.findAll().stream()
            .filter(s -> s.getNombre() != null && s.getNombre().toLowerCase().contains(busqueda))
            .collect(Collectors.toList());

    model.addAttribute("socios", socios);
    model.addAttribute("page", "socios");
    return "administrador/socios";
}



// BUSCAR VENTAS POR NUMERO EN ventas.html
@PostMapping("/searchVentas")
public String searchVentas(@RequestParam String numero, Model model) {
    // Normalizar el número de búsqueda
    String busqueda = (numero == null) ? "" : numero.trim().toLowerCase();

    List<Venta> ventas = ventaService.findAll().stream()
            .filter(v -> v.getNumero() != null && v.getNumero().trim().toLowerCase().contains(busqueda))
            .collect(Collectors.toList());

    model.addAttribute("ventas", ventas);
    model.addAttribute("page", "ventas");
    return "administrador/ventas";
}



}
