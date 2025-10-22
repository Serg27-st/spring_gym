package com.example.spring_gym.services;

import java.util.Optional;
import com.example.spring_gym.model.Membresia;

public interface MembresiaService {
    public Membresia save(Membresia membresia);
    public Optional<Membresia> get(Integer idMembresia);
    public void update(Membresia membresia);
    public void delete(Integer id);
}

