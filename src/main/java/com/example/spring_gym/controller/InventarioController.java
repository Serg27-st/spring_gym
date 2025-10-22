package com.example.spring_gym.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.model.Socio;
import com.example.spring_gym.services.InventarioService;




@Controller
@RequestMapping("/inventarios")
public class InventarioController {

     private final Logger LOGGER = LoggerFactory.getLogger(InventarioController.class);
     @Autowired
     private InventarioService inventarioService; 

     
    @GetMapping("")
       public String show(Model model){
          model.addAttribute("inventarios", inventarioService.findAll());
         return "inventarios/show";
    }
    @GetMapping("/create")
    public String create(){
         return "inventarios/create";
    }

    @PostMapping("/save")
    public String save(Inventario inventario){
     LOGGER.info("ESTE ES EL OBJETO INVENTARIO{}", inventario);
     Socio s = new Socio(1, "", "", "", "", "", "", "");
     inventario.setSocio(s);
     inventarioService.save(inventario);
     
     return "redirect:/inventarios";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Inventario inventario = new Inventario();
        Optional<Inventario> optionalInventario = inventarioService.get(id);
        inventario= optionalInventario.get();

        LOGGER.info("inventario buscado: {}", inventario);
        model.addAttribute("inventario", inventario);
     return "inventarios/edit";
    }
    @PostMapping("/update")
     public String update(Inventario inventario) {
          inventarioService.update(inventario);
     return "redirect:/inventarios";
    }

     @GetMapping("/delete/{id}")
     public String delete(@PathVariable Integer id) {
          inventarioService.delete(id);;
     return "redirect:/inventarios";
    }
    
   
  
}
