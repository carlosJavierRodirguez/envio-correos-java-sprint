package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // manda un correo con el destinatario y el asunto que quememos en el metodo
    @GetMapping("/basicEmail")
    public String sendBasicEmail() {

        emailService.basicMail();

        return "correo enviado";
    }

    // Método corregido para devolver un JSON con ResponseDTO
    @GetMapping("/nuevoUsuario/{email}")
    public ResponseEntity<ResponseDTO> avancedEmail(@PathVariable String email) {
        emailService.avancedEmail(email);

        // Respuesta como objeto ResponseDTO
        ResponseDTO response = new ResponseDTO(
                "Correo de nuevo usuario enviado exitosamente.",
                "success");

        return ResponseEntity.ok(response); // Retorna un JSON
    }

    // Manda un correo al email del usuario con código de recuperación
    @GetMapping("/clave/{email}")
    public ResponseEntity<ResponseDTO> recuperarClave(@PathVariable String email) {
        emailService.recuperarClave(email);

        // Retornar la respuesta en formato JSON
        ResponseDTO response = new ResponseDTO("Correo para recuperar la clave enviado", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Manda un correo al email para decirle al usuario que su correo se activó
    // correctamente
    @GetMapping("/activacion/{email}")
    public ResponseEntity<ResponseDTO> activacionEmail(@PathVariable String email) {
        emailService.activacionEmail(email);

        // Retornar la respuesta en formato JSON
        ResponseDTO response = new ResponseDTO("Correo para activar la cuenta enviado", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Envía un correo para cambiar la clave
    @GetMapping("/cambiarClave/{email}")
    public ResponseEntity<ResponseDTO> cambiarClave(@PathVariable String email) {
        emailService.cambiarClave(email);

        // Retornar la respuesta en formato JSON
        ResponseDTO response = new ResponseDTO("Correo para cambiar la clave enviado", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Correo para informar que la compra se ha realizado con éxito
    @GetMapping("/compraEmail/{email}")
    public ResponseEntity<ResponseDTO> compraEmail(@PathVariable String email) {
        emailService.compraEmail(email);

        // Retornar la respuesta en formato JSON
        ResponseDTO response = new ResponseDTO("Correo de prueba enviado", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Correo para informar que el stock de los productos está bajo
    @GetMapping("/bajoStock/{email}")
    public ResponseEntity<ResponseDTO> bajoStockEmail(@PathVariable String email) {
        emailService.bajoStockEmail(email);

        // Retornar la respuesta en formato JSON
        ResponseDTO response = new ResponseDTO("Correo de bajo Stock enviado", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
