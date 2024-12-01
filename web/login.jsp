<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesi�n</title>
    <link rel="stylesheet" href="styles.css"> <!-- Enlace a estilos (opcional) -->
</head>
<body>
    <div class="login-container">
        <h1>Iniciar Sesi�n</h1>
        <form action="LoginControlador" method="POST">
            <!-- Mensaje de error -->
            <c:if test="${not empty error}">
                <p class="error">${error}</p>
            </c:if>
            <!-- Campos de inicio de sesi�n -->
            <div class="form-group">
                <label for="correo">Correo electr�nico:</label>
                <input type="email" id="correo" name="correo" required placeholder="Ingresa tu correo">
            </div>
            <div class="form-group">
                <label for="contrasena">Contrase�a:</label>
                <input type="password" id="contrasena" name="contrasena" required placeholder="Ingresa tu contrase�a">
            </div>
            <!-- Bot�n para enviar -->
            <button type="submit">Iniciar Sesi�n</button>
        </form>
        <!-- Enlace para recuperar contrase�a -->
        <p>�Olvidaste tu contrase�a? <a href="recuperar_contrasena.jsp">Recup�rala aqu�</a></p>
    </div>
</body>
</html>
