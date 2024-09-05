-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-09-2024 a las 19:37:50
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
-- Base de datos: `bdmunitransporte`
--
CREATE DATABASE IF NOT EXISTS `bdmunitransporte` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bdmunitransporte`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE `permiso` (
  `id_Permiso` int(11) NOT NULL,
  `id_SolicitudPermiso` int(11) NOT NULL,
  `FechaEntrega` date NOT NULL,
  `FechaVencimiento` date NOT NULL,
  `Estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personajuridica`
--

CREATE TABLE `personajuridica` (
  `id_personaJuridica` int(11) NOT NULL,
  `RazonSocial` varchar(255) DEFAULT NULL,
  `Representante_legal_Nombre` varchar(50) DEFAULT NULL,
  `Representante_legal_Apellidos` varchar(150) NOT NULL,
  `NumeroDocumentoRL` varchar(12) NOT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `linkFirma` varchar(255) DEFAULT NULL,
  `id_TipoDOc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `personajuridica`
--

INSERT INTO `personajuridica` (`id_personaJuridica`, `RazonSocial`, `Representante_legal_Nombre`, `Representante_legal_Apellidos`, `NumeroDocumentoRL`, `ubicacion`, `linkFirma`, `id_TipoDOc`) VALUES
(1, 'EMPRESA DE TRNSPORTE V&C ', 'Maria ', 'Fernandez Catpo', '736638381234', 'jr. San Martin S/N', 'Firma Maria Fernandez', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `requisitossolicitud`
--

CREATE TABLE `requisitossolicitud` (
  `id_RequisitosSolicitud` int(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `requisitossolicitud`
--

INSERT INTO `requisitossolicitud` (`id_RequisitosSolicitud`, `descripcion`) VALUES
(1, 'Copia simple de la escritura pública de constitución'),
(2, 'Copia literal vigente de la partida registral'),
(3, 'Certificado de Vigencia de Poder'),
(4, 'Copia simple del Documento Nacional de Identidad (DNI)'),
(5, 'Copia simple de la Tarjeta de Identificación Vehicular (SUNARP)'),
(6, 'Copia simple de certificado del SOAT o CAT vigente'),
(7, 'Copia simple del CITV cuando corresponda');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudpermiso`
--

CREATE TABLE `solicitudpermiso` (
  `id_SolicitudPermiso` int(100) NOT NULL,
  `id_personaJuridica` int(12) NOT NULL,
  `UsuarioID` int(100) NOT NULL,
  `FechaSolicitud` date NOT NULL,
  `Estado` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `solicitudpermiso`
--

INSERT INTO `solicitudpermiso` (`id_SolicitudPermiso`, `id_personaJuridica`, `UsuarioID`, `FechaSolicitud`, `Estado`) VALUES
(1, 1, 1, '2024-05-02', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudrequisito`
--

CREATE TABLE `solicitudrequisito` (
  `id_solicitudRequisitos` int(11) NOT NULL,
  `SolicitudPermisoID` int(100) DEFAULT NULL,
  `RequisitosSolicitudID` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `id_TipoDoc` int(11) NOT NULL,
  `nombreDocumento` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`id_TipoDoc`, `nombreDocumento`) VALUES
(1, 'DNI'),
(2, 'RUC');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE `tipousuario` (
  `id_tipoUsuarios` int(100) NOT NULL,
  `tipoUsuarioNombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`id_tipoUsuarios`, `tipoUsuarioNombre`) VALUES
(1, 'Funcionario'),
(2, 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_Usuario` int(11) NOT NULL,
  `nombreCompleto` varchar(100) NOT NULL,
  `Apellidos` varchar(200) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `numeroCelular` varchar(9) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fecha` date DEFAULT NULL,
  `id_tipoUsuario` int(100) NOT NULL,
  `estado` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_Usuario`, `nombreCompleto`, `Apellidos`, `DNI`, `direccion`, `numeroCelular`, `Correo`, `password`, `fecha`, `id_tipoUsuario`, `estado`) VALUES
(1, 'Antoni', 'Valle Magallan', '76026413', 'jr. Jorge Chavez S/N', '931269677', 'avallemagallan@gmail.com', '1234', '2024-05-02', 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `id_Vehiculo` int(100) NOT NULL,
  `Placa` varchar(20) DEFAULT NULL,
  `color` varchar(20) NOT NULL,
  `AnoFabricacion` varchar(5) NOT NULL,
  `Marca` varchar(50) DEFAULT NULL,
  `numeroSerie` varchar(20) NOT NULL,
  `Modelo` varchar(50) DEFAULT NULL,
  `id_personaJuridica` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id_Vehiculo`, `Placa`, `color`, `AnoFabricacion`, `Marca`, `numeroSerie`, `Modelo`, `id_personaJuridica`) VALUES
(1, '883838', 'azul', '2013', 'onda', '23j3u939', 'mmmjhsh', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD PRIMARY KEY (`id_Permiso`),
  ADD KEY `id_SolicitudPermiso` (`id_SolicitudPermiso`);

--
-- Indices de la tabla `personajuridica`
--
ALTER TABLE `personajuridica`
  ADD PRIMARY KEY (`id_personaJuridica`),
  ADD KEY `id_TipoDOc` (`id_TipoDOc`);

--
-- Indices de la tabla `requisitossolicitud`
--
ALTER TABLE `requisitossolicitud`
  ADD PRIMARY KEY (`id_RequisitosSolicitud`);

--
-- Indices de la tabla `solicitudpermiso`
--
ALTER TABLE `solicitudpermiso`
  ADD PRIMARY KEY (`id_SolicitudPermiso`),
  ADD KEY `UsuarioID` (`UsuarioID`),
  ADD KEY `id_personaJuridica` (`id_personaJuridica`);

--
-- Indices de la tabla `solicitudrequisito`
--
ALTER TABLE `solicitudrequisito`
  ADD PRIMARY KEY (`id_solicitudRequisitos`),
  ADD KEY `RequisitosSolicitudID` (`RequisitosSolicitudID`),
  ADD KEY `SolicitudPermisoID` (`SolicitudPermisoID`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`id_TipoDoc`);

--
-- Indices de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`id_tipoUsuarios`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_Usuario`),
  ADD KEY `id_tipoUsuario` (`id_tipoUsuario`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`id_Vehiculo`),
  ADD KEY `id_personaJuridica` (`id_personaJuridica`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `permiso`
--
ALTER TABLE `permiso`
  MODIFY `id_Permiso` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personajuridica`
--
ALTER TABLE `personajuridica`
  MODIFY `id_personaJuridica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `requisitossolicitud`
--
ALTER TABLE `requisitossolicitud`
  MODIFY `id_RequisitosSolicitud` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `solicitudpermiso`
--
ALTER TABLE `solicitudpermiso`
  MODIFY `id_SolicitudPermiso` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `solicitudrequisito`
--
ALTER TABLE `solicitudrequisito`
  MODIFY `id_solicitudRequisitos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  MODIFY `id_TipoDoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  MODIFY `id_tipoUsuarios` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `id_Vehiculo` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD CONSTRAINT `permiso_ibfk_1` FOREIGN KEY (`id_SolicitudPermiso`) REFERENCES `solicitudpermiso` (`id_SolicitudPermiso`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `personajuridica`
--
ALTER TABLE `personajuridica`
  ADD CONSTRAINT `personajuridica_ibfk_1` FOREIGN KEY (`id_TipoDOc`) REFERENCES `tipodocumento` (`id_TipoDoc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `solicitudpermiso`
--
ALTER TABLE `solicitudpermiso`
  ADD CONSTRAINT `solicitudpermiso_ibfk_3` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`id_Usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `solicitudpermiso_ibfk_4` FOREIGN KEY (`id_personaJuridica`) REFERENCES `personajuridica` (`id_personaJuridica`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `solicitudrequisito`
--
ALTER TABLE `solicitudrequisito`
  ADD CONSTRAINT `solicitudrequisito_ibfk_1` FOREIGN KEY (`RequisitosSolicitudID`) REFERENCES `requisitossolicitud` (`id_RequisitosSolicitud`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `solicitudrequisito_ibfk_2` FOREIGN KEY (`SolicitudPermisoID`) REFERENCES `solicitudpermiso` (`id_SolicitudPermiso`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_tipoUsuario`) REFERENCES `tipousuario` (`id_tipoUsuarios`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`id_personaJuridica`) REFERENCES `personajuridica` (`id_personaJuridica`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Base de datos: `dbarchivos`
--
CREATE DATABASE IF NOT EXISTS `dbarchivos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbarchivos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anios`
--

CREATE TABLE `anios` (
  `anio_id` int(11) NOT NULL,
  `anio` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `anios`
--

INSERT INTO `anios` (`anio_id`, `anio`) VALUES
(1, '2023'),
(2, '2022');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `areas`
--

CREATE TABLE `areas` (
  `area_id` int(11) NOT NULL,
  `nombre_area` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `areas`
--

INSERT INTO `areas` (`area_id`, `nombre_area`) VALUES
(1, 'Imagen'),
(2, 'Registro Civil'),
(3, 'Administracion'),
(4, 'Defensa Civil'),
(5, 'Logistica'),
(6, 'Recursos Humanos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documentos`
--

CREATE TABLE `documentos` (
  `documento_id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `libro_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  `tipo_documento_id` int(11) DEFAULT NULL,
  `folio` int(11) DEFAULT NULL,
  `fecha_subida` date DEFAULT NULL,
  `ruta` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `documentos`
--

INSERT INTO `documentos` (`documento_id`, `nombre`, `libro_id`, `usuario_id`, `tipo_documento_id`, `folio`, `fecha_subida`, `ruta`) VALUES
(1, 'Informe de practicas', 2, 1, 3, 25, '2024-04-09', 'C:\\Users\\ASUS\\Documents\\Sistema de Control de Archivos/2023/Imagen/Archivador 002/Informe/modelo de plan de practicas pre profesionalesSGAP1.pdf'),
(2, 'csca', 1, 1, 1, 123, '2024-04-09', 'C:\\Users\\ASUS\\Documents\\Sistema de Control de Archivos/2024/Imagen/Archivador 001/Solicitud Simple/Doc1SGAP1.pdf'),
(3, 'csca', 1, 1, 1, 123, '2024-04-09', 'C:\\Users\\ASUS\\Documents\\Sistema de Control de Archivos/2024/Imagen/Archivador 001/Solicitud Simple/Doc1SGAP2.pdf'),
(4, '', 4, 1, 4, 20, '2024-04-09', 'C:\\Users\\ASUS\\Documents\\Sistema de Control de Archivos/2023/Registro Civil/Archivador L001/Carta/modelo de plan de practicas pre profesionalesSGAP3.pdf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estantes`
--

CREATE TABLE `estantes` (
  `estante_id` int(11) NOT NULL,
  `nombre_estante` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `estantes`
--

INSERT INTO `estantes` (`estante_id`, `nombre_estante`) VALUES
(1, 'Estante 001'),
(2, 'Estante 002'),
(3, 'Estante 003'),
(4, 'Estante 004'),
(5, 'Estante 005');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `libro_id` int(11) NOT NULL,
  `nombre_libro` varchar(50) DEFAULT NULL,
  `area_id` int(11) DEFAULT NULL,
  `anio_id` int(11) NOT NULL,
  `estante_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`libro_id`, `nombre_libro`, `area_id`, `anio_id`, `estante_id`) VALUES
(1, 'Archivador 001', 1, 1, 1),
(2, 'Archivador 002', 1, 2, 1),
(3, 'Archivador 25', 1, 2, 3),
(4, 'Archivador L001', 2, 2, 5),
(5, 'Archvivador RC 002', 2, 2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paneles`
--

CREATE TABLE `paneles` (
  `panel_id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paneles`
--

INSERT INTO `paneles` (`panel_id`, `nombre`) VALUES
(1, 'btn_fileManager'),
(2, 'btn_usuarios'),
(3, 'btn_tipoUsuario'),
(4, 'btn_mantenimiento'),
(5, 'btn_cagarDoc'),
(6, 'btn_Reportes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilegios`
--

CREATE TABLE `privilegios` (
  `privilegio_id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `estado` varchar(11) NOT NULL DEFAULT 'ACTIVO',
  `tipo_usuario_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `privilegios`
--

INSERT INTO `privilegios` (`privilegio_id`, `nombre`, `estado`, `tipo_usuario_id`) VALUES
(1, 'btn_fileManager', 'ACTIVO', 1),
(2, 'btn_usuarios', 'ACTIVO', 1),
(3, 'btn_tipoUsuario', 'ACTIVO', 1),
(4, 'btn_mantenimiento', 'ACTIVO', 1),
(5, 'btn_cagarDoc', 'ACTIVO', 1),
(6, 'btn_fileManager', 'ACTIVO', 2),
(7, 'btn_usuarios', 'ACTIVO', 2),
(8, 'btn_tipoUsuario', 'ACTIVO', 2),
(9, 'btn_mantenimiento', 'ACTIVO', 2),
(10, 'btn_cagarDoc', 'ACTIVO', 2),
(11, 'btn_fileManager', 'ACTIVO', 3),
(12, 'btn_usuarios', 'ACTIVO', 3),
(13, 'btn_tipoUsuario', 'ACTIVO', 3),
(14, 'btn_mantenimiento', 'ACTIVO', 3),
(15, 'btn_cagarDoc', 'ACTIVO', 3),
(16, 'btn_fileManager', 'ACTIVO', 4),
(17, 'btn_usuarios', 'ACTIVO', 4),
(18, 'btn_tipoUsuario', 'ACTIVO', 4),
(19, 'btn_mantenimiento', 'INACTIVO', 4),
(20, 'btn_cagarDoc', 'ACTIVO', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposdocumentos`
--

CREATE TABLE `tiposdocumentos` (
  `tipo_documento_id` int(11) NOT NULL,
  `nombre_tipo_documento` varchar(50) DEFAULT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tiposdocumentos`
--

INSERT INTO `tiposdocumentos` (`tipo_documento_id`, `nombre_tipo_documento`, `descripcion`) VALUES
(1, 'Solicitud Simple', 'Formato 1'),
(2, 'Solicitud Compuesto', 'Tipo de documento necesaario'),
(3, 'Informe', 'Informe'),
(4, 'Carta', '01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `tipo_usuario_id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`tipo_usuario_id`, `nombre`) VALUES
(1, 'Administrador'),
(2, 'Invitado'),
(3, 'a'),
(4, 'Secretaria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(120) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tipoUsuario_id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL,
  `estado` varchar(10) NOT NULL DEFAULT 'ACTIVO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellidos`, `email`, `tipoUsuario_id`, `usuario`, `password`, `estado`) VALUES
(1, 'Administrador', 'ad', 'admin@gmail.com', 1, 'admin', 'admin', 'ACTIVO'),
(2, 'invitado', 'invitado', 'invitado', 2, 'invitado', 'invitado', 'ACTIVO'),
(7, 'juana', 'gil', 'juana@gmail.com', 1, 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'ACTIVO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anios`
--
ALTER TABLE `anios`
  ADD PRIMARY KEY (`anio_id`);

--
-- Indices de la tabla `areas`
--
ALTER TABLE `areas`
  ADD PRIMARY KEY (`area_id`);

--
-- Indices de la tabla `documentos`
--
ALTER TABLE `documentos`
  ADD PRIMARY KEY (`documento_id`);

--
-- Indices de la tabla `estantes`
--
ALTER TABLE `estantes`
  ADD PRIMARY KEY (`estante_id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`libro_id`);

--
-- Indices de la tabla `paneles`
--
ALTER TABLE `paneles`
  ADD PRIMARY KEY (`panel_id`);

--
-- Indices de la tabla `privilegios`
--
ALTER TABLE `privilegios`
  ADD PRIMARY KEY (`privilegio_id`);

--
-- Indices de la tabla `tiposdocumentos`
--
ALTER TABLE `tiposdocumentos`
  ADD PRIMARY KEY (`tipo_documento_id`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`tipo_usuario_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `anios`
--
ALTER TABLE `anios`
  MODIFY `anio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `areas`
--
ALTER TABLE `areas`
  MODIFY `area_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `documentos`
--
ALTER TABLE `documentos`
  MODIFY `documento_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `estantes`
--
ALTER TABLE `estantes`
  MODIFY `estante_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `libro_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `paneles`
--
ALTER TABLE `paneles`
  MODIFY `panel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `privilegios`
--
ALTER TABLE `privilegios`
  MODIFY `privilegio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `tiposdocumentos`
--
ALTER TABLE `tiposdocumentos`
  MODIFY `tipo_documento_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `tipo_usuario_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Base de datos: `dbsystem_001`
--
CREATE DATABASE IF NOT EXISTS `dbsystem_001` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbsystem_001`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `archivo`
--

CREATE TABLE `archivo` (
  `id_archivo` int(11) NOT NULL,
  `id_ussuario` int(11) NOT NULL,
  `id_tipo_archivo` int(11) NOT NULL,
  `destino` int(11) NOT NULL,
  `titulo` varchar(60) NOT NULL,
  `asunto` varchar(100) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `archivo` varchar(50) NOT NULL,
  `id_prioridad` int(11) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_modificacion` varchar(20) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perona`
--

CREATE TABLE `perona` (
  `id_persona` int(11) NOT NULL,
  `razon_social` varchar(60) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prioridad_archivo`
--

CREATE TABLE `prioridad_archivo` (
  `id_prioridad` int(11) NOT NULL,
  `prioridad` varchar(20) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `rol` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_archivo`
--

CREATE TABLE `tipo_archivo` (
  `id_tipo_archivo` int(11) NOT NULL,
  `tipo_archvo` varchar(30) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `archivo`
--
ALTER TABLE `archivo`
  ADD PRIMARY KEY (`id_archivo`),
  ADD KEY `fk_id_usuario` (`id_ussuario`),
  ADD KEY `fk_id_prioridad` (`id_prioridad`),
  ADD KEY `fk_destino` (`destino`),
  ADD KEY `fk_id_tipo_archivo` (`id_tipo_archivo`);

--
-- Indices de la tabla `perona`
--
ALTER TABLE `perona`
  ADD PRIMARY KEY (`id_persona`);

--
-- Indices de la tabla `prioridad_archivo`
--
ALTER TABLE `prioridad_archivo`
  ADD PRIMARY KEY (`id_prioridad`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `tipo_archivo`
--
ALTER TABLE `tipo_archivo`
  ADD PRIMARY KEY (`id_tipo_archivo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_id_persona` (`id_persona`),
  ADD KEY `fk_id_rol` (`id_rol`),
  ADD KEY `fk_id_person` (`id_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `archivo`
--
ALTER TABLE `archivo`
  MODIFY `id_archivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `perona`
--
ALTER TABLE `perona`
  MODIFY `id_persona` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `prioridad_archivo`
--
ALTER TABLE `prioridad_archivo`
  MODIFY `id_prioridad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_archivo`
--
ALTER TABLE `tipo_archivo`
  MODIFY `id_tipo_archivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `archivo`
--
ALTER TABLE `archivo`
  ADD CONSTRAINT `archivo_ibfk_1` FOREIGN KEY (`destino`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `perona`
--
ALTER TABLE `perona`
  ADD CONSTRAINT `perona_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `usuario` (`id_persona`);

--
-- Filtros para la tabla `prioridad_archivo`
--
ALTER TABLE `prioridad_archivo`
  ADD CONSTRAINT `prioridad_archivo_ibfk_1` FOREIGN KEY (`id_prioridad`) REFERENCES `archivo` (`id_prioridad`);

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `rol_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `usuario` (`id_rol`);

--
-- Filtros para la tabla `tipo_archivo`
--
ALTER TABLE `tipo_archivo`
  ADD CONSTRAINT `tipo_archivo_ibfk_1` FOREIGN KEY (`id_tipo_archivo`) REFERENCES `archivo` (`id_tipo_archivo`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `archivo` (`id_ussuario`);
--
-- Base de datos: `dbsystem_002`
--
CREATE DATABASE IF NOT EXISTS `dbsystem_002` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbsystem_002`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `razonsocial` varchar(50) NOT NULL,
  `ruc` varchar(12) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` int(11) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `razonsocial`, `ruc`, `direccion`, `telefono`, `estado`) VALUES
(1, 'Multiservicios Mayanga', '0912435645', 'calle avenida bagua jr.1243', 975761665, 1),
(2, 'pedidos ya rsc', '3245678921', 'callejos bagua la capital', 987456321, 1),
(3, 'loper', '346678', 'rergrgeththe', 867495, 1),
(4, 'Sermucaj ', '12345678910', 'Jr.Heores del Cenepa 2023', 900589123, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ticket`
--

CREATE TABLE `detalle_ticket` (
  `iddt` int(11) NOT NULL,
  `idTicket` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `dias` int(11) NOT NULL,
  `horas` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(11,2) NOT NULL,
  `total` decimal(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_ticket`
--

INSERT INTO `detalle_ticket` (`iddt`, `idTicket`, `descripcion`, `dias`, `horas`, `cantidad`, `precio`, `total`) VALUES
(1, 6, 'Jk Cesar Llaguento Carlos', 4, 0, 0, 3.00, 12.00),
(2, 6, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(3, 6, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(4, 7, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 4.00, 32.00),
(5, 7, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(6, 7, 'Excavadora de orugas Caterpill', 2, 8, 14, 300.00, 4800.00),
(7, 8, 'Jk Cesar Llaguento Carlos', 4, 0, 0, 4.00, 16.00),
(8, 8, 'Excavadora de orugas Caterpill', 2, 8, 0, 300.00, 4800.00),
(9, 8, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(10, 9, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 2.00, 4.00),
(11, 9, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(12, 9, 'Excavadora de orugas Caterpill', 2, 8, 1, 300.00, 4800.00),
(13, 10, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 4.00, 5.00),
(14, 10, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(15, 10, '', 0, 0, 14, 0.00, 0.00),
(16, 11, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 4.00, 12.00),
(17, 11, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(18, 12, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(19, 12, 'Excavadora de orugas Caterpill', 2, 8, 1, 300.00, 4800.00),
(20, 12, 'Jk Cesar Llaguento Carlos', 3, 0, 1, 4.00, 5.00),
(21, 13, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 3.00, 4.00),
(22, 13, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(23, 14, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 4.00, 12.00),
(24, 14, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(25, 14, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(26, 14, 'Excavadora de orugas Caterpill', 2, 8, 1, 300.00, 4800.00),
(27, 14, '', 0, 0, 1, 0.00, 0.00),
(28, 15, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 23.00, 45.00),
(29, 15, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(30, 15, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(31, 15, 'Excavadora de orugas Caterpill', 2, 8, 14, 300.00, 4800.00),
(32, 16, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(33, 16, 'Jk Cesar Llaguento Carlos', 4, 0, 1, 4.00, 12.00),
(34, 16, 'Excavadora de orugas Caterpill', 2, 8, 1, 300.00, 4800.00),
(35, 17, 'Romina Carrasco Silva ', 4, 0, 0, 40.00, 160.00),
(36, 17, 'Excavadora de orugas Caterpill', 2, 8, 0, 300.00, 4800.00),
(37, 17, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(38, 17, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(39, 18, 'Jk Cesar Llaguento Carlos', 4, 0, 0, 50.00, 200.00),
(40, 18, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(41, 18, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(42, 18, 'Excavadora de orugas Caterpill', 2, 8, 14, 300.00, 4800.00),
(43, 19, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 4.00, 8.00),
(44, 19, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(45, 19, 'Excavadora de orugas Caterpill', 2, 8, 1, 300.00, 4800.00),
(46, 20, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 4.00, 12.00),
(47, 20, 'Cemento Apu ', 0, 0, 14, 25.00, 350.00),
(48, 20, 'Excavadora de orugas Caterpill', 2, 8, 14, 300.00, 4800.00),
(49, 20, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(50, 21, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 40.00, 120.00),
(51, 21, 'Clavo de calamina acerado de 3', 0, 0, 1, 4.00, 2.00),
(52, 22, 'Clavo de calamina acerado de 3', 0, 0, 3, 4.00, 12.00),
(53, 22, 'Cemento Apu ', 0, 0, 3, 25.00, 75.00),
(54, 22, 'Jk Cesar Llaguento Carlos', 3, 0, 3, 3.00, 9.00),
(55, 22, 'Excavadora de orugas Caterpill', 2, 8, 3, 300.00, 4800.00),
(56, 23, 'Jk Cesar Llaguento Carlos', 3, 0, 0, 4.00, 12.00),
(57, 23, 'Taladro eléctrico', 1, 3, 0, 40.00, 120.00),
(58, 23, 'Espuma de poliuretano', 0, 0, 17, 25.00, 425.00),
(59, 24, 'Canaletas de Plástico', 0, 0, 4, 4.00, 16.00),
(60, 25, 'Canaletas de Plástico', 0, 0, 4, 4.00, 16.00),
(61, 26, 'Espuma de poliuretano', 0, 0, 4, 25.00, 100.00),
(62, 26, 'Generadores', 2, 8, 4, 300.00, 4800.00),
(63, 26, 'Romina Carrasco Silva ', 3, 0, 4, 4.00, 23.00),
(64, 27, 'Eduin Flores', 2, 8, 20, 15.50, 200.00),
(65, 28, 'Aislante térmico', 0, 0, 4, 20.00, 80.00),
(66, 28, 'Generadores', 2, 8, 4, 300.00, 4800.00),
(67, 28, 'Canaletas de Plástico', 0, 0, 6, 4.00, 24.00),
(68, 28, 'Espuma de poliuretano', 0, 0, 20, 25.00, 500.00),
(69, 29, 'Canaletas de Plástico', 0, 0, 20, 4.00, 80.00),
(70, 29, 'Aislante térmico', 0, 0, 20, 20.00, 400.00),
(71, 29, 'Espuma de poliuretano', 0, 0, 5, 25.00, 125.00),
(72, 30, 'Motor eléctrico', 1, 3, 0, 40.00, 120.00),
(73, 31, 'Canaletas de Plástico', 0, 0, 2, 4.00, 8.00),
(74, 31, 'Espuma de poliuretano', 0, 0, 3, 25.00, 75.00),
(75, 31, 'Aislante térmico', 0, 0, 4, 20.00, 80.00),
(76, 31, 'Aislante térmico', 0, 0, 16, 20.00, 320.00),
(77, 31, 'Canaletas de Plástico', 0, 0, 2, 4.00, 8.00),
(78, 31, 'Espuma de poliuretano', 0, 0, 4, 25.00, 100.00),
(79, 32, 'Daniel Tejada', 1, 0, 16, 15.60, 200.00),
(80, 33, 'Canaletas de Plástico', 0, 0, 5, 4.00, 20.00),
(81, 34, 'Daniel Tejada', 1, 0, 0, 11.50, 200.00),
(82, 35, 'Canaletas de Plástico', 0, 0, 8, 4.00, 32.00),
(83, 36, 'Espuma de poliuretano', 0, 0, 13, 25.00, 325.00),
(84, 36, 'Aislante térmico', 0, 0, 1, 20.00, 20.00),
(85, 37, 'Espuma de poliuretano', 0, 0, 15, 25.00, 375.00),
(86, 38, 'Espuma de poliuretano', 0, 0, 2, 25.00, 50.00),
(87, 39, 'Aislante térmico', 0, 0, 5, 20.00, 100.00),
(88, 40, 'Aislante térmico', 0, 0, 2, 20.00, 40.00),
(89, 41, 'Aislante térmico', 0, 0, 1, 20.00, 20.00),
(90, 42, 'Carlos Rivera Rivera', 5, 0, 0, 80.00, 400.00),
(91, 43, 'Carlos Rivera Rivera', 5, 0, 0, 80.00, 400.00),
(92, 44, 'Aislante térmico', 0, 0, 7, 20.00, 140.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquina`
--

CREATE TABLE `maquina` (
  `id` int(11) NOT NULL,
  `maquina` varchar(50) NOT NULL,
  `estado` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `maquina`
--

INSERT INTO `maquina` (`id`, `maquina`, `estado`) VALUES
(1, 'Generadores', 1),
(2, 'Motor eléctrico', 1),
(3, 'Transformadores', 1),
(4, 'Taladro eléctrico', 1),
(5, 'Corta tubos', 1),
(6, 'Formon', 1),
(7, 'Maquinas de Rebobinado', 1),
(15, 'Talador de mesa', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquinaria`
--

CREATE TABLE `maquinaria` (
  `idMaquinaria` int(11) NOT NULL,
  `idprove` int(11) NOT NULL,
  `fecha` varchar(15) NOT NULL,
  `serie` varchar(11) NOT NULL,
  `numero` varchar(11) NOT NULL,
  `idmaquina` int(11) NOT NULL,
  `horas` varchar(15) NOT NULL,
  `dias` varchar(15) NOT NULL,
  `precio_hora` decimal(11,2) NOT NULL,
  `total` decimal(11,2) NOT NULL,
  `fecha_inicio` varchar(11) NOT NULL,
  `fecha_fin` varchar(11) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `maquinaria`
--

INSERT INTO `maquinaria` (`idMaquinaria`, `idprove`, `fecha`, `serie`, `numero`, `idmaquina`, `horas`, `dias`, `precio_hora`, `total`, `fecha_inicio`, `fecha_fin`, `estado`) VALUES
(1, 1, '09-11-2023', '001', 'N° 000001', 1, '8', '2', 300.00, 4800.00, '10-11-2023', '11-11-2023', 1),
(2, 2, '23-01-2024', '003', 'N°00021', 4, '3', '1', 40.00, 120.00, '23-01-2024', '23-01-2024', 1),
(3, 5, '09-02-2024', '001', 'N°0000002', 3, '5', '2', 35.00, 350.00, '09-02-2024', '11-02-2024', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `idMaterial` int(11) NOT NULL,
  `idprove` int(11) NOT NULL,
  `fecha_ingreso` varchar(11) NOT NULL,
  `serie` varchar(11) NOT NULL,
  `numero` varchar(11) NOT NULL,
  `idproducto` int(11) NOT NULL,
  `cantidad` varchar(10) NOT NULL,
  `stock_final` int(11) NOT NULL,
  `idunidad` int(11) NOT NULL,
  `precio` decimal(11,2) NOT NULL,
  `total` decimal(11,2) NOT NULL,
  `estado` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`idMaterial`, `idprove`, `fecha_ingreso`, `serie`, `numero`, `idproducto`, `cantidad`, `stock_final`, `idunidad`, `precio`, `total`, `estado`) VALUES
(1, 2, '08-11.2023', '001', 'N° 000001', 1, '20', 0, 1, 4.00, 2.00, 0),
(2, 1, '08-11-2023', '001', 'N° 000002', 2, '20', 2, 1, 25.00, 350.00, 1),
(3, 2, '22-01-2024', '002', 'N° 000345', 3, '20', 2, 3, 20.00, 120.00, 1),
(4, 6, '24-02-2024', '001', 'N°000001', 1, '45', 45, 1, 20.00, 900.00, 1),
(5, 1, '24-02-2024', '002', 'N°000002', 6, '45', 45, 2, 20.00, 900.00, 1),
(6, 1, '24-02-2024', '0003', 'N°00003', 2, '40', 40, 1, 20.00, 900.00, 1),
(7, 1, '24-02-2024', '0004', 'N°000004', 4, '40', 40, 1, 20.00, 900.00, 1),
(8, 1, '24-02-204', '0001', 'N°00001', 1, '15', 15, 1, 10.00, 150.00, 1),
(9, 1, '24-02-2024', '0001', 'N°0000002', 1, '40', 40, 1, 20.00, 800.00, 1),
(10, 1, '24-02-2024', '0002', 'N°0000002', 1, '60', 60, 1, 20.00, 130.00, 1),
(11, 1, '24-02-2024', '0001', 'N°000001', 1, '10', 10, 1, 10.00, 100.00, 1),
(12, 1, '24-02-2024', '0002', 'N°000002', 1, '40', 40, 1, 20.00, 900.00, 1),
(13, 1, '23-02-2024', '0001', 'N°000001', 1, '80', 80, 1, 50.00, 20.00, 1),
(14, 1, '09-09-2024', '001', 'N° 000021', 3, '32', 32, 1, 23.00, 21.00, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `num_dni` int(8) NOT NULL,
  `direccion` varchar(32) NOT NULL,
  `telefono` int(9) NOT NULL,
  `correo` varchar(32) NOT NULL,
  `es_civil` varchar(11) NOT NULL,
  `hijo` varchar(11) NOT NULL,
  `can_hijo` int(9) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `estado` int(10) NOT NULL,
  `fecha_ingreso` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idpersona`, `nombre`, `num_dni`, `direccion`, `telefono`, `correo`, `es_civil`, `hijo`, `can_hijo`, `sexo`, `estado`, `fecha_ingreso`) VALUES
(1, 'Jk Cesar Llaguento Carlos', 65743892, 'Buenos Aires - Bagua - Amazonas', 975761665, 'llaguentocarloscesar96@gmail.com', 'soltero', 'NO', 0, 'M', 0, '2024-02-19 22:15:55'),
(2, 'Roger Altamirano ', 65743892, 'Bagua - Amazonas', 975761665, 'altamirano@gmail.com', 'Soltero', 'NO', 0, 'M', 0, '2024-02-20 21:25:25'),
(3, 'Romina Carrasco Tejada', 65743892, 'Cajamarca', 975761665, 'carrascosilva@gmail.com', 'Viudo', 'NO', 0, 'F', 1, '2024-02-09 17:33:40'),
(4, 'Merlyn Marin', 98701243, 'Trita - Amazonas', 987456321, 'marin@gmail.com', 'Soltero', 'NO', 0, 'M', 0, '2024-02-02 22:06:07'),
(5, 'Jorge Luis Mayanga Castro', 42361641, 'Av. Bagua N° 3241', 987123654, 'mayanga@gmail.com', 'Casado', 'SI', 1, 'M', 0, '2024-02-02 22:06:13'),
(6, 'Carlos Rivera Rivera', 89764523, 'Huancayo', 908567432, 'carlosrivera', 'Soltero', 'SI', 1, 'M', 1, '2024-02-02 21:49:44'),
(7, 'Cristian Rodrigues Carrasco', 56431289, 'Av. Mariano Melgar N° 3524', 213765489, 'cristian@gmail.com', 'Viudo', 'SI', 0, 'M', 1, '2024-02-02 21:49:48'),
(8, 'Flor Pileña', 90876543, 'Huancayo', 123456789, 'florpileña@gmail.com', 'Casado', 'SI', 4, 'F', 1, '2024-02-02 21:49:51'),
(9, 'Sociedad de Julica', 21345678, 'Julica-Perú-lima', 123456789, 'sociedad@gmail.com', 'Casado', 'SI', 4, 'M', 1, '2024-02-02 21:49:55'),
(10, 'Juan Carlos Rivera', 9876534, 'Jaen-Peú', 321432879, 'juancarlos@gmail.com', 'Casado', 'SI', 5, 'M', 1, '2024-02-02 21:49:58'),
(11, 'Jose Acuña Rivera', 43643622, 'Cajamarca - Perú', 353524523, 'acuñarivera@gmail.com', 'Viudo', 'SI', 23, 'M', 0, '2024-02-20 21:25:38'),
(12, 'Pepe Goicochea Bobadilla', 23456789, 'Luya - Amazonas', 123456987, 'pepe@gmail.com', 'Casado', 'SI', 3, 'M', 0, '2024-02-19 22:16:17'),
(13, 'Daniel Tejada', 71590653, 'Jr.Antunez de mayolo', 900514825, 'tejada_2017@hotmail.com', 'Soltero', 'NO', 0, 'M', 0, '2024-02-09 17:33:05'),
(14, 'pepepe', 123456, ' fbgngng', 654321, 'eetegegdwgwg', 'Viudo', 'SI', 4, 'M', 0, '2024-02-02 22:05:49'),
(15, 'Eduin Flores', 20256312, 'JR.Madre de Dios ', 900800512, 'flores_2023@hotmail.com', 'Soltero', 'NO', 0, 'M', 0, '2024-02-19 22:16:03'),
(16, 'Juan Perez ', 123456789, 'jr. Miraflores n°123', 900456789, 'j_p@gmail.com', 'Divorsiado', 'NO', 0, 'M', 0, '2024-02-09 17:33:12'),
(17, 'Pablo Teran', 1615178, 'Av.Heroes del Cenepa n°1613', 945456123, 'teran_12@gmail.com', 'Casado', 'SI', 2, 'M', 1, '2024-02-20 21:47:58');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `producto` varchar(50) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `producto`, `estado`) VALUES
(1, 'Canaletas de Plástico', 1),
(2, 'Espuma de poliuretano', 1),
(3, 'Aislante térmico', 1),
(4, 'Tubos de Cobre', 1),
(5, 'Aislante térmico 02', 1),
(6, 'Tarjeta Universal', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idprove` int(11) NOT NULL,
  `razonsocial` varchar(30) NOT NULL,
  `ruc` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idprove`, `razonsocial`, `ruc`, `direccion`, `telefono`) VALUES
(1, 'Multiservicios Mayanga', '912435645', 'Buenos Aires - Bagua - Amazona', 975761665),
(2, 'Inmobiliaria Jhony', '1234567890', 'Buenos Aires - Bagua - Amazona', 975761665),
(3, 'Consorcio Constructor JLContru', '10483351521', 'Bagua - Amazonas - Perú', 975761665),
(4, 'Pulga Producciones SA', '4321456781', 'Luya - Chachapoyas - Perú', 908765432),
(5, 'Admision 2023', '3245768901', 'bagua', 99999999),
(6, 'Sermucaj', '1234578910', 'Jr. Amazonas', 900541789);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `rol` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `rol`) VALUES
(1, 'admin'),
(2, 'empleado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `idT` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `serie` varchar(11) NOT NULL,
  `numero` varchar(11) NOT NULL,
  `subtotal` decimal(11,2) NOT NULL,
  `total` decimal(11,2) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ticket`
--

INSERT INTO `ticket` (`idT`, `idUsuario`, `idCliente`, `serie`, `numero`, `subtotal`, `total`, `fecha`) VALUES
(1, 1, 1, '0001', '0000001', 4810.00, 4810.00, '2023-11-20 21:28:02'),
(2, 1, 1, '0001', '000002', 5164.00, 5164.00, '2023-11-20 21:35:35'),
(3, 1, 1, '0001', '000003', 5176.00, 5176.00, '2023-11-20 21:44:04'),
(4, 1, 1, '0001', '000004', 5172.00, 5172.00, '2023-11-20 21:47:35'),
(5, 1, 1, '0001', '000005', 360.00, 360.00, '2023-11-20 21:49:17'),
(6, 1, 1, '0001', '000006', 364.00, 364.00, '2023-11-20 22:06:40'),
(7, 1, 1, 'F0001', '000007', 5182.00, 5182.00, '2023-11-21 01:29:22'),
(8, 1, 1, 'F0001', '000008', 4818.00, 4818.00, '2023-11-21 01:30:53'),
(9, 1, 1, 'F0001', '000009', 4806.00, 4806.00, '2023-11-21 01:35:17'),
(10, 1, 1, 'F0001', '0000010', 355.00, 355.00, '2023-11-21 01:40:09'),
(11, 1, 1, 'F0001', '0000010', 362.00, 362.00, '2023-11-21 01:44:44'),
(12, 1, 1, 'F0001', '0000010', 4807.00, 4807.00, '2023-11-21 01:48:22'),
(13, 1, 1, 'F0001', '0000010', 354.00, 354.00, '2023-11-21 01:50:22'),
(14, 1, 1, 'F0001', '0000010', 5164.00, 5164.00, '2023-11-21 03:50:57'),
(15, 1, 1, 'F0001', '0000010', 5197.00, 5197.00, '2023-11-21 04:13:46'),
(16, 1, 1, 'F0001', '0016', 4814.00, 4814.00, '2023-11-21 04:20:04'),
(17, 1, 1, 'F0001', '00017', 5312.00, 5312.00, '2023-11-21 06:38:16'),
(18, 1, 1, 'F0001', '00018', 5352.00, 5352.00, '2023-11-21 06:40:44'),
(19, 1, 2, 'F0001', '00019', 4810.00, 4810.00, '2023-11-27 19:16:31'),
(20, 1, 1, 'F0001', '00020', 5164.00, 5164.00, '2023-11-27 19:28:19'),
(21, 3, 1, 'F0001', '00021', 4922.00, 4922.00, '2023-11-27 21:08:37'),
(22, 1, 1, 'F0001', '00022', 4896.00, 4896.00, '2024-01-17 17:47:24'),
(23, 1, 1, 'F0001', '00023', 557.00, 557.00, '2024-01-22 20:59:41'),
(24, 4, 1, 'F0001', '00024', 16.00, 16.00, '2024-01-24 23:50:22'),
(25, 4, 1, 'F0001', '00025', 16.00, 16.00, '2024-01-24 23:51:18'),
(26, 4, 2, 'F0001', '00026', 4923.00, 4923.00, '2024-02-02 19:58:30'),
(27, 4, 1, 'F0001', '00027', 200.00, 200.00, '2024-02-07 01:42:21'),
(28, 4, 1, 'F0001', '00028', 5404.00, 5404.00, '2024-02-08 00:25:36'),
(29, 4, 1, 'F0001', '00029', 605.00, 605.00, '2024-02-09 05:30:43'),
(30, 4, 1, 'F0001', '00030', 120.00, 120.00, '2024-02-09 05:53:03'),
(31, 4, 1, 'F0001', '00031', 591.00, 591.00, '2024-02-09 17:23:01'),
(32, 4, 1, 'F0001', '00032', 200.00, 200.00, '2024-02-09 17:26:31'),
(33, 4, 1, 'F0001', '00033', 20.00, 20.00, '2024-02-09 17:27:14'),
(34, 4, 1, 'F0001', '00034', 200.00, 200.00, '2024-02-09 17:28:09'),
(35, 4, 2, 'F0001', '00035', 32.00, 32.00, '2024-02-09 17:38:47'),
(36, 4, 3, 'F0001', '00036', 345.00, 345.00, '2024-02-09 17:39:23'),
(37, 4, 2, 'F0001', '00037', 375.00, 375.00, '2024-02-19 22:34:57'),
(38, 4, 1, 'F0001', '00038', 50.00, 50.00, '2024-02-19 22:37:35'),
(39, 4, 1, 'F0001', '00039', 100.00, 100.00, '2024-02-19 22:39:06'),
(40, 4, 1, 'F0001', '00040', 40.00, 40.00, '2024-02-19 22:42:16'),
(41, 4, 1, 'F0001', '00041', 20.00, 20.00, '2024-02-19 22:46:19'),
(42, 6, 1, 'F0001', '00042', 400.00, 400.00, '2024-02-20 21:51:56'),
(43, 6, 3, 'F0001', '00043', 400.00, 400.00, '2024-02-20 21:52:58'),
(44, 6, 1, 'F0001', '00044', 140.00, 140.00, '2024-02-20 21:53:50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad_medida`
--

CREATE TABLE `unidad_medida` (
  `id` int(11) NOT NULL,
  `unidad_medida` varchar(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `unidad_medida`
--

INSERT INTO `unidad_medida` (`id`, `unidad_medida`, `descripcion`) VALUES
(1, 'Kg', 'Kilogramos'),
(2, 'L', 'Litro'),
(3, 'U', 'Unidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `passwor` int(15) NOT NULL,
  `idrol` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  `estado` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `passwor`, `idrol`, `idpersona`, `estado`) VALUES
(1, 'jkcesar', 1234, 1, 1, 1),
(2, 'Pedro', 12345, 1, 2, 0),
(3, 'marin', 12345, 2, 1, 1),
(4, 'Tejada', 2023, 1, 13, 1),
(5, 'Flores', 2023, 2, 15, 0),
(6, 'Teran', 2024, 1, 17, 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_maquina`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_maquina` (
`id` int(11)
,`razonsocial` varchar(30)
,`fecha` varchar(15)
,`serie` varchar(11)
,`numero` varchar(11)
,`maquina` varchar(50)
,`horas` varchar(15)
,`dias` varchar(15)
,`precio_hora` decimal(11,2)
,`total` decimal(11,2)
,`fecha_inicio` varchar(11)
,`fecha_fin` varchar(11)
,`estado` int(11)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_material`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_material` (
`id` int(11)
,`razonsocial` varchar(30)
,`fecha_ingreso` varchar(11)
,`serie` varchar(11)
,`numero` varchar(11)
,`material` varchar(50)
,`cantidad` varchar(10)
,`stock_final` int(11)
,`unidad_medida` varchar(11)
,`precio` decimal(11,2)
,`total` decimal(11,2)
,`estado` int(2)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_ticket`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_ticket` (
`idT` int(11)
,`nombre` varchar(50)
,`razonsocial` varchar(50)
,`ruc` varchar(12)
,`direccion` varchar(100)
,`telefono` int(11)
,`serie` varchar(11)
,`numero` varchar(11)
,`subtotal` decimal(11,2)
,`total` decimal(11,2)
,`fecha` timestamp
,`descripcion` varchar(30)
,`dias` int(11)
,`horas` int(11)
,`cantidad` int(11)
,`precio` decimal(11,2)
,`total_de` decimal(11,2)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_usuario`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_usuario` (
`id` int(11)
,`nombre` varchar(50)
,`usuario` varchar(15)
,`passwor` int(15)
,`rol` varchar(11)
,`estado` int(2)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_maquina`
--
DROP TABLE IF EXISTS `vista_maquina`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_maquina`  AS SELECT `m`.`idMaquinaria` AS `id`, `pr`.`razonsocial` AS `razonsocial`, `m`.`fecha` AS `fecha`, `m`.`serie` AS `serie`, `m`.`numero` AS `numero`, `ma`.`maquina` AS `maquina`, `m`.`horas` AS `horas`, `m`.`dias` AS `dias`, `m`.`precio_hora` AS `precio_hora`, `m`.`total` AS `total`, `m`.`fecha_inicio` AS `fecha_inicio`, `m`.`fecha_fin` AS `fecha_fin`, `m`.`estado` AS `estado` FROM ((`maquinaria` `m` join `proveedor` `pr` on(`m`.`idprove` = `pr`.`idprove`)) join `maquina` `ma` on(`ma`.`id` = `m`.`idMaquinaria`)) WHERE `m`.`estado` = 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_material`
--
DROP TABLE IF EXISTS `vista_material`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_material`  AS SELECT `m`.`idMaterial` AS `id`, `pr`.`razonsocial` AS `razonsocial`, `m`.`fecha_ingreso` AS `fecha_ingreso`, `m`.`serie` AS `serie`, `m`.`numero` AS `numero`, `p`.`producto` AS `material`, `m`.`cantidad` AS `cantidad`, `m`.`stock_final` AS `stock_final`, `u`.`unidad_medida` AS `unidad_medida`, `m`.`precio` AS `precio`, `m`.`total` AS `total`, `m`.`estado` AS `estado` FROM (((`material` `m` join `proveedor` `pr` on(`m`.`idprove` = `pr`.`idprove`)) join `producto` `p` on(`m`.`idproducto` = `p`.`id`)) join `unidad_medida` `u` on(`u`.`id` = `m`.`idunidad`)) WHERE `m`.`estado` = 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_ticket`
--
DROP TABLE IF EXISTS `vista_ticket`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_ticket`  AS SELECT `t`.`idT` AS `idT`, `p`.`nombre` AS `nombre`, `c`.`razonsocial` AS `razonsocial`, `c`.`ruc` AS `ruc`, `c`.`direccion` AS `direccion`, `c`.`telefono` AS `telefono`, `t`.`serie` AS `serie`, `t`.`numero` AS `numero`, `t`.`subtotal` AS `subtotal`, `t`.`total` AS `total`, `t`.`fecha` AS `fecha`, `d`.`descripcion` AS `descripcion`, `d`.`dias` AS `dias`, `d`.`horas` AS `horas`, `d`.`cantidad` AS `cantidad`, `d`.`precio` AS `precio`, `d`.`total` AS `total_de` FROM ((((`ticket` `t` join `usuario` `u` on(`t`.`idUsuario` = `u`.`id`)) join `persona` `p` on(`p`.`idpersona` = `u`.`idpersona`)) join `cliente` `c` on(`t`.`idCliente` = `c`.`id`)) join `detalle_ticket` `d` on(`d`.`idTicket` = `t`.`idT`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_usuario`
--
DROP TABLE IF EXISTS `vista_usuario`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_usuario`  AS SELECT `u`.`id` AS `id`, `p`.`nombre` AS `nombre`, `u`.`usuario` AS `usuario`, `u`.`passwor` AS `passwor`, `r`.`rol` AS `rol`, `u`.`estado` AS `estado` FROM ((`usuario` `u` join `persona` `p` on(`u`.`idpersona` = `p`.`idpersona`)) join `rol` `r` on(`r`.`id` = `u`.`idrol`)) WHERE `u`.`estado` = 1 ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle_ticket`
--
ALTER TABLE `detalle_ticket`
  ADD PRIMARY KEY (`iddt`),
  ADD KEY `fk_ticket` (`idTicket`);

--
-- Indices de la tabla `maquina`
--
ALTER TABLE `maquina`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `maquinaria`
--
ALTER TABLE `maquinaria`
  ADD PRIMARY KEY (`idMaquinaria`),
  ADD KEY `fk_proveedor` (`idprove`),
  ADD KEY `fk_maqui` (`idmaquina`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`idMaterial`),
  ADD KEY `fk_idprove` (`idprove`),
  ADD KEY `fk_unidad` (`idunidad`),
  ADD KEY `fk_produ` (`idproducto`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idpersona`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idprove`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idT`),
  ADD KEY `fk_usuar` (`idUsuario`),
  ADD KEY `fk_cliente` (`idCliente`);

--
-- Indices de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_rol` (`idrol`),
  ADD KEY `fkpersona` (`idpersona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `detalle_ticket`
--
ALTER TABLE `detalle_ticket`
  MODIFY `iddt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT de la tabla `maquina`
--
ALTER TABLE `maquina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `maquinaria`
--
ALTER TABLE `maquinaria`
  MODIFY `idMaquinaria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `idMaterial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idprove` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `idT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ticket`
--
ALTER TABLE `detalle_ticket`
  ADD CONSTRAINT `detalle_ticket_ibfk_2` FOREIGN KEY (`idTicket`) REFERENCES `ticket` (`idT`);

--
-- Filtros para la tabla `maquinaria`
--
ALTER TABLE `maquinaria`
  ADD CONSTRAINT `maquinaria_ibfk_1` FOREIGN KEY (`idprove`) REFERENCES `proveedor` (`idprove`),
  ADD CONSTRAINT `maquinaria_ibfk_2` FOREIGN KEY (`idmaquina`) REFERENCES `maquina` (`id`);

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`idprove`) REFERENCES `proveedor` (`idprove`),
  ADD CONSTRAINT `material_ibfk_2` FOREIGN KEY (`idunidad`) REFERENCES `unidad_medida` (`id`),
  ADD CONSTRAINT `material_ibfk_3` FOREIGN KEY (`idproducto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`),
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`idrol`) REFERENCES `rol` (`id`);
--
-- Base de datos: `dbsystem_003`
--
CREATE DATABASE IF NOT EXISTS `dbsystem_003` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbsystem_003`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacen`
--

CREATE TABLE `almacen` (
  `IdAlmacen` int(11) NOT NULL,
  `IdArticulo` int(20) NOT NULL,
  `IdSede` int(20) NOT NULL,
  `Cantidad` int(40) NOT NULL,
  `FechaIngresoPro` date NOT NULL,
  `FechaSalidaPro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `IdArticulo` int(11) NOT NULL,
  `idMarca` int(11) NOT NULL,
  `idModelo` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `articulo` varchar(40) NOT NULL,
  `Descripcion` varchar(30) NOT NULL,
  `Estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`IdArticulo`, `idMarca`, `idModelo`, `idCategoria`, `articulo`, `Descripcion`, `Estado`) VALUES
(1, 2, 2, 1, 'laptop lenovo ', 'maquina de escritorio', 1),
(2, 2, 1, 2, 'roja', 'perfecto estado', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

CREATE TABLE `cargo` (
  `idCargo` int(11) NOT NULL,
  `cargo` varchar(20) NOT NULL,
  `estado` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`idCargo`, `cargo`, `estado`) VALUES
(1, 'Administrador', 1),
(2, 'Almacen', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `IdCategoria` int(11) NOT NULL,
  `NombreCategoria` varchar(20) NOT NULL,
  `Estado` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`IdCategoria`, `NombreCategoria`, `Estado`) VALUES
(1, 'Laptop', 1),
(2, 'Carpeta', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(11) NOT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `nunDocumento` varchar(15) NOT NULL,
  `razonSocial` varchar(150) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Telefono` int(12) NOT NULL,
  `fechaingreso` datetime NOT NULL,
  `email` varchar(50) NOT NULL,
  `idCargo` int(11) DEFAULT NULL,
  `Estado` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `idTipoDocumento`, `nunDocumento`, `razonSocial`, `Direccion`, `Telefono`, `fechaingreso`, `email`, `idCargo`, `Estado`) VALUES
(1, 1, '77889900', 'SEGUNDO AUGUSTO CHUQUIZUTA TAFUR', 'LIMA - PERÚ', 789465374, '2021-10-28 00:00:00', 'llaguentocarloscesar96@gmail', 1, 0),
(3, 3, '71784597', 'CESAR LLAGUENTO CARLOS', 'Jr. Progreso #125', 935545378, '2021-11-04 00:00:00', '71784597@untrm.edu.pe', NULL, 0),
(4, 1, '98748576', 'Juan Perez', 'jr cedroz S/N', 857412548, '2021-11-05 00:00:00', '98748576@untrm.edu.pe', NULL, 1),
(5, 2, '74752548', 'LUIS VALQUI', 'TALARA - PIURA', 963987954, '0002-11-30 00:00:00', 'luisval@gmail.com', NULL, 1),
(9, 1, '78968574', 'Rosa Gomez', 'lamud', 963987954, '0002-11-30 00:00:00', 'rosa@gmail.com', NULL, 0),
(10, 1, '78974152', 'Juan Angulo', 'luya', 963963954, '0000-00-00 00:00:00', 'oiujuan@gmail.com', NULL, 1),
(11, 1, '123456', 'Juan Purta', 'parco', 123465, '2021-11-02 00:00:00', 'juan@gmail.com', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `IdMarca` int(11) NOT NULL,
  `NombreMarca` varchar(20) NOT NULL,
  `Estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`IdMarca`, `NombreMarca`, `Estado`) VALUES
(1, 'Lenovo', 1),
(2, 'Hp', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modelo`
--

CREATE TABLE `modelo` (
  `idModelo` int(11) NOT NULL,
  `modelo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `modelo`
--

INSERT INTO `modelo` (`idModelo`, `modelo`) VALUES
(1, 'x30'),
(2, 'Akg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sede`
--

CREATE TABLE `sede` (
  `IdSede` int(11) NOT NULL,
  `NombreSede` varchar(35) NOT NULL,
  `Ubicacion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sede`
--

INSERT INTO `sede` (`IdSede`, `NombreSede`, `Ubicacion`) VALUES
(1, 'Talara', 'Jr. jose  olaya S/N'),
(2, 'Lima', 'Jr. Coriconcha #1625'),
(3, 'Cusco', 'Jr. Libertad #5879');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `IdTipoDocumento` int(11) NOT NULL,
  `TipoDocumento` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`IdTipoDocumento`, `TipoDocumento`) VALUES
(1, 'DNI'),
(2, 'RUC'),
(3, 'PASAPORTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `IdUsuario` int(11) NOT NULL,
  `Usuario` varchar(10) NOT NULL,
  `Clave` varchar(15) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`IdUsuario`, `Usuario`, `Clave`, `idEmpleado`, `estado`) VALUES
(1, 'dark', '0506', 1, 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_articulo`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_articulo` (
`IdArticulo` int(11)
,`NombreMarca` varchar(20)
,`modelo` varchar(50)
,`NombreCategoria` varchar(20)
,`articulo` varchar(40)
,`Descripcion` varchar(30)
,`Estado` tinyint(1)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_empleado`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_empleado` (
`IdEmpleado` int(11)
,`TipoDocumento` varchar(15)
,`nunDocumento` varchar(15)
,`razonSocial` varchar(150)
,`Direccion` varchar(100)
,`Telefono` int(12)
,`fechaingreso` datetime
,`email` varchar(50)
,`Estado` tinyint(2)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_usuario`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_usuario` (
`IdUsuario` int(11)
,`Usuario` varchar(10)
,`Clave` varchar(15)
,`razonSocial` varchar(150)
,`cargo` varchar(20)
,`estado` tinyint(4)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_articulo`
--
DROP TABLE IF EXISTS `vista_articulo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_articulo`  AS SELECT `a`.`IdArticulo` AS `IdArticulo`, `m`.`NombreMarca` AS `NombreMarca`, `n`.`modelo` AS `modelo`, `c`.`NombreCategoria` AS `NombreCategoria`, `a`.`articulo` AS `articulo`, `a`.`Descripcion` AS `Descripcion`, `a`.`Estado` AS `Estado` FROM (((`articulo` `a` join `marca` `m` on(`a`.`idMarca` = `m`.`IdMarca`)) join `modelo` `n` on(`a`.`idModelo` = `n`.`idModelo`)) join `categoria` `c` on(`a`.`idCategoria` = `c`.`IdCategoria`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_empleado`
--
DROP TABLE IF EXISTS `vista_empleado`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_empleado`  AS SELECT `e`.`IdEmpleado` AS `IdEmpleado`, `t`.`TipoDocumento` AS `TipoDocumento`, `e`.`nunDocumento` AS `nunDocumento`, `e`.`razonSocial` AS `razonSocial`, `e`.`Direccion` AS `Direccion`, `e`.`Telefono` AS `Telefono`, `e`.`fechaingreso` AS `fechaingreso`, `e`.`email` AS `email`, `e`.`Estado` AS `Estado` FROM (`empleado` `e` join `tipo_documento` `t` on(`e`.`idTipoDocumento` = `t`.`IdTipoDocumento`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_usuario`
--
DROP TABLE IF EXISTS `vista_usuario`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_usuario`  AS SELECT `u`.`IdUsuario` AS `IdUsuario`, `u`.`Usuario` AS `Usuario`, `u`.`Clave` AS `Clave`, `e`.`razonSocial` AS `razonSocial`, `c`.`cargo` AS `cargo`, `u`.`estado` AS `estado` FROM ((`usuarios` `u` join `empleado` `e` on(`u`.`idEmpleado` = `e`.`IdEmpleado`)) join `cargo` `c` on(`c`.`idCargo` = `e`.`idCargo`)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacen`
--
ALTER TABLE `almacen`
  ADD PRIMARY KEY (`IdAlmacen`);

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`IdArticulo`),
  ADD KEY `fk_marca` (`idMarca`),
  ADD KEY `fk_modelo` (`idModelo`),
  ADD KEY `fk_categoria` (`idCategoria`);

--
-- Indices de la tabla `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idCargo`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`IdCategoria`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`),
  ADD KEY `fk_idCargo` (`idCargo`),
  ADD KEY `fk_tipoDocumento` (`idTipoDocumento`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`IdMarca`);

--
-- Indices de la tabla `modelo`
--
ALTER TABLE `modelo`
  ADD PRIMARY KEY (`idModelo`);

--
-- Indices de la tabla `sede`
--
ALTER TABLE `sede`
  ADD PRIMARY KEY (`IdSede`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`IdTipoDocumento`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`IdUsuario`),
  ADD KEY `fk_empleado` (`idEmpleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `almacen`
--
ALTER TABLE `almacen`
  MODIFY `IdAlmacen` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `IdArticulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idCargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `IdCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `IdMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `modelo`
--
ALTER TABLE `modelo`
  MODIFY `idModelo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sede`
--
ALTER TABLE `sede`
  MODIFY `IdSede` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `IdTipoDocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `IdUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `fk_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`IdCategoria`),
  ADD CONSTRAINT `fk_marca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`IdMarca`),
  ADD CONSTRAINT `fk_modelo` FOREIGN KEY (`idModelo`) REFERENCES `modelo` (`idModelo`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_idCargo` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`),
  ADD CONSTRAINT `fk_tipoDocumento` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipo_documento` (`IdTipoDocumento`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`IdEmpleado`);
--
-- Base de datos: `dbsystem_004`
--
CREATE DATABASE IF NOT EXISTS `dbsystem_004` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbsystem_004`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_modela` int(11) NOT NULL,
  `caracteristicas` varchar(100) NOT NULL,
  `id_unidad` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha registró` varchar(20) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `id` int(11) NOT NULL,
  `marca` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id`, `marca`) VALUES
(1, 'Lenovo'),
(2, 'HP'),
(3, 'Dell'),
(4, 'Apple'),
(5, 'Asus'),
(6, 'Acer'),
(7, 'MSI'),
(8, 'Huawei');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `razonsocial` varchar(100) NOT NULL,
  `num_dni` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `razonsocial`, `num_dni`, `direccion`, `telefono`, `correo`, `estado`) VALUES
(1, 'Cesar Uribe Llaguento Carlos', 48335152, 'Buenos Aires - el Parco - Bagua - Amazonas', '935914551', 'llaguentocarloscesar96@gmail.com', 1),
(2, 'Segundo Augusto Chuquizuta Tafur', 71791050, 'Luya Viejo - Luya - Chachapoyas - Amazonas', '956393952', '7178105081@untrm.edu.pe', 1),
(3, 'Edwin Flores Delgado', 76465221, 'La Primavera - Bagua - Amazonas', '932798440', '7646522172@untrm.edu.pe', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `producto` varchar(50) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `caracteristicas` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `producto`, `id_marca`, `caracteristicas`) VALUES
(1, 'Laptop Lenovo Core i7', 1, 'Laptop Lenovo IdeaPad Slim 5 16IRL8 16\" WUXGA IPS, Core i7-13620H, Ram 16GB,SSD 512GB, Free Dos'),
(2, 'Laptop HP Intel Core i7', 2, 'HP Laptop Intel Core i7 de 15.6 pulgadas, 7ª generación, 7500U, 8 GB, memoria de 2 TB HDD Intel HD G');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `rol` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `rol`) VALUES
(1, 'admin'),
(2, 'usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad_medida`
--

CREATE TABLE `unidad_medida` (
  `id` int(11) NOT NULL,
  `unidad_medida` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `password`, `id_persona`, `id_rol`, `estado`) VALUES
(1, 'jkcesar', '1234', 1, 1, 1),
(2, 'segundo', '12345', 2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_producto`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_producto` (
`producto` varchar(50)
,`marca` varchar(50)
,`caracteristicas` varchar(100)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_usuario`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_usuario` (
`id` int(11)
,`usuario` varchar(15)
,`password` varchar(15)
,`razonsocial` varchar(100)
,`rol` varchar(11)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_producto`
--
DROP TABLE IF EXISTS `vista_producto`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_producto`  AS SELECT `p`.`producto` AS `producto`, `m`.`marca` AS `marca`, `p`.`caracteristicas` AS `caracteristicas` FROM (`producto` `p` join `marca` `m` on(`p`.`id_marca` = `m`.`id`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_usuario`
--
DROP TABLE IF EXISTS `vista_usuario`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_usuario`  AS SELECT `u`.`id` AS `id`, `u`.`usuario` AS `usuario`, `u`.`password` AS `password`, `p`.`razonsocial` AS `razonsocial`, `r`.`rol` AS `rol` FROM ((`usuario` `u` join `persona` `p` on(`u`.`id_persona` = `p`.`id`)) join `rol` `r` on(`r`.`id` = `u`.`id_rol`)) WHERE `u`.`estado` = 1 ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_marca` (`id_marca`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_rol` (`id_rol`),
  ADD KEY `id_persona` (`id_persona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`),
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`);
--
-- Base de datos: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) NOT NULL DEFAULT '',
  `user` varchar(255) NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `query` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) NOT NULL,
  `col_name` varchar(64) NOT NULL,
  `col_type` varchar(64) NOT NULL,
  `col_length` text DEFAULT NULL,
  `col_collation` varchar(64) NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) DEFAULT '',
  `col_default` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `column_name` varchar(64) NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `transformation` varchar(255) NOT NULL DEFAULT '',
  `transformation_options` varchar(255) NOT NULL DEFAULT '',
  `input_transformation` varchar(255) NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) NOT NULL,
  `settings_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

--
-- Volcado de datos para la tabla `pma__designer_settings`
--

INSERT INTO `pma__designer_settings` (`username`, `settings_data`) VALUES
('root', '{\"relation_lines\":\"true\",\"snap_to_grid\":\"off\",\"angular_direct\":\"direct\",\"full_screen\":\"off\"}');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL,
  `export_type` varchar(10) NOT NULL,
  `template_name` varchar(64) NOT NULL,
  `template_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db` varchar(64) NOT NULL DEFAULT '',
  `table` varchar(64) NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) NOT NULL,
  `item_name` varchar(64) NOT NULL,
  `item_type` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) NOT NULL,
  `tables` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Volcado de datos para la tabla `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"dbsystem_004\",\"table\":\"marca\"},{\"db\":\"dbsystem_004\",\"table\":\"vista_producto\"},{\"db\":\"dbsystem_004\",\"table\":\"producto\"},{\"db\":\"dbsystem_004\",\"table\":\"modelo\"},{\"db\":\"dbsystem_004\",\"table\":\"articulo\"},{\"db\":\"dbsystem_002\",\"table\":\"material\"},{\"db\":\"dbsystem_002\",\"table\":\"producto\"},{\"db\":\"dbsystem_003\",\"table\":\"articulo\"},{\"db\":\"dbsystem_004\",\"table\":\"categoria\"},{\"db\":\"dbsystem_004\",\"table\":\"unidad_medida\"}]');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) NOT NULL DEFAULT '',
  `master_table` varchar(64) NOT NULL DEFAULT '',
  `master_field` varchar(64) NOT NULL DEFAULT '',
  `foreign_db` varchar(64) NOT NULL DEFAULT '',
  `foreign_table` varchar(64) NOT NULL DEFAULT '',
  `foreign_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) NOT NULL DEFAULT '',
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `search_name` varchar(64) NOT NULL DEFAULT '',
  `search_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) NOT NULL DEFAULT '',
  `table_name` varchar(64) NOT NULL DEFAULT '',
  `display_field` varchar(64) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) NOT NULL,
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `prefs` text NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) NOT NULL,
  `table_name` varchar(64) NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text NOT NULL,
  `schema_sql` text DEFAULT NULL,
  `data_sql` longtext DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Volcado de datos para la tabla `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2024-09-05 15:05:08', '{\"Console\\/Mode\":\"collapse\",\"lang\":\"es\",\"NavigationWidth\":326}');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) NOT NULL,
  `tab` varchar(64) NOT NULL,
  `allowed` enum('Y','N') NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) NOT NULL,
  `usergroup` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Indices de la tabla `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Indices de la tabla `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Indices de la tabla `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Indices de la tabla `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Indices de la tabla `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Indices de la tabla `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Indices de la tabla `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Indices de la tabla `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Indices de la tabla `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Indices de la tabla `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Indices de la tabla `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Indices de la tabla `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Indices de la tabla `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Base de datos: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
