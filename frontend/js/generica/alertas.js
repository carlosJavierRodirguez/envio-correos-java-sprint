export function alertas(icono, titulo, texto, options = {}) {
    // Verifica que los parámetros básicos estén definidos y no sean nulos o vacíos
    if (!icono || !titulo || !texto) {
        // console.error("Faltan parámetros para la alerta:", { icono, titulo, texto });
        return;  // No muestra la alerta si hay parámetros faltantes
    }
    Swal.fire({
        icon: icono,
        title: titulo,
        text: texto,
        confirmButtonText: options.confirmButtonText || "Aceptar", // Texto del botón de confirmación
        cancelButtonText: options.cancelButtonText || "Cancelar", // Texto del botón de cancelación
        showCancelButton: options.showCancelButton || false, // Mostrar botón de cancelar
        ...options // Permite pasar opciones adicionales si es necesario
    })
}
