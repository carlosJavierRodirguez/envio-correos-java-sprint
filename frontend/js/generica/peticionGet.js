import { alertas } from "./alertas.js";

/**
 * Función genérica para obtener datos de cualquier API.
 * @param {string} url - URL del endpoint de la API.
 * @param {string} email - Email que se pasa como parámetro en la URL.
 */

export async function peticionesGet(url, email) {
    try {
        const fullUrl = url + email;
        // console.log("Haciendo peticion GET a:", fullUrl);

        const response = await fetch(fullUrl, {
            method: "GET",
            headers: {
                "Accept": "application/json"
            }
        });

        // Verifica si la respuesta es ok
        if (!response.ok) {
            throw new Error(`Error ${response.status}: ${response.statusText}`);
        }

        // Verifica si el tipo de contenido es JSON
        const contentType = response.headers.get("Content-Type");
        if (contentType && contentType.includes("application/json")) {
            const data = await response.json();
            // console.log("Datos obtenidos:", data);

            // Mostrar mensaje de éxito
            alertas("success", "Datos obtenidos", "Los datos se han obtenido correctamente.");
        } else {
            const text = await response.text(); // Si no es JSON, manejarlo como texto
            console.error("Error, se esperaba JSON pero recibimos:", text);
            alertas("error", "Error", "Se esperaba JSON pero no se recibió.");
        }

    } catch (error) {
        // Manejo del error
        alertas("error", "Error", "Ocurrió un error al obtener los datos: " + error.message);
        console.error("Error al obtener los datos:", error);
    }
}

