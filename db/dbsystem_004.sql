-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-10-2024 a las 16:56:29
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
-- Base de datos: `dbsystem_004`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_actualizar_persona` (IN `_razonsocial` VARCHAR(150), IN `_num_doc` VARCHAR(15), IN `_direccion` VARCHAR(150), IN `_telefono` VARCHAR(11), IN `_correo` VARCHAR(100), `_id` INT(11))   BEGIN
UPDATE persona SET razonsocial= _razonsocial, num_doc=_num_doc, direccion=_direccion, telefono= _telefono, correo= _correo WHERE id=_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_actualizar_producto` (IN `_producto` VARCHAR(100), IN `_marca` VARCHAR(50), IN `carac` VARCHAR(100), `_id` INT(11))   BEGIN
UPDATE producto SET producto = _producto, id_marca=(SELECT m.id FROM marca m WHERE m.marca = _marca),caracteristicas = carac  WHERE id = _id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_actualizar_usuario` (IN `user` VARCHAR(20), IN `pass` VARCHAR(20), IN `per` VARCHAR(100), IN `rl` VARCHAR(20), IN `_id` INT(11))   BEGIN
UPDATE usuario SET usuario = user,password=pass,id_persona=(SELECT p.id FROM persona p WHERE p.razonsocial = per),id_rol=(SELECT r.id FROM rol r WHERE r.rol =rl) WHERE id = _id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_eliminar_persona` (`_id` INT(11))   BEGIN
UPDATE persona SET estado= 0 WHERE id=_id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_eliminar_usuario` (IN `_id` INT(11))   BEGIN
UPDATE usuario SET estado=0 WHERE id = _id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_registro_persona` (IN `_razonsocial` VARCHAR(150), IN `_id_documento` INT(11), IN `_num_doc` VARCHAR(15), IN `_direccion` VARCHAR(150), IN `_telefono` VARCHAR(11), IN `_correo` VARCHAR(100), IN `_id_tipo_persona` INT(11))   BEGIN
INSERT INTO persona(id, razonsocial, id_tipo_documento, num_doc, direccion, telefono, correo, id_tipo_persona, estado) VALUES (null, _razonsocial,_id_documento, _num_doc, _direccion, _telefono, _correo,_id_tipo_persona, 1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_registro_producto` (IN `_producto` VARCHAR(100), IN `_marca` VARCHAR(50), IN `carac` VARCHAR(100))   BEGIN
INSERT INTO producto(id, producto, id_marca, caracteristicas) VALUES (null,_producto,(SELECT m.id FROM marca m WHERE m.marca = _marca),carac);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_registro_usuario` (IN `user` VARCHAR(20), IN `pass` VARCHAR(20), IN `per` VARCHAR(100), IN `rl` VARCHAR(20))   BEGIN
INSERT INTO usuario(id, usuario, password, id_persona, id_rol, estado) VALUES
(null,user,pass,(SELECT p.id FROM persona p WHERE p.razonsocial = per),(SELECT r.id FROM rol r WHERE r.rol =rl),1);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id` int(11) NOT NULL,
  `id_compra` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_unidad` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double(11,2) NOT NULL,
  `sub_total` double(11,2) NOT NULL,
  `descuento` double(11,2) NOT NULL,
  `total` double(11,2) NOT NULL,
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
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id` int(11) NOT NULL,
  `codigo` varchar(15) NOT NULL,
  `serie` varchar(20) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_trabajador` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `sub_total` double(11,2) NOT NULL,
  `descuento` double(11,2) NOT NULL,
  `igv` double(11,2) NOT NULL,
  `total` double(11,2) NOT NULL,
  `archivo` varchar(100) NOT NULL,
  `fecha_compra` varchar(20) NOT NULL,
  `fech_registro` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
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
  `id_tipo_documento` int(11) NOT NULL,
  `num_doc` varchar(20) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `id_tipo_persona` int(11) NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `razonsocial`, `id_tipo_documento`, `num_doc`, `direccion`, `telefono`, `correo`, `id_tipo_persona`, `estado`) VALUES
