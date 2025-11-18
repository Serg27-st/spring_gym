package com.example.spring_gym.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.example.spring_gym.model.DetalleVenta;
import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.model.Venta;
import com.example.spring_gym.services.InventarioService;



@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private InventarioService inventarioService;

	List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();

	Venta venta = new Venta();



	@GetMapping("")
	public String home(Model model) {
				
		model.addAttribute("inventarios", inventarioService.findAll());
		
		return "socio/home";
	}


	@GetMapping("inventariohome/{id}")
	public String inventarioHome(@PathVariable Integer id, Model model){
		log.info("id producto enviado como parametro[]",id);
		Inventario inventario = new Inventario();
		Optional<Inventario> inventarioOptional= inventarioService.get(id);
		inventario = inventarioOptional.get();
		model.addAttribute("inventario",inventario);
		return "socio/inventariohome";
	}

	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
		DetalleVenta detalleVenta = new DetalleVenta();
		Inventario inventario = new Inventario();
		double sumatotal = 0;
		Optional<Inventario> optionalInventario = inventarioService.get(id);
		log.info("Producto añadido: {}", optionalInventario.get());
		log.info("cantidad {}", cantidad);
		inventario=optionalInventario.get();

		detalleVenta.setCantidad(cantidad);
		detalleVenta.setPrecioUnitario(inventario.getPrecio());
		detalleVenta.setNombre(inventario.getNombre());
		detalleVenta.setTotal(inventario.getPrecio()*cantidad);
		detalleVenta.setInventario(inventario);

		detalles.add(detalleVenta);

		sumatotal=detalles.stream().mapToDouble(dt->dt.getTotal()).sum();

		venta.setMontoTotal(sumatotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("venta", venta);



		return "socio/carrito";
	}
	
}