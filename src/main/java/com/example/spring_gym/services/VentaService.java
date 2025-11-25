package com.example.spring_gym.services;

import java.util.List;
import java.util.Optional;

import com.example.spring_gym.model.Socio;
import com.example.spring_gym.model.Venta;

public interface VentaService {
  List<Venta> findAll();
	Optional<Venta> findById(Integer id);
	Venta save (Venta venta);
	String generarNumeroVenta();
	List<Venta> findBySocio (Socio socio);

}
