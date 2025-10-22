package com.example.spring_gym.services;

import java.util.Optional;
import com.example.spring_gym.model.Socio;

public interface SocioService {
    public Socio save(Socio socio);
    public Optional<Socio> get(Integer idSocio);
    public void update(Socio socio);
    public void delete(Integer idSocio);
}