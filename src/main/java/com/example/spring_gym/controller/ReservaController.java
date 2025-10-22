package com.example.spring_gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
    @GetMapping("")
       public String home(){
         return "reserva/show";
    }
}
