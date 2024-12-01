<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="styles.css"> <!-- Enlace opcional a CSS -->
</head>
<body>
    <div class="dashboard-container">
        <header>
            <h1>Bienvenido, ${sessionScope.nombreUsuario}!</h1>
            <p>Rol: ${sessionScope.rolUsuario}</p>
            <a href="LogoutControlador">Cerrar Sesión</a>
        </header>
        <main>
            <h2>Estadísticas Clave</h2>
            <div class="stats">
                <!-- Ejemplo de estadísticas -->
                <div class="stat">
                    <h3>Descansos Activos</h3>
                    <p>5</p>
                </div>
                <div class="stat">
                    <h3>Solicitudes Pendientes</h3>
                    <p>3</p>
                </div>
                <div class="stat">
                    <h3>Historial Médico Total</h3>
                    <p>12</p>
                </div>
            </div>
            <h2>Accesos Rápidos</h2>
            <nav>
                <ul>
                    <c:if test="${sessionScope.rolUsuario == 'administrador'}">
                        <li><a href="gestionar_usuarios.jsp">Gestionar Usuarios</a></li>
                        <li><a href="solicitudes_pendientes.jsp">Solicitudes Pendientes</a></li>
                    </c:if>
                    <li><a href="solicitud_descanso.jsp">Solicitar Descanso Médico</a></li>
                    <li><a href="historial_medico.jsp">Ver Historial Médico</a></li>
                </ul>
            </nav>
        </main>
    </div>
</body>
</html>
