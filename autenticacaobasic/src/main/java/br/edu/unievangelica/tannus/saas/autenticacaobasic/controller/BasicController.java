package br.edu.unievangelica.tannus.saas.autenticacaobasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class BasicController {
    
    @GetMapping("protected")
    public String accessProtectedRoute() {
        return "Protected Route";
    }
    
    @GetMapping("free")
    public String accessUnprotectedRoute() {
        return "Free Route";
    }
}
