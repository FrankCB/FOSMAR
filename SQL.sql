
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 29-11-2024 a las 17:15:41
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fosmar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_medico`
--

DROP TABLE IF EXISTS `historial_medico`;
CREATE TABLE IF NOT EXISTS `historial_medico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `descripcion` text,
  `fecha` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `historial_medico`
--

INSERT INTO `historial_medico` (`id`, `id_usuario`, `descripcion`, `fecha`) VALUES
(1, 4, 'Consulta médica por infección respiratoria. Tratamiento: Amoxicilina 500mg.', '2024-11-15'),
(2, 4, 'Seguimiento de infección respiratoria. Mejoría clínica.', '2024-11-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudes_descanso`
--

DROP TABLE IF EXISTS `solicitudes_descanso`;
CREATE TABLE IF NOT EXISTS `solicitudes_descanso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `fecha_inicio` date NOT NULL,
  `duracion` int NOT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `documento_adjunto` varchar(255) DEFAULT NULL,
  `estado` enum('pendiente','aprobado','rechazado') DEFAULT 'pendiente',
  `creado_en` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `solicitudes_descanso`
--

INSERT INTO `solicitudes_descanso` (`id`, `id_usuario`, `fecha_inicio`, `duracion`, `motivo`, `documento_adjunto`, `estado`, `creado_en`) VALUES
(1, 2, '2024-12-01', 7, 'Descanso por estrés laboral', 'certificado_estres.pdf', 'pendiente', '2024-11-29 17:14:00'),
(2, 4, '2024-11-25', 3, 'Descanso por enfermedad', 'certificado_medico.pdf', 'aprobado', '2024-11-29 17:14:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  `rol` enum('empleado','administrador','medico','paciente') NOT NULL,
  `estado` enum('activo','inactivo') DEFAULT 'activo',
  `creado_en` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `contrasena`, `rol`, `estado`, `creado_en`) VALUES
(1, 'María Pérez', 'admin@fosmar.com', 'admin123', 'administrador', 'activo', '2024-11-29 17:14:00'),
(2, 'Carlos Gómez', 'carlos.gomez@fosmar.com', 'empleado123', 'empleado', 'activo', '2024-11-29 17:14:00'),
(3, 'Dra. Silvia Ortiz', 'silvia.ortiz@fosmar.com', 'medico123', 'medico', 'activo', '2024-11-29 17:14:00'),
(4, 'Luis García', 'luis.garcia@fosmar.com', 'paciente123', 'paciente', 'activo', '2024-11-29 17:14:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- Usar la base de datos
USE fosmar;

-- Insertar un administrador
INSERT INTO usuarios (nombre, correo, contrasena, rol, estado)
VALUES 
('María Pérez', 'admin@fosmar.com', 'admin123', 'administrador', 'activo');

-- Insertar un empleado
INSERT INTO usuarios (nombre, correo, contrasena, rol, estado)
VALUES 
('Carlos Gómez', 'carlos.gomez@fosmar.com', 'empleado123', 'empleado', 'activo');

-- Insertar un médico
INSERT INTO usuarios (nombre, correo, contrasena, rol, estado)
VALUES 
('Dra. Silvia Ortiz', 'silvia.ortiz@fosmar.com', 'medico123', 'medico', 'activo');

-- Insertar un paciente
INSERT INTO usuarios (nombre, correo, contrasena, rol, estado)
VALUES 
('Luis García', 'luis.garcia@fosmar.com', 'paciente123', 'paciente', 'activo');

-- Insertar una solicitud de descanso para el empleado
INSERT INTO solicitudes_descanso (id_usuario, fecha_inicio, duracion, motivo, documento_adjunto, estado)
VALUES 
(2, '2024-12-01', 7, 'Descanso por estrés laboral', 'certificado_estres.pdf', 'pendiente');

-- Insertar otra solicitud de descanso para el paciente
INSERT INTO solicitudes_descanso (id_usuario, fecha_inicio, duracion, motivo, documento_adjunto, estado)
VALUES 
(4, '2024-11-25', 3, 'Descanso por enfermedad', 'certificado_medico.pdf', 'aprobado');

-- Insertar un historial médico para el paciente
INSERT INTO historial_medico (id_usuario, descripcion, fecha)
VALUES 
(4, 'Consulta médica por infección respiratoria. Tratamiento: Amoxicilina 500mg.', '2024-11-15');

-- Insertar otro historial médico para el paciente
INSERT INTO historial_medico (id_usuario, descripcion, fecha)
VALUES 
(4, 'Seguimiento de infección respiratoria. Mejoría clínica.', '2024-11-20');
