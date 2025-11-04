package com.example.spring_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.services.InventarioService;



@Controller
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    private InventarioService inventarioService;
    @GetMapping("")
    public String home(Model model){
        List<Inventario> inventarios=inventarioService.findAll();
        model.addAttribute("inventarios", inventarios);
        
        return "administrador/home";
    }

}
