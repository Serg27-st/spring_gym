package com.example.spring_gym.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring_gym.model.Membresia;
import com.example.spring_gym.repository.MembresiaRepository;

@Service
public class MembresiaServiceImpl implements MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Override
    public Membresia save(Membresia membresia) {
        return membresiaRepository.save(membresia);
    }

    @Override
    public Optional<Membresia> get(Integer idMembresia) {
        return membresiaRepository.findById(idMembresia);
    }

    @Override
    public void update(Membresia membresia) {
        membresiaRepository.save(membresia);
    }

    @Override
    public void delete(Integer id) {
        membresiaRepository.deleteById(id);
    }
}
