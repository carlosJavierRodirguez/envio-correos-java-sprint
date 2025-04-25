package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/basicEmail")
    public String sendBasicEmail() {

        emailService.basicMail();

        return "correo enviado";
    }

    @GetMapping("/avancedMail/{email}")
    public String avancedEmail(@PathVariable String email) {

        emailService.avancedEmail(email);

        return "correo enviado";
    }
}
