package com.example.spring_gym.services;

import java.util.List;
import java.util.Optional;

import com.example.spring_gym.model.Inventario;

public interface IInventarioService {
public Inventario save (Inventario producto);
public Optional<Inventario> get(Integer idInventario);
public void update(Inventario producto);
public void delete(Integer id);
public List<Inventario> findAll();
}
