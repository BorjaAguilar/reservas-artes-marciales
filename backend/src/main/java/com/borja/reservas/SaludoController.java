package com.borja.reservas;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/api/saludo")
    public String saludar(){
        return "Servidor de reservas de clases de artes marciales en funcionamiento";
    }
}