(1, 'Cesar Uribe Llaguento Carlos', 1, '48335152', 'Buenos Aires - el Parco - Bagua - Amazonas', '935914551', 'llaguentocarloscesar96@gmail.com', 1, 1),
(2, 'Segundo Augusto Chuquizuta Tafur', 1, '71791050', 'Luya Viejo - Luya - Chachapoyas - Amazonas', '956393952', '7178105081@untrm.edu.pe', 1, 1),
(3, 'Edwin Flores Delgado', 1, '76465221', 'La Primavera - Bagua - Amazonas', '932798440', '7646522172@untrm.edu.pe', 1, 1),
(4, 'COMPUTO SAC', 2, '20435687421', 'Surco - Lima', '975761665', 'compusac@gmail.com', 2, 1),
(5, 'Servitec AP & RC', 2, '20657890213', 'Cajamarca', '956393952', 'servitecpa@hotmail.com', 2, 1),
(6, 'CONSTRUCTORES & CONSULTORES AP & RC S.A.C.', 2, '20610563741', 'CAL.SAN ANDRES NRO. 288 URB. SAN ANDRES LA LIBERTAD - TRUJILLO - TRUJILLO', '935914551', 'contructores@hotmail.com', 3, 1),
(7, 'Multiservicios Mayanga', 2, '20657890216', 'Bagua', '956393952', 'mayanga@hotmail.com', 3, 1),
(8, 'Mercy Yudit Cubas Goicoche', 1, '60166587', 'Cajaruro - Utcubamba', '987456321', 'yuditcubas@gmail.com', 1, 1),
(9, 'SYSTEM JK SERVICES SAC', 2, '20483351521', 'BAGUA - AMAZONAS', '934914551', 'systemjk@hotmail.com', 2, 1),
(10, 'E & S GLOBAS SAC', 2, '20432654876', 'LIMA', '987654123', 'e&sglobal@hotmail.com', 3, 1);

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
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `id_tipo_documento` int(11) NOT NULL,
  `tipo_documento` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`id_tipo_documento`, `tipo_documento`, `descripcion`) VALUES
(1, 'DNI', 'Documento Nacional de Identidad'),
(2, 'RUC', 'Registro Único de Contribuyentes'),
(3, 'CARNET EXT.', 'CARNET DE EXTRANJERIA'),
(4, 'PASAPORTE', ' PASAPORTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_persona`
--

CREATE TABLE `tipo_persona` (
  `id_tipo_persona` int(11) NOT NULL,
  `tipo_persona` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_persona`
--

INSERT INTO `tipo_persona` (`id_tipo_persona`, `tipo_persona`) VALUES
(1, 'EMPLEADO'),
(2, 'PROVEEDOR'),
(3, 'CLIENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad_medida`
--

CREATE TABLE `unidad_medida` (
  `id` int(11) NOT NULL,
  `unidad_medida` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `unidad_medida`
--

INSERT INTO `unidad_medida` (`id`, `unidad_medida`) VALUES
(1, 'U'),
(2, 'Kg'),
(3, 'L'),
(4, 'M');

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
-- Estructura Stand-in para la vista `vista_persona`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_persona` (
`id` int(11)
,`razonsocial` varchar(100)
,`tipo_documento` varchar(50)
,`num_doc` varchar(20)
,`direccion` varchar(100)
,`telefono` varchar(9)
,`correo` varchar(100)
,`id_tipo_persona` int(11)
);

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
-- Estructura para la vista `vista_persona`
--
DROP TABLE IF EXISTS `vista_persona`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_persona`  AS SELECT `p`.`id` AS `id`, `p`.`razonsocial` AS `razonsocial`, `td`.`tipo_documento` AS `tipo_documento`, `p`.`num_doc` AS `num_doc`, `p`.`direccion` AS `direccion`, `p`.`telefono` AS `telefono`, `p`.`correo` AS `correo`, `p`.`id_tipo_persona` AS `id_tipo_persona` FROM (`persona` `p` join `tipo_documento` `td` on(`td`.`id_tipo_documento` = `p`.`id_tipo_documento`)) WHERE `p`.`estado` = 1 ;

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_compra` (`id_compra`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_unidad` (`id_unidad`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_proveedor` (`id_proveedor`),
  ADD UNIQUE KEY `id_trabajador` (`id_trabajador`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tipo_documento` (`id_tipo_documento`),
  ADD KEY `id_tipo_persona` (`id_tipo_persona`);

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
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`id_tipo_documento`);

--
-- Indices de la tabla `tipo_persona`
--
ALTER TABLE `tipo_persona`
  ADD PRIMARY KEY (`id_tipo_persona`);

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
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

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
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `id_tipo_documento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_persona`
--
ALTER TABLE `tipo_persona`
  MODIFY `id_tipo_persona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `articulo_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `articulo_ibfk_2` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id`),
  ADD CONSTRAINT `articulo_ibfk_3` FOREIGN KEY (`id_unidad`) REFERENCES `unidad_medida` (`id`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `persona` (`id`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`id_trabajador`) REFERENCES `persona` (`id`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_tipo_persona`) REFERENCES `tipo_persona` (`id_tipo_persona`),
  ADD CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
