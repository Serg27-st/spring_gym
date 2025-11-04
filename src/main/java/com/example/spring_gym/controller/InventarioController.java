package com.example.spring_gym.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring_gym.model.Inventario;
import com.example.spring_gym.model.Socio;
import com.example.spring_gym.services.InventarioService;
import com.example.spring_gym.services.UploadFileService;




@Controller
@RequestMapping("/inventarios")
public class InventarioController {

     private final Logger LOGGER = LoggerFactory.getLogger(InventarioController.class);
     @Autowired
     private InventarioService inventarioService; 

     @Autowired
     private UploadFileService upload;

     
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
    public String save(Inventario inventario, @RequestParam("img") MultipartFile file) throws IOException{
     LOGGER.info("ESTE ES EL OBJETO INVENTARIO{}", inventario);
     Socio s = new Socio(1, "", "", "", "", "", "", "");
     inventario.setSocio(s);
     //imagen
     if (inventario.getIdInventario()==null){
          String nombreImagen = upload.saveImage(file);
          inventario.setImagen(nombreImagen);
     }else {
         
     }
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
     public String update(Inventario inventario, @RequestParam("img") MultipartFile file) throws IOException {
          Inventario i=new Inventario();
          i=inventarioService.get(inventario.getIdInventario()).get();
          
          if(file.isEmpty()) {
             
               inventario.setImagen(i.getImagen());
          } else {// cuando se edita tbn la imagen			
			//eliminar cuando no sea la imagen por defecto

          if (!i.getImagen().equals("default.jpg") ) {
              upload.deleteImage(i.getImagen());
          }

          String nombreImagen = upload.saveImage(file);
          inventario.setImagen(nombreImagen);
          }
          inventario.setSocio(i.getSocio());
          inventarioService.update(inventario);
     return "redirect:/inventarios";
    }



     @GetMapping("/delete/{id}")
     public String delete(@PathVariable Integer id) {
          Inventario i=new Inventario();
          i=inventarioService.get(id).get();
          
          if (!i.getImagen().equals("default.jpg") ) {
              upload.deleteImage(i.getImagen());
          }
          inventarioService.delete(id);
     return "redirect:/inventarios";
    }
    
   
  
}
