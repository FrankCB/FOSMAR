<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Solicitud de Descanso Médico</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            padding: 20px;
        }
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .form-container h2 {
            color: #333;
            text-align: center;
        }
        .form-container label {
            display: block;
            margin: 10px 0 5px;
            color: #555;
        }
        .form-container input, .form-container textarea {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ddd;
            margin-bottom: 15px;
        }
        .form-container button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Solicitud de Descanso Médico</h2>
        <form action="SolicitudDescansoControlador" method="POST">
            <label>Fecha de Inicio:</label>
            <input type="date" name="fechaInicio" required>
            <label>Duración (días):</label>
            <input type="number" name="duracionDias" required>
            <label>Motivo:</label>
            <textarea name="motivo" required></textarea>
            <button type="submit">Enviar Solicitud</button>
        </form>
    </div>
</body>
</html>
