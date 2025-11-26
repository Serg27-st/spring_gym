package com.example.spring_gym.services;

import java.util.List;
import java.util.Optional;

import com.example.spring_gym.model.Socio;

public interface ISocioService {
    List<Socio> findAll();
	Optional<Socio> findById(Integer idSocio);
	Socio save (Socio socio);
	Optional<Socio> findByEmail(String email);

}