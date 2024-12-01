
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solicitud de Descanso Médico</title>
    <link rel="stylesheet" href="styles.css"> <!-- Enlace a estilos -->
</head>
<body>
    <div class="form-container">
        <h1>Solicitar Descanso Médico</h1>
        <form action="SolicitudDescansoControlador" method="POST" enctype="multipart/form-data">
            <!-- Campo para la fecha de inicio -->
            <div class="form-group">
                <label for="fecha_inicio">Fecha de Inicio:</label>
                <input type="date" id="fecha_inicio" name="fecha_inicio" required>
            </div>
            <!-- Campo para la duración -->
            <div class="form-group">
                <label for="duracion">Duración (días):</label>
                <input type="number" id="duracion" name="duracion" required min="1" placeholder="Ingrese la duración">
            </div>
            <!-- Campo para el motivo -->
            <div class="form-group">
                <label for="motivo">Motivo:</label>
                <textarea id="motivo" name="motivo" required placeholder="Describa el motivo"></textarea>
            </div>
            <!-- Campo para adjuntar documentos -->
            <div class="form-group">
                <label for="documento_adjunto">Adjuntar Certificado Médico (opcional):</label>
                <input type="file" id="documento_adjunto" name="documento_adjunto" accept=".pdf,.jpg,.png">
            </div>
            <!-- Botón para enviar -->
            <button type="submit">Enviar Solicitud</button>
        </form>
    </div>
</body>
</html>
