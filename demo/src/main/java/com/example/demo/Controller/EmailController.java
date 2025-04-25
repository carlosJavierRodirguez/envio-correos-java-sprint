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

    // manda un correo con el destinatario y el asunto que quememos en el metodo
    @GetMapping("/basicEmail")
    public String sendBasicEmail() {

        emailService.basicMail();

        return "correo enviado";
    }

    // manda un correo al email de nuevo usuario
    @GetMapping("/nuevoUsuario/{email}")
    public String avancedEmail(@PathVariable String email) {

        emailService.avancedEmail(email);

        return "correo de nuevo usuario enviado";
    }

    // manda un correo al email del usuario con codigo de recuperación
    @GetMapping("/clave/{email}")
    public String recuperarClave(@PathVariable String email) {

        emailService.recuperarClave(email);

        return "correo para recuperar la clave enviado";
    }

    /*
     * manda un correo al email para decirle al usuario que su correo se activo
     * correctamente
     */
    @GetMapping("/activacion/{email}")
    public String activacionEmail(@PathVariable String email) {

        emailService.activacionEmail(email);

        return "Correo para activar la cuenta enviado";
    }

    // envia un correo para cambiar la clave
    @GetMapping("/cambiarClave/{email}")
    public String cambiarClave(@PathVariable String email) {

        emailService.cambiarClave(email);

        return "correo para cambiar la clave enviado";
    }

    // correo para informar que la compra se ha realizado con exito
    @GetMapping("/compraEmail/{email}")
    public String compraEmail(@PathVariable String email) {

        emailService.compraEmail(email);

        return "correo de prueba enviado";
    }
}
