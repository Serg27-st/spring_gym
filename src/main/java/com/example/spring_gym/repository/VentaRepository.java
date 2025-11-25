package com.example.spring_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_gym.model.Socio;
import com.example.spring_gym.model.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{
 List<Venta> findBySocio(Socio socio);
}
