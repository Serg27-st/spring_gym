package com.example.spring_gym.services;

import java.util.Optional;

import com.example.spring_gym.model.Socio;

public interface SocioService {
    Optional<Socio> findById(Integer id);
  
}