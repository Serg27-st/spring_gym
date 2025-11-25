package com.example.spring_gym.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_gym.model.DetalleVenta;
import com.example.spring_gym.repository.DetalleVentaRepository;

@Service
public class DetalleVentaImpl implements DetalleVentaService{
@Autowired
	private DetalleVentaRepository detalleVentaRepository;

	@Override
	public DetalleVenta save(DetalleVenta detalleVenta) {
		return detalleVentaRepository.save(detalleVenta);
	}
}
