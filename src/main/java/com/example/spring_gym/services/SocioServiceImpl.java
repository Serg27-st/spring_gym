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
    public Optional<Socio> findById(Integer id) {
        return socioRepository.findById(id);
    }


 

}