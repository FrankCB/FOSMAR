<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Historial Médico</title>
    <link rel="stylesheet" href="styles.css"> <!-- Estilo opcional -->
</head>
<body>
    <div class="historial-container">
        <h1>Historial Médico</h1>
        <!-- Mensaje de éxito/error -->
        <c:if test="${not empty success}">
            <p class="success">${success}</p>
        </c:if>
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>

        <!-- Tabla de solicitudes -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Fecha Inicio</th>
                    <th>Duración (días)</th>
                    <th>Motivo</th>
                    <th>Estado</th>
                    <th>Documento</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="solicitud" items="${listaSolicitudes}">
                    <tr>
                        <td>${solicitud.id}</td>
                        <td>${solicitud.fechaInicio}</td>
                        <td>${solicitud.duracion}</td>
                        <td>${solicitud.motivo}</td>
                        <td>${solicitud.estado}</td>
                        <td>
                            <c:if test="${not empty solicitud.documentoAdjunto}">
                                <a href="${solicitud.documentoAdjunto}" target="_blank">Ver Documento</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
