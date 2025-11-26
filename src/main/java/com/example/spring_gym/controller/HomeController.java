package com.example.spring_gym.controller;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

import com.example.spring_gym.model.DetalleVenta;
import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.model.Socio;
import com.example.spring_gym.model.Venta;
import com.example.spring_gym.services.DetalleVentaService;
import com.example.spring_gym.services.IInventarioService;
import com.example.spring_gym.services.ISocioService;
import com.example.spring_gym.services.IVentaService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/")
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private IInventarioService inventarioService;
	
	
	@Autowired
	private ISocioService socioService;

	
	
	@Autowired
	private IVentaService ventaService;
	
	@Autowired
	private DetalleVentaService detalleVentaService;


	List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();
	
	Venta venta= new Venta();


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

		Integer idInventario=inventario.getIdInventario();
		boolean ingresado=detalles.stream().anyMatch(p -> p.getInventario().getIdInventario()==idInventario);
		
		if (!ingresado) {
			detalles.add(detalleVenta);
		}

		sumatotal=detalles.stream().mapToDouble(dt->dt.getTotal()).sum();

		venta.setMontoTotal(sumatotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("venta", venta);



		return "socio/carrito";
	}


	//quitar producto del carrito
@GetMapping("/delete/cart/{id}")
	public String deleteProductoCart(@PathVariable Integer id, Model model){

		List<DetalleVenta> ventaNueva = new ArrayList<DetalleVenta>();

		for (DetalleVenta detalleVenta : detalles) {
			if (detalleVenta.getInventario().getIdInventario()!=id) {
				ventaNueva.add(detalleVenta);
				}
		}
		detalles=ventaNueva;
		double sumatotal=0;
		sumatotal=detalles.stream().mapToDouble(dt->dt.getTotal()).sum();

		venta.setMontoTotal(sumatotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("venta", venta);

		return "socio/carrito";
	}

	@GetMapping("/getCart")
	public String getCart(Model model) {
		model.addAttribute("cart", detalles);
		model.addAttribute("venta", venta);
		
		return "/socio/carrito";
	}
	
	@GetMapping("/venta")
	public String venta(Model model) {

		Socio socio= socioService.findById(1).get();
		
		model.addAttribute("cart", detalles);
		model.addAttribute("venta", venta);
		model.addAttribute("socio",socio);
		return "socio/resumenventa";
	}

	@GetMapping("/saveVenta")
	public String saveVenta(HttpSession session ) {
		Date fechaCreacion = new Date();
		venta.setFechaCreacion(fechaCreacion);
		venta.setNumero(ventaService.generarNumeroVenta());
		
		//socio
		Socio socio = socioService.findById(1).get();
		
		venta.setSocio(socio);
		ventaService.save(venta);
		
		//guardar detalles
		for (DetalleVenta dt:detalles) {
			dt.setVenta(venta);
			detalleVentaService.save(dt);
		}
		
		///limpiar lista y orden
		venta = new Venta();
		detalles.clear();
		
		return "redirect:/";
	}

	@PostMapping("/search")
	public String searchProduct(@RequestParam String nombre, Model model) {
		log.info("Nombre del producto: {}", nombre);
		List<Inventario> inventarios= inventarioService.findAll().stream().filter( p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
		model.addAttribute("inventarios", inventarios);		
		return "socio/home";
	}


	
	
}