<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Paciente</title>
    <link rel="stylesheet" href="styles.css"> <!-- Opcional para estilos -->
</head>
<body>
    <div class="dashboard-container">
        <h1>Dashboard del Paciente</h1>
        <p>Bienvenido, ${sessionScope.nombreUsuario}</p>

        <!-- Tabla de Solicitudes -->
        <h2>Mis Solicitudes de Descanso</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Fecha de Inicio</th>
                    <th>Duración</th>
                    <th>Motivo</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="solicitud" items="${listaSolicitudes}">
                    <tr>
                        <td>${solicitud.id}</td>
                        <td>${solicitud.fechaInicio}</td>
                        <td>${solicitud.duracion} días</td>
                        <td>${solicitud.motivo}</td>
                        <td>${solicitud.estado}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Historial Médico -->
        <h2>Mi Historial Médico</h2>
        <form action="SubirHistorialControlador" method="POST" enctype="multipart/form-data">
            <label for="descripcion">Descripción del Historial:</label>
            <textarea id="descripcion" name="descripcion" required placeholder="Añade una descripción"></textarea>
            
            <label for="archivoHistorial">Subir Archivo:</label>
            <input type="file" id="archivoHistorial" name="archivoHistorial" accept=".pdf,.jpg,.png" required>
            
            <button type="submit">Subir</button>
        </form>

        <h3>Historial Médico Actual</h3>
        <c:if test="${not empty historialMedico}">
            <p>${historialMedico.descripcion}</p>
            <c:if test="${not empty historialMedico.documentoAdjunto}">
                <a href="${historialMedico.documentoAdjunto}" target="_blank">Ver Documento</a>
            </c:if>
        </c:if>
        <c:if test="${empty historialMedico}">
            <p>No tienes un historial médico registrado.</p>
        </c:if>
    </div>
</body>
</html>
