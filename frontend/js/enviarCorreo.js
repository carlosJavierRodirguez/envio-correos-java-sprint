import { urlApi } from "./urlApi.js";
import { peticionesGet } from "./generica/peticionGet.js";
import { alertas } from "./generica/alertas.js";

// Función principal para enviar el correo
async function enviarCorreo() {
    const email = document.getElementById("emailTo").value;
    const tipoNotificacion = document.getElementById("notificationType").value;

    if (!email || !tipoNotificacion) {
        alertas("warning", "Campos incompletos", "Por favor, completa todos los campos requeridos.");
        return;
    }

    // Obtener el botón
    const botonEnviar = document.getElementById("enviarCorreo");

    // Cambiar el texto del botón a "..." para simular que se está enviando el correo
    botonEnviar.textContent = "Enviando...";

    // Desactivar el botón para que no se pueda hacer clic mientras se procesa
    botonEnviar.disabled = true;

    try {
        switch (tipoNotificacion) {
            case "nuevaCuenta":
                await peticionesGet(urlApi.nuevoUsuario, email);
                break;
            case "recuperarClave":
                await peticionesGet(urlApi.clave, email);
                break;
            case "activacionEmail":
                await peticionesGet(urlApi.activacionEmail, email);
                break;
            case "cambiarClave":
                await peticionesGet(urlApi.cambiarClave, email);
                break;
            case "stockBajo":
                await peticionesGet(urlApi.bajoStockEmail, email); // podrías usar productList si es necesario
                break;
            case "compra":
                await peticionesGet(urlApi.compraEmail, email); // podrías usar productList si es necesario
                break;
            default:
                alertas("error", "Tipo inválido", "Tipo de notificación no reconocido.");
                return;
        }

        alertas("success", "Correo enviado", "El correo se ha enviado correctamente.");

        // Limpiar campos
        document.getElementById("emailTo").value = "";
        document.getElementById("notificationType").value = "";

    } catch (error) {
        alertas("error", "Error", "No se pudo enviar el correo: " + error.message);
    } finally {
        // Restaurar el texto del botón a "Enviar Correo"
        botonEnviar.textContent = "Enviar Correo";

        // Habilitar el botón nuevamente
        botonEnviar.disabled = false;
    }
}

// Asociar el evento al botón
document.getElementById("enviarCorreo").addEventListener("click", (e) => {
    e.preventDefault(); // evitar recarga
    enviarCorreo();
});
