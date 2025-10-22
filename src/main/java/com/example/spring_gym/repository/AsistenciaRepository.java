package com.example.spring_gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_gym.model.Asistencia;
@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer>{

}
