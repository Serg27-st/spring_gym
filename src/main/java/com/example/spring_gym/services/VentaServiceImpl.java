package com.example.spring_gym.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.spring_gym.model.Venta;
import com.example.spring_gym.repository.VentaRepository;

public class VentaServiceImpl implements VentaService{
    @Autowired
    private VentaRepository ventaRepository;    
    
    @Override
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }


}
