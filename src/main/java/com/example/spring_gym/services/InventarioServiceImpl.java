package com.example.spring_gym.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.repository.InventarioRepository;

@Service
public class InventarioServiceImpl implements IInventarioService{
@Autowired
private InventarioRepository inventarioRepository;

    @Override
    public void delete(Integer idInventario) {
        inventarioRepository.deleteById(idInventario);
        
    }

    @Override
    public Optional<Inventario> get(Integer idInventario) {
        return inventarioRepository.findById(idInventario);
    }

    @Override
    public Inventario save(Inventario producto) {
        return inventarioRepository.save(producto);
    }

    @Override
    public void update(Inventario producto) {
        inventarioRepository.save(producto);
        
    }

    @Override
	public List<Inventario> findAll() {
		return inventarioRepository.findAll();
	}
    

}
