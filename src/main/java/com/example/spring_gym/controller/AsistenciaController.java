package com.example.spring_gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asistencia")
public class AsistenciaController {
    @GetMapping("")
       public String home(){
         return "asistencia/show";
    }
}
