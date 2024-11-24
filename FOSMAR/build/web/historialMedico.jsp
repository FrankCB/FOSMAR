<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Historial Médico</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            padding: 20px;
        }
        .table-container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .table-container h2 {
            color: #333;
            text-align: center;
        }
        .table-container table {
            width: 100%;
            border-collapse: collapse;
        }
        .table-container th, .table-container td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .table-container th {
            background-color: #007bff;
            color: white;
        }
        .table-container tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <div class="table-container">
        <h2>Historial Médico</h2>
        <table>
            <tr>
                <th>Fecha de Inicio</th>
                <th>Duración</th>
                <th>Motivo</th>
                <th>Estado</th>
            </tr>
            <%-- Aquí se debe cargar el historial desde el controlador --%>
        </table>
    </div>
</body>
</html>
