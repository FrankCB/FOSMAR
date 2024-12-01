<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="styles.css"> <!-- Enlace a estilos (opcional) -->
</head>
<body>
    <div class="login-container">
        <h1>Iniciar Sesión</h1>
        <form action="LoginControlador" method="POST">
            <!-- Mensaje de error -->
            <c:if test="${not empty error}">
                <p class="error">${error}</p>
            </c:if>
            <!-- Campos de inicio de sesión -->
            <div class="form-group">
                <label for="correo">Correo electrónico:</label>
                <input type="email" id="correo" name="correo" required placeholder="Ingresa tu correo">
            </div>
            <div class="form-group">
                <label for="contrasena">Contraseña:</label>
                <input type="password" id="contrasena" name="contrasena" required placeholder="Ingresa tu contraseña">
            </div>
            <!-- Botón para enviar -->
            <button type="submit">Iniciar Sesión</button>
        </form>
        <!-- Enlace para recuperar contraseña -->
        <p>¿Olvidaste tu contraseña? <a href="recuperar_contrasena.jsp">Recupérala aquí</a></p>
    </div>
</body>
</html>
