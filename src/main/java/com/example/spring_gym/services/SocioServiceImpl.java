package com.example.spring_gym.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring_gym.model.Socio;
import com.example.spring_gym.repository.SocioRepository;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Override
    public Socio save(Socio socio) {
        return socioRepository.save(socio);
    }

    @Override
    public Optional<Socio> get(Integer idSocio) {
        return socioRepository.findById(idSocio);
    }

    @Override
    public void update(Socio socio) {
        socioRepository.save(socio);
    }

    @Override
    public void delete(Integer idSocio) {
        socioRepository.deleteById(idSocio);
    }
}