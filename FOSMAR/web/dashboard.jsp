<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            padding: 20px;
        }
        .dashboard-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        .dashboard-container h2 {
            color: #333;
        }
        .dashboard-container ul {
            list-style-type: none;
            padding: 0;
        }
        .dashboard-container li a {
            display: block;
            padding: 10px;
            margin: 10px 0;
            text-decoration: none;
            color: #007bff;
            border-radius: 4px;
            background-color: #f0f0f0;
        }
        .dashboard-container li a:hover {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="dashboard-container">
        <h2>Bienvenido al Dashboard</h2>
        <ul>
            <li><a href="solicitudDescanso.jsp">Solicitar Descanso Médico</a></li>
            <li><a href="historialMedico.jsp">Ver Historial Médico</a></li>
        </ul>
    </div>
</body>
</html>
