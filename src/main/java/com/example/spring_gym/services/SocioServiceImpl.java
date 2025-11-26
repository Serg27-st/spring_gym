package com.example.spring_gym.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_gym.model.Socio;
import com.example.spring_gym.repository.SocioRepository;

@Service
public class SocioServiceImpl implements ISocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Override
    public Optional<Socio> findById(Integer id) {
        return socioRepository.findById(id);
    }

    @Override
	public Socio save(Socio socio) {
		return socioRepository.save(socio);
	}

	@Override
	public Optional<Socio> findByEmail(String email) {
		return socioRepository.findByEmail(email);
	}

	@Override
	public List<Socio> findAll() {
		return socioRepository.findAll();
	}


 

}