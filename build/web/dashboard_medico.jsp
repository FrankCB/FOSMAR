<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Médico</title>
    <link rel="stylesheet" href="styles.css"> <!-- Opcional para estilos -->
</head>
<body>
    <div class="dashboard-container">
        <h1>Dashboard Médico</h1>
        <p>Bienvenido, Dr. ${sessionScope.nombreUsuario}</p>

        <!-- Tabla de Solicitudes -->
        <h2>Solicitudes de Descanso de Pacientes</h2>
        <table>
            <thead>
                <tr>
                    <th>ID Solicitud</th>
                    <th>Paciente</th>
                    <th>Fecha de Inicio</th>
                    <th>Duración</th>
                    <th>Motivo</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="solicitud" items="${listaSolicitudes}">
                    <tr>
                        <td>${solicitud.id}</td>
                        <td>${solicitud.pacienteNombre}</td>
                        <td>${solicitud.fechaInicio}</td>
                        <td>${solicitud.duracion} días</td>
                        <td>${solicitud.motivo}</td>
                        <td>${solicitud.estado}</td>
                        <td>
                            <a href="VerHistorialMedicoControlador?idUsuario=${solicitud.idPaciente}">Ver Historial Médico</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
