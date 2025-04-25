package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void basicMail() {
        try {
            // Destinatario
            String addresMail = "samupalo3@gmail.com";
            // Asunto y cuerpo del correo
            String subject = "Este es un correo de prueba";
            // Cuerpo del correo
            String bodyMail = "Correo de prueba";
            emailSender(addresMail, subject, bodyMail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void avancedEmail(String addresMail) {
        try {
            // Destinatario
            // String addresMail = "samupalo3@gmail.com";

            // Asunto y cuerpo del correo
            String subject = "Este es un correo de prueba";
            // Cuerpo del correo
            String bodyMail = "<!DOCTYPE html>\n" + //
                    "<html>\n" + //
                    "<head>\n" + //
                    "    <style>\n" + //
                    "        body {\n" + //
                    "            font-family: Arial, sans-serif;\n" + //
                    "            line-height: 1.6;\n" + //
                    "            color: #333;\n" + //
                    "        }\n" + //
                    "        .container {\n" + //
                    "            max-width: 600px;\n" + //
                    "            margin: 0 auto;\n" + //
                    "            padding: 20px;\n" + //
                    "            border: 1px solid #ddd;\n" + //
                    "            border-radius: 5px;\n" + //
                    "            background-color: #f9f9f9;\n" + //
                    "        }\n" + //
                    "        .header {\n" + //
                    "            text-align: center;\n" + //
                    "            background-color: #4CAF50;\n" + //
                    "            color: white;\n" + //
                    "            padding: 10px 0;\n" + //
                    "            border-radius: 5px 5px 0 0;\n" + //
                    "        }\n" + //
                    "        .content {\n" + //
                    "            padding: 20px;\n" + //
                    "        }\n" + //
                    "        .footer {\n" + //
                    "            text-align: center;\n" + //
                    "            font-size: 12px;\n" + //
                    "            color: #777;\n" + //
                    "            margin-top: 20px;\n" + //
                    "        }\n" + //
                    "        a {\n" + //
                    "            color: #4CAF50;\n" + //
                    "            text-decoration: none;\n" + //
                    "        }\n" + //
                    "    </style>\n" + //
                    "</head>\n" + //
                    "<body>\n" + //
                    "    <div class=\"container\">\n" + //
                    "        <div class=\"header\">\n" + //
                    "            <h1>Correo de Prueba</h1>\n" + //
                    "        </div>\n" + //
                    "        <div class=\"content\">\n" + //
                    "            <p>Hola,</p>\n" + //
                    "            <p>Este es un correo de prueba enviado desde el servicio de correo electrónico.</p>\n"
                    + //
                    "            <p>Si tienes alguna pregunta, no dudes en <a href=\"mailto:soporte@example.com\">contactarnos</a>.</p>\n"
                    + //
                    "            <p>¡Gracias!</p>\n" + //
                    "        </div>\n" + //
                    "        <div class=\"footer\">\n" + //
                    "            <p>© 2025 Tu Empresa. Todos los derechos reservados.</p>\n" + //
                    "        </div>\n" + //
                    "    </div>\n" + //
                    "</body>\n" + //
                    "</html>";
            emailSender(addresMail, subject, bodyMail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean emailSender(String addresMail, String subject, String bodyMail) throws MessagingException {
        try {
            // Creación del correo
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(addresMail);
            helper.setSubject(subject);
            helper.setText(bodyMail, true);
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
