-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-01-2026 a las 11:30:46
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `contratos_andalucia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratos`
--

CREATE TABLE `contratos` (
  `nif` varchar(9) NOT NULL,
  `adjudicatario` varchar(30) NOT NULL,
  `objeto_generico` varchar(100) NOT NULL,
  `objeto` varchar(40) NOT NULL,
  `fecha_adjudicacion` datetime DEFAULT NULL,
  `importe` double NOT NULL,
  `tipo_contrato` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `contratos`
--

INSERT INTO `contratos` (`nif`, `adjudicatario`, `objeto_generico`, `objeto`, `fecha_adjudicacion`, `importe`, `tipo_contrato`) VALUES
('B00000001', 'PROVEEDOR 1 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 1', '2016-01-02 00:00:00', 110.5, 'MENOR'),
('B00000002', 'PROVEEDOR 2 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 2', '2016-01-03 00:00:00', 121, 'MENOR'),
('B00000003', 'PROVEEDOR 3 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 3', '2016-01-04 00:00:00', 131.5, 'MENOR'),
('B00000004', 'PROVEEDOR 4 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 4', '2016-01-05 00:00:00', 142, 'MENOR'),
('B00000005', 'PROVEEDOR 5 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 5', '2016-01-06 00:00:00', 152.5, 'MENOR'),
('B00000006', 'PROVEEDOR 6 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 6', '2016-01-07 00:00:00', 163, 'MENOR'),
('B00000007', 'PROVEEDOR 7 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 7', '2016-01-08 00:00:00', 173.5, 'MENOR'),
('B00000008', 'PROVEEDOR 8 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 8', '2016-01-09 00:00:00', 184, 'MENOR'),
('B00000009', 'PROVEEDOR 9 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 9', '2016-01-10 00:00:00', 194.5, 'MENOR'),
('B00000010', 'PROVEEDOR 10 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 10', '2016-01-11 00:00:00', 205, 'MENOR'),
('B00000011', 'PROVEEDOR 11 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 11', '2016-01-12 00:00:00', 215.5, 'MENOR'),
('B00000012', 'PROVEEDOR 12 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 12', '2016-01-13 00:00:00', 226, 'MENOR'),
('B00000013', 'PROVEEDOR 13 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 13', '2016-01-14 00:00:00', 236.5, 'MENOR'),
('B00000014', 'PROVEEDOR 14 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 14', '2016-01-15 00:00:00', 247, 'MENOR'),
('B00000015', 'PROVEEDOR 15 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 15', '2016-01-16 00:00:00', 257.5, 'MENOR'),
('B00000016', 'PROVEEDOR 16 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 16', '2016-01-17 00:00:00', 268, 'MENOR'),
('B00000017', 'PROVEEDOR 17 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 17', '2016-01-18 00:00:00', 278.5, 'MENOR'),
('B00000018', 'PROVEEDOR 18 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 18', '2016-01-19 00:00:00', 289, 'MENOR'),
('B00000019', 'PROVEEDOR 19 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 19', '2016-01-20 00:00:00', 299.5, 'MENOR'),
('B00000020', 'PROVEEDOR 20 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 20', '2016-01-21 00:00:00', 310, 'MENOR'),
('B00000021', 'PROVEEDOR 21 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 21', '2016-01-22 00:00:00', 320.5, 'MENOR'),
('B00000022', 'PROVEEDOR 22 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 22', '2016-01-23 00:00:00', 331, 'MENOR'),
('B00000023', 'PROVEEDOR 23 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 23', '2016-01-24 00:00:00', 341.5, 'MENOR'),
('B00000024', 'PROVEEDOR 24 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 24', '2016-01-25 00:00:00', 352, 'MENOR'),
('B00000025', 'PROVEEDOR 25 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 25', '2016-01-26 00:00:00', 362.5, 'MENOR'),
('B00000026', 'PROVEEDOR 26 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 26', '2016-01-27 00:00:00', 373, 'MENOR'),
('B00000027', 'PROVEEDOR 27 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 27', '2016-01-28 00:00:00', 383.5, 'MENOR'),
('B00000028', 'PROVEEDOR 28 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 28', '2016-01-29 00:00:00', 394, 'MENOR'),
('B00000029', 'PROVEEDOR 29 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 29', '2016-01-30 00:00:00', 404.5, 'MENOR'),
('B00000030', 'PROVEEDOR 30 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 30', '2016-01-31 00:00:00', 415, 'MENOR'),
('B00000031', 'PROVEEDOR 31 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 31', '2016-02-01 00:00:00', 425.5, 'MENOR'),
('B00000032', 'PROVEEDOR 32 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 32', '2016-02-02 00:00:00', 436, 'MENOR'),
('B00000033', 'PROVEEDOR 33 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 33', '2016-02-03 00:00:00', 446.5, 'MENOR'),
('B00000034', 'PROVEEDOR 34 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 34', '2016-02-04 00:00:00', 457, 'MENOR'),
('B00000035', 'PROVEEDOR 35 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 35', '2016-02-05 00:00:00', 467.5, 'MENOR'),
('B00000036', 'PROVEEDOR 36 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 36', '2016-02-06 00:00:00', 478, 'MENOR'),
('B00000037', 'PROVEEDOR 37 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 37', '2016-02-07 00:00:00', 488.5, 'MENOR'),
('B00000038', 'PROVEEDOR 38 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 38', '2016-02-08 00:00:00', 499, 'MENOR'),
('B00000039', 'PROVEEDOR 39 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 39', '2016-02-09 00:00:00', 509.5, 'MENOR'),
('B00000040', 'PROVEEDOR 40 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 40', '2016-02-10 00:00:00', 520, 'MENOR'),
('B00000041', 'PROVEEDOR 41 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 41', '2016-02-11 00:00:00', 530.5, 'MENOR'),
('B00000042', 'PROVEEDOR 42 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 42', '2016-02-12 00:00:00', 541, 'MENOR'),
('B00000043', 'PROVEEDOR 43 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 43', '2016-02-13 00:00:00', 551.5, 'MENOR'),
('B00000044', 'PROVEEDOR 44 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 44', '2016-02-14 00:00:00', 562, 'MENOR'),
('B00000045', 'PROVEEDOR 45 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 45', '2016-02-15 00:00:00', 572.5, 'MENOR'),
('B00000046', 'PROVEEDOR 46 SL', 'MATERIAL FERRETERÍA', 'Objeto del contrato número 46', '2016-02-16 00:00:00', 583, 'MENOR'),
('B00000047', 'PROVEEDOR 47 SL', 'MATERIAL ELECTRICIDAD', 'Objeto del contrato número 47', '2016-02-17 00:00:00', 593.5, 'MENOR'),
('B00000048', 'PROVEEDOR 48 SL', 'MATERIAL DE OFICINA', 'Objeto del contrato número 48', '2016-02-18 00:00:00', 604, 'MENOR'),
('B00000049', 'PROVEEDOR 49 SL', 'MANTENIMIENTO SEDE', 'Objeto del contrato número 49', '2016-02-19 00:00:00', 614.5, 'MENOR'),
('B00000050', 'PROVEEDOR 50 SL', 'ASISTENCIA JURÍDICA', 'Objeto del contrato número 50', '2016-02-20 00:00:00', 625, 'MENOR');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `contratos`
--
ALTER TABLE `contratos`
  ADD PRIMARY KEY (`nif`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
