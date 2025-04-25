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

    // manda un correo con el destinatario y el asunto que quememos en el metodo
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

    // Envio de correo de nuevo usuario
    public void avancedEmail(String addresMail) {
        try {
            // Destinatario
            // String addresMail = "samupalo3@gmail.com";

            // Asunto y cuerpo del correo
            String subject = "Bienvenido a nuestra plataforma";
            // Cuerpo del correo
            String bodyMail = """
                    <!DOCTYPE html>
                    <html>
                    <head>
                        <style>
                            body {
                                font-family: 'Arial', sans-serif;
                                background-color: #f9f9f9;
                                margin: 0;
                                padding: 0;
                                color: #333;
                            }
                            .container {
                                max-width: 600px;
                                margin: 30px auto;
                                background-color: #ffffff;
                                border-radius: 10px;
                                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                                overflow: hidden;
                                padding: 20px;
                            }
                            .header {
                                background-color: #4CAF50;
                                color: white;
                                text-align: center;
                                padding: 20px;
                                border-radius: 10px 10px 0 0;
                            }
                            .header h1 {
                                margin: 0;
                                font-size: 24px;
                            }
                            .content {
                                padding: 20px;
                                text-align: left;
                            }
                            .content p {
                                font-size: 16px;
                                margin: 10px 0;
                                line-height: 1.6;
                            }
                            .footer {
                                text-align: center;
                                font-size: 12px;
                                color: #777;
                                margin-top: 20px;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="container">
                            <div class="header">
                                <h1>¡Bienvenido a Nuestra Plataforma!</h1>
                            </div>
                            <div class="content">
                                <p>Hola,</p>
                                <p>Estamos muy felices de darte la bienvenida a nuestra comunidad. Nos alegra que hayas decidido unirte a nosotros.</p>
                                <p>Esperamos que disfrutes de todos los beneficios que ofrecemos y que encuentres lo que necesitas en nuestra plataforma.</p>
                                <p>Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos. Estamos aquí para apoyarte.</p>
                                <p>¡Gracias por confiar en nosotros!</p>
                            </div>
                            <div class="footer">
                                <p>© 2025 Tu Empresa. Todos los derechos reservados.</p>
                            </div>
                        </div>
                    </body>
                    </html>
                    """;
            emailSender(addresMail, subject, bodyMail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // correo para recuperar contraseña
    public void recuperarClave(String addresMail) {
        try {
            // Asunto y cuerpo del correo
            String subject = "Recuperación de contraseña";

            // codigo de recuperación
            String codigo = generarCodigoAleatorio(5);

            // Cuerpo del correo
            String bodyMail = String.format(
                    """
                                        <!DOCTYPE html>
                                        <html>
                                        <head>
                                            <style>
                                                body {
                                                    font-family: 'Arial', sans-serif;
                                                    background-color: #f9f9f9;
                                                    margin: 0;
                                                    padding: 0;
                                                    color: #333;
                                                }
                                                .container {
                                                    max-width: 600px;
                                                    margin: 30px auto;
                                                    background-color: #ffffff;
                                                    border-radius: 10px;
                                                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                                                    overflow: hidden;
                                                    padding: 20px;
                                                }
                                                .header {
                                                    background-color: #FF5722;
                                                    color: white;
                                                    text-align: center;
                                                    padding: 20px;
                                                    border-radius: 10px 10px 0 0;
                                                }
                                                .header h1 {
                                                    margin: 0;
                                                    font-size: 24px;
                                                }
                                                .content {
                                                    padding: 20px;
                                                    text-align: left;
                                                }
                                                .content p {
                                                    font-size: 16px;
                                                    margin: 10px 0;
                                                    line-height: 1.6;
                                                }
                                                .code {
                                                    font-size: 20px;
                                                    font-weight: bold;
                                                    text-align: center;
                                                    background-color: #f4f4f4;
                                                    padding: 10px;
                                                    border-radius: 5px;
                                                    margin: 20px 0;
                                                    color: #FF5722;
                                                }
                                                .footer {
                                                    text-align: center;
                                                    font-size: 12px;
                                                    color: #777;
                                                    margin-top: 20px;
                                                }
                                            </style>
                                        </head>
                                        <body>
                                              <div class="container">
                                <div class="header">
                                    <h1>Recuperación de Contraseña</h1>
                                </div>
                                <div class="content">
                                    <p>Hola,</p>
                                    <p>Recibimos una solicitud para recuperar tu contraseña. Usa el siguiente código para completar el proceso:</p>
                                    <div class="code">%s</div>
                                    <p>Si no solicitaste este cambio, puedes ignorar este correo. Tu cuenta está segura.</p>
                                    <p>Gracias,</p>
                                    <p>El equipo de soporte</p>
                                </div>
                                <div class="footer">
                                    <p>© 2025 Tu Empresa. Todos los derechos reservados.</p>
                                </div>
                            </div>
                                        </body>
                                        </html>
                                        """,
                    codigo);
            emailSender(addresMail, subject, bodyMail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // correo para cambiar la clave
    public void cambiarClave(String addresMail) {
        try {
            // Asunto y cuerpo del correo
            String subject = "Cambio de contraseña";

            // codigo de recuperación
            String codigo = generarCodigoAleatorio(5);

            // Cuerpo del correo
            String bodyMail = String.format(
                    """
                                        <!DOCTYPE html>
                                        <html>
                                        <head>
                                            <style>
                                                body {
                                                    font-family: 'Arial', sans-serif;
                                                    background-color: #f9f9f9;
                                                    margin: 0;
                                                    padding: 0;
                                                    color: #333;
                                                }
                                                .container {
                                                    max-width: 600px;
                                                    margin: 30px auto;
                                                    background-color: #ffffff;
                                                    border-radius: 10px;
                                                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                                                    overflow: hidden;
                                                    padding: 20px;
                                                }
                                                .header {
                                                    background-color: #FF5722;
                                                    color: white;
                                                    text-align: center;
                                                    padding: 20px;
                                                    border-radius: 10px 10px 0 0;
                                                }
                                                .header h1 {
                                                    margin: 0;
                                                    font-size: 24px;
                                                }
                                                .content {
                                                    padding: 20px;
                                                    text-align: left;
                                                }
                                                .content p {
                                                    font-size: 16px;
                                                    margin: 10px 0;
                                                    line-height: 1.6;
                                                }
                                                .code {
                                                    font-size: 20px;
                                                    font-weight: bold;
                                                    text-align: center;
                                                    background-color: #f4f4f4;
                                                    padding: 10px;
                                                    border-radius: 5px;
                                                    margin: 20px 0;
                                                    color: #FF5722;
                                                }
                                                .footer {
                                                    text-align: center;
                                                    font-size: 12px;
                                                    color: #777;
                                                    margin-top: 20px;
                                                }
                                            </style>
                                        </head>
                                        <body>
                                              <div class="container">
                                <div class="header">
                                    <h1>Cambio de Contraseña</h1>
                                </div>
                                <div class="content">
                                    <p>Hola,</p>
                                    <p>Recibimos una solicitud para cambiar tu contraseña. Usa el siguiente código para completar el proceso:</p>
                                    <div class="code">%s</div>
                                    <p>Si no solicitaste este cambio, puedes ignorar este correo. Tu cuenta está segura.</p>
                                    <p>Gracias,</p>
                                    <p>El equipo de soporte</p>
                                </div>
                                <div class="footer">
                                    <p>© 2025 Tu Empresa. Todos los derechos reservados.</p>
                                </div>
                            </div>
                                        </body>
                                        </html>
                                        """,
                    codigo);
            emailSender(addresMail, subject, bodyMail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Envio de correo de activación
    public void activacionEmail(String addresMail) {
        try {

            // Asunto y cuerpo del correo
            String subject = "Activación de correo";

            // Cuerpo del correo
            String bodyMail = """
                        <!DOCTYPE html>
                        <html>
                        <head>
                            <style>
                                body {
                                    font-family: 'Arial', sans-serif;
                                    background-color: #f9f9f9;
                                    margin: 0;
                                    padding: 0;
                                    color: #333;
                                }
                                .container {
                                    max-width: 600px;
                                    margin: 30px auto;
                                    background-color: #ffffff;
                                    border-radius: 10px;
                                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                                    overflow: hidden;
                                    padding: 20px;
                                }
                                .header {
                                    background-color: #2196F3;
                                    color: white;
                                    text-align: center;
                                    padding: 20px;
                                    border-radius: 10px 10px 0 0;
                                }
                                .header h1 {
                                    margin: 0;
                                    font-size: 24px;
                                }
                                .content {
                                    padding: 20px;
                                    text-align: left;
                                }
                                .content p {
                                    font-size: 16px;
                                    margin: 10px 0;
                                    line-height: 1.6;
                                }
                                .footer {
                                    text-align: center;
                                    font-size: 12px;
                                    color: #777;
                                    margin-top: 20px;
                                }
                            </style>
                        </head>
                        <body>
                            <div class="container">
                                <div class="header">
                                    <h1>¡Tu Correo Ha Sido Activado!</h1>
                                </div>
                                <div class="content">
                                    <p>Hola,</p>
                                    <p>Nos complace informarte que tu correo ha sido activado correctamente.</p>
                                    <p>Ya puedes acceder a todos los servicios y funcionalidades disponibles en nuestra plataforma.</p>
                                    <p>Si tienes alguna pregunta o necesitas asistencia, nuestro equipo de soporte está disponible para ayudarte.</p>
                                    <p>¡Bienvenido a bordo!</p>
                                </div>
                                <div class="footer">
                                    <p>© 2025 Tu Empresa. Todos los derechos reservados.</p>
                                </div>
                            </div>
                        </body>
                        </html>
                    """;

            emailSender(addresMail, subject, bodyMail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Envio de correo de compra realizada
    public void compraEmail(String addresMail) {
        try {
            // Destinatario
            // String addresMail = "samupalo3@gmail.com";

            // Asunto y cuerpo del correo
            String subject = "Compra realizada con exito";
            // Cuerpo del correo
            String bodyMail = """
                    <!DOCTYPE html>
                    <html>
                    <head>
                        <style>
                            body {
                                font-family: 'Arial', sans-serif;
                                background-color: #f9f9f9;
                                margin: 0;
                                padding: 0;
                                color: #333;
                            }
                            .container {
                                max-width: 600px;
                                margin: 30px auto;
                                background-color: #ffffff;
                                border-radius: 10px;
                                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                                overflow: hidden;
                                padding: 20px;
                            }
                            .header {
                                background-color: #4CAF50;
                                color: white;
                                text-align: center;
                                padding: 20px;
                                border-radius: 10px 10px 0 0;
                            }
                            .header h1 {
                                margin: 0;
                                font-size: 24px;
                            }
                            .content {
                                padding: 20px;
                                text-align: left;
                            }
                            .content p {
                                font-size: 16px;
                                margin: 10px 0;
                                line-height: 1.6;
                            }
                            .footer {
                                text-align: center;
                                font-size: 12px;
                                color: #777;
                                margin-top: 20px;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="container">
                            <div class="header">
                                <h1>¡Gracias por tu compra!</h1>
                            </div>
                            <div class="content">
                                <p>Hola,</p>
                                <p>Nos complace informarte que tu compra se ha realizado con éxito. A continuación, encontrarás los detalles de tu transacción:</p>
                                <p><strong>Producto:</strong> [Nombre del producto]</p>
                                <p><strong>Precio:</strong> $[Precio]</p>
                                <p><strong>Fecha:</strong> [Fecha de la compra]</p>
                                <p>Si tienes alguna pregunta o necesitas asistencia, no dudes en contactarnos. Estamos aquí para ayudarte.</p>
                                <p>¡Gracias por confiar en nosotros!</p>
                            </div>
                            <div class="footer">
                                <p>© 2025 Tu Empresa. Todos los derechos reservados.</p>
                            </div>
                        </div>
                    </body>
                    </html>
                    """;
            emailSender(addresMail, subject, bodyMail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // methodo para generar un codigo aleatorio
    public static String generarCodigoAleatorio(int longitud) {
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int digito = (int) (Math.random() * 10); // genera un número del 0 al 9
            codigo.append(digito);
        }

        return codigo.toString();
    }

    // Envio de correo para informar stock bajo

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
