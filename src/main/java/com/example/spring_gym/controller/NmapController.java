package com.example.spring_gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_gym.services.NmapService;

@RestController
@RequestMapping("/nmap")
public class NmapController {

    @Autowired
    private NmapService nmapService;

    @GetMapping("/scan/{ip}")
    public ResponseEntity<String> scan(@PathVariable String ip) {
        try {
            String resultado = nmapService.ejecutarNmap(ip);
            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body("Error al ejecutar el escaneo: " + e.getMessage());
        }
    }
    
}
