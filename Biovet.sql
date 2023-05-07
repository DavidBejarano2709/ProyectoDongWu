-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-04-2020 a las 23:43:27
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biovet`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agenda`
--

CREATE TABLE `agenda` (
  `idAgenda` int(11) NOT NULL,
  `fechaAgenda` datetime NOT NULL,
  `fkServicio` int(11) NOT NULL,
  `fkMascota` int(11) NOT NULL,
  `fkEstadoAgenda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='	';

--
-- Volcado de datos para la tabla `agenda`
--

INSERT INTO `agenda` (`idAgenda`, `fechaAgenda`, `fkServicio`, `fkMascota`, `fkEstadoAgenda`) VALUES
(1, '2020-04-15 14:44:51', 1, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultamedica`
--

CREATE TABLE `consultamedica` (
  `idConsulta` int(11) NOT NULL,
  `motivoConsulta` varchar(45) NOT NULL,
  `fechaConsulta` timestamp NULL DEFAULT current_timestamp(),
  `descripcionConsulta` varchar(200) NOT NULL,
  `peso` varchar(4) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `fkHistoriaClinica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='	';

--
-- Volcado de datos para la tabla `consultamedica`
--

INSERT INTO `consultamedica` (`idConsulta`, `motivoConsulta`, `fechaConsulta`, `descripcionConsulta`, `peso`, `estado`, `fkHistoriaClinica`) VALUES
(1, 'prueba', '2020-03-15 03:05:00', 'prueba', '1', 1, 2),
(2, 'otra prueba', '2020-03-15 03:06:05', 'prueba', '2', 1, 10),
(3, 'prueba 2 ', '2020-03-15 21:48:05', 'prueba 2 mascota 1', '2', 1, 2),
(4, 'prueba3', '2020-03-15 23:13:54', 'prueba3', '2', 1, 2),
(6, 'prueba 4', '2020-03-27 00:33:37', 'prueba4', '4', 1, 2),
(16, 'otro', '2020-03-27 03:44:47', 'otro', 'otro', 1, 2),
(17, 'otra', '2020-03-27 03:51:31', 'otra', 'otra', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultamedica_has_examen`
--

CREATE TABLE `consultamedica_has_examen` (
  `fkConsulta` int(11) NOT NULL,
  `fkExamen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `consultamedica_has_examen`
--

INSERT INTO `consultamedica_has_examen` (`fkConsulta`, `fkExamen`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultamedica_has_procedimientoquirurgico`
--

CREATE TABLE `consultamedica_has_procedimientoquirurgico` (
  `fkConsulta` int(11) NOT NULL,
  `fkProcedimientoQuirurgico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `consultamedica_has_procedimientoquirurgico`
--

INSERT INTO `consultamedica_has_procedimientoquirurgico` (`fkConsulta`, `fkProcedimientoQuirurgico`) VALUES
(1, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultamedica_has_vacuna`
--

CREATE TABLE `consultamedica_has_vacuna` (
  `fkConsulta` int(11) NOT NULL,
  `fkVacuna` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `consultamedica_has_vacuna`
--

INSERT INTO `consultamedica_has_vacuna` (`fkConsulta`, `fkVacuna`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especie`
--

CREATE TABLE `especie` (
  `idEspecie` int(11) NOT NULL,
  `tipoEspecie` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `especie`
--

INSERT INTO `especie` (`idEspecie`, `tipoEspecie`) VALUES
(1, 'Canino'),
(2, 'Felino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadoagenda`
--

CREATE TABLE `estadoagenda` (
  `idestadoAgenda` int(11) NOT NULL,
  `nombreEstado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estadoagenda`
--

INSERT INTO `estadoagenda` (`idestadoAgenda`, `nombreEstado`) VALUES
(1, 'Activa'),
(2, 'Cancelado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examen`
--

CREATE TABLE `examen` (
  `idExamen` int(11) NOT NULL,
  `tipoExamen` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `examen`
--

INSERT INTO `examen` (`idExamen`, `tipoExamen`) VALUES
(1, 'Hemograma'),
(2, 'Coprologico'),
(3, 'Examen de Orina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `idGenero` int(11) NOT NULL,
  `tipoSexo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`idGenero`, `tipoSexo`) VALUES
(1, 'Masculino'),
(2, 'Femenino'),
(3, 'Otro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historiaclinica`
--

CREATE TABLE `historiaclinica` (
  `idHistoriaClinica` int(11) NOT NULL,
  `fechaApertura` timestamp NULL DEFAULT current_timestamp(),
  `fkMascota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `historiaclinica`
--

INSERT INTO `historiaclinica` (`idHistoriaClinica`, `fechaApertura`, `fkMascota`) VALUES
(2, '2020-03-10 23:43:30', 1),
(3, '2020-03-10 23:43:30', 4),
(10, '2020-03-15 03:05:47', 2);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `listarmascota`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `listarmascota` (
`idMascota` int(11)
,`nombreMascota` varchar(100)
,`fechaNacimiento` date
,`nombreUsuario` varchar(100)
,`tipoRaza` varchar(45)
,`tipoSexo` varchar(45)
,`ColorMascota` varchar(60)
,`estadoMascota` tinyint(1)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota`
--

CREATE TABLE `mascota` (
  `idMascota` int(11) NOT NULL,
  `nombreMascota` varchar(100) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `fkUsuario` int(11) NOT NULL,
  `fkRaza` int(11) NOT NULL,
  `fkGenero` int(11) NOT NULL,
  `ColorMascota` varchar(60) NOT NULL,
  `estadoMascota` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `mascota`
--

INSERT INTO `mascota` (`idMascota`, `nombreMascota`, `fechaNacimiento`, `fkUsuario`, `fkRaza`, `fkGenero`, `ColorMascota`, `estadoMascota`) VALUES
(1, 'Max', '2020-02-11', 1, 1, 1, 'Negro', 1),
(2, 'Kira', '2020-02-03', 2, 2, 2, 'Cafe', 1),
(3, 'Rita', '2020-02-11', 1, 1, 2, 'Blanca', 1),
(4, 'mascotaprueba', '2020-02-11', 5, 1, 1, 'rojo', 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `mascotaagenda`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `mascotaagenda` (
`idAgenda` int(11)
,`fechaAgenda` datetime
,`descripcionServicio` varchar(100)
,`idMascota` int(11)
,`nombreEstado` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `mascotausuario`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `mascotausuario` (
`idMascota` int(11)
,`nombreMascota` varchar(100)
,`fechaNacimiento` date
,`fkUsuario` int(11)
,`tipoRaza` varchar(45)
,`tipoSexo` varchar(45)
,`ColorMascota` varchar(60)
,`estadoMascota` tinyint(1)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `procedimientoquirurgico`
--

CREATE TABLE `procedimientoquirurgico` (
  `idProcedimientoQuirurgico` int(11) NOT NULL,
  `tipoProcedimientoQuirurgico` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `procedimientoquirurgico`
--

INSERT INTO `procedimientoquirurgico` (`idProcedimientoQuirurgico`, `tipoProcedimientoQuirurgico`) VALUES
(1, 'Esterilizacion'),
(2, 'Extracción Tumor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `raza`
--

CREATE TABLE `raza` (
  `idRaza` int(11) NOT NULL,
  `tipoRaza` varchar(45) NOT NULL,
  `fkEspecie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `raza`
--

INSERT INTO `raza` (`idRaza`, `tipoRaza`, `fkEspecie`) VALUES
(1, 'Labrador', 1),
(2, 'Pitbull', 1),
(3, 'Pastor Aleman', 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `reportecx`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `reportecx` (
`idMascota` int(11)
,`nombreMascota` varchar(100)
,`nombreUsuario` varchar(100)
,`tipoRaza` varchar(45)
,`tipoSexo` varchar(45)
,`idHistoriaClinica` int(11)
,`idConsulta` int(11)
,`fechaConsulta` timestamp
,`tipoProcedimientoQuirurgico` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `reporteexamenes`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `reporteexamenes` (
`idMascota` int(11)
,`nombreMascota` varchar(100)
,`nombreUsuario` varchar(100)
,`tipoRaza` varchar(45)
,`tipoSexo` varchar(45)
,`idHistoriaClinica` int(11)
,`idConsulta` int(11)
,`fechaConsulta` timestamp
,`tipoExamen` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `reportevacunas`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `reportevacunas` (
`idMascota` int(11)
,`nombreMascota` varchar(100)
,`nombreUsuario` varchar(100)
,`tipoRaza` varchar(45)
,`tipoSexo` varchar(45)
,`idHistoriaClinica` int(11)
,`idConsulta` int(11)
,`fechaConsulta` timestamp
,`tipoVacuna` varchar(45)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL,
  `tipoRol` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `tipoRol`) VALUES
(1, 'Administrador'),
(2, 'Usuario'),
(3, 'Auxiliar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `idServicio` int(11) NOT NULL,
  `descripcionServicio` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`idServicio`, `descripcionServicio`) VALUES
(1, 'Cita Medica'),
(2, 'Peluqueria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `idTipoDocu` int(11) NOT NULL,
  `tipoDocu` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`idTipoDocu`, `tipoDocu`) VALUES
(1, 'Cedula de Ciudadania'),
(2, 'Cedula de Extranjeria'),
(3, 'NIT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `cedula` varchar(20) NOT NULL,
  `nombreUsuario` varchar(100) NOT NULL,
  `apellidoUsuario` varchar(100) NOT NULL,
  `contraseñaUsuario` varchar(12) NOT NULL,
  `direcciòn` varchar(100) DEFAULT NULL,
  `celular` varchar(11) DEFAULT NULL,
  `telefonoFijo` varchar(11) DEFAULT NULL,
  `correoUsuario` varchar(100) NOT NULL,
  `estadoUsuario` tinyint(1) NOT NULL,
  `fkTipoDocu` int(11) NOT NULL,
  `fkRol` int(11) NOT NULL,
  `fkGenero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `cedula`, `nombreUsuario`, `apellidoUsuario`, `contraseñaUsuario`, `direcciòn`, `celular`, `telefonoFijo`, `correoUsuario`, `estadoUsuario`, `fkTipoDocu`, `fkRol`, `fkGenero`) VALUES
(1, '1014246133', 'Alex', 'Silva', '1234', NULL, NULL, NULL, 'aaa@gmail.com', 1, 1, 1, NULL),
(2, '1032412490', 'Fabiàn', 'Jimènez', '123', NULL, NULL, NULL, 'fj@mail.com', 1, 1, 1, 1),
(4, 'sadas', 'sdada', 'asdasd', 'sadasd', 'Direcciòn', 'Celular', 'Telefono', 'sadas@gmail.com', 1, 1, 2, 4),
(5, 'prueba', 'prueba', 'prueba', 'prueba', 'Direcciòn', 'Celular', 'Telefono', 'prueba@gmail.com', 1, 1, 2, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `idVacuna` int(11) NOT NULL,
  `tipoVacuna` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`idVacuna`, `tipoVacuna`) VALUES
(1, 'Rabia'),
(2, 'Moquillo');

-- --------------------------------------------------------

--
-- Estructura para la vista `listarmascota`
--
DROP TABLE IF EXISTS `listarmascota`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listarmascota`  AS  select `m`.`idMascota` AS `idMascota`,`m`.`nombreMascota` AS `nombreMascota`,`m`.`fechaNacimiento` AS `fechaNacimiento`,`u`.`nombreUsuario` AS `nombreUsuario`,`r`.`tipoRaza` AS `tipoRaza`,`g`.`tipoSexo` AS `tipoSexo`,`m`.`ColorMascota` AS `ColorMascota`,`m`.`estadoMascota` AS `estadoMascota` from (((`mascota` `m` join `usuario` `u` on(`m`.`fkUsuario` = `u`.`idUsuario`)) join `raza` `r` on(`m`.`fkRaza` = `r`.`idRaza`)) join `genero` `g` on(`m`.`fkGenero` = `g`.`idGenero`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `mascotaagenda`
--
DROP TABLE IF EXISTS `mascotaagenda`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mascotaagenda`  AS  select `agenda`.`idAgenda` AS `idAgenda`,`agenda`.`fechaAgenda` AS `fechaAgenda`,`servicio`.`descripcionServicio` AS `descripcionServicio`,`listarmascota`.`idMascota` AS `idMascota`,`estadoagenda`.`nombreEstado` AS `nombreEstado` from (((`agenda` join `estadoagenda` on(`agenda`.`fkEstadoAgenda` = `estadoagenda`.`idestadoAgenda`)) join `servicio` on(`agenda`.`fkServicio` = `servicio`.`idServicio`)) join `listarmascota` on(`agenda`.`fkMascota` = `listarmascota`.`idMascota`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `mascotausuario`
--
DROP TABLE IF EXISTS `mascotausuario`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mascotausuario`  AS  select `mascota`.`idMascota` AS `idMascota`,`mascota`.`nombreMascota` AS `nombreMascota`,`mascota`.`fechaNacimiento` AS `fechaNacimiento`,`mascota`.`fkUsuario` AS `fkUsuario`,`raza`.`tipoRaza` AS `tipoRaza`,`genero`.`tipoSexo` AS `tipoSexo`,`mascota`.`ColorMascota` AS `ColorMascota`,`mascota`.`estadoMascota` AS `estadoMascota` from ((`mascota` join `raza` on(`mascota`.`fkRaza` = `raza`.`idRaza`)) join `genero` on(`mascota`.`fkGenero` = `genero`.`idGenero`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `reportecx`
--
DROP TABLE IF EXISTS `reportecx`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reportecx`  AS  select `listarmascota`.`idMascota` AS `idMascota`,`listarmascota`.`nombreMascota` AS `nombreMascota`,`listarmascota`.`nombreUsuario` AS `nombreUsuario`,`listarmascota`.`tipoRaza` AS `tipoRaza`,`listarmascota`.`tipoSexo` AS `tipoSexo`,`historiaclinica`.`idHistoriaClinica` AS `idHistoriaClinica`,`consultamedica`.`idConsulta` AS `idConsulta`,`consultamedica`.`fechaConsulta` AS `fechaConsulta`,`procedimientoquirurgico`.`tipoProcedimientoQuirurgico` AS `tipoProcedimientoQuirurgico` from ((((`listarmascota` join `historiaclinica` on(`listarmascota`.`idMascota` = `historiaclinica`.`fkMascota`)) join `consultamedica` on(`historiaclinica`.`idHistoriaClinica` = `consultamedica`.`fkHistoriaClinica`)) join `consultamedica_has_procedimientoquirurgico` on(`consultamedica`.`idConsulta` = `consultamedica_has_procedimientoquirurgico`.`fkConsulta`)) join `procedimientoquirurgico` on(`consultamedica_has_procedimientoquirurgico`.`fkProcedimientoQuirurgico` = `procedimientoquirurgico`.`idProcedimientoQuirurgico`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `reporteexamenes`
--
DROP TABLE IF EXISTS `reporteexamenes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reporteexamenes`  AS  select `listarmascota`.`idMascota` AS `idMascota`,`listarmascota`.`nombreMascota` AS `nombreMascota`,`listarmascota`.`nombreUsuario` AS `nombreUsuario`,`listarmascota`.`tipoRaza` AS `tipoRaza`,`listarmascota`.`tipoSexo` AS `tipoSexo`,`historiaclinica`.`idHistoriaClinica` AS `idHistoriaClinica`,`consultamedica`.`idConsulta` AS `idConsulta`,`consultamedica`.`fechaConsulta` AS `fechaConsulta`,`examen`.`tipoExamen` AS `tipoExamen` from ((((`listarmascota` join `historiaclinica` on(`listarmascota`.`idMascota` = `historiaclinica`.`fkMascota`)) join `consultamedica` on(`historiaclinica`.`idHistoriaClinica` = `consultamedica`.`fkHistoriaClinica`)) join `consultamedica_has_examen` on(`consultamedica`.`idConsulta` = `consultamedica_has_examen`.`fkConsulta`)) join `examen` on(`consultamedica_has_examen`.`fkExamen` = `examen`.`idExamen`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `reportevacunas`
--
DROP TABLE IF EXISTS `reportevacunas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reportevacunas`  AS  select `listarmascota`.`idMascota` AS `idMascota`,`listarmascota`.`nombreMascota` AS `nombreMascota`,`listarmascota`.`nombreUsuario` AS `nombreUsuario`,`listarmascota`.`tipoRaza` AS `tipoRaza`,`listarmascota`.`tipoSexo` AS `tipoSexo`,`historiaclinica`.`idHistoriaClinica` AS `idHistoriaClinica`,`consultamedica`.`idConsulta` AS `idConsulta`,`consultamedica`.`fechaConsulta` AS `fechaConsulta`,`vacuna`.`tipoVacuna` AS `tipoVacuna` from ((((`listarmascota` join `historiaclinica` on(`listarmascota`.`idMascota` = `historiaclinica`.`fkMascota`)) join `consultamedica` on(`historiaclinica`.`idHistoriaClinica` = `consultamedica`.`fkHistoriaClinica`)) join `consultamedica_has_vacuna` on(`consultamedica`.`idConsulta` = `consultamedica_has_vacuna`.`fkConsulta`)) join `vacuna` on(`consultamedica_has_vacuna`.`fkVacuna` = `vacuna`.`idVacuna`)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`idAgenda`),
  ADD KEY `fk_Agenda_Servicio1_idx` (`fkServicio`),
  ADD KEY `fk_Agenda_Mascota1_idx` (`fkMascota`),
  ADD KEY `fk_Agenda_estadoAgenda1_idx` (`fkEstadoAgenda`);

--
-- Indices de la tabla `consultamedica`
--
ALTER TABLE `consultamedica`
  ADD PRIMARY KEY (`idConsulta`),
  ADD KEY `fk_MotivoConsulta_HistoriaClinica1_idx` (`fkHistoriaClinica`);

--
-- Indices de la tabla `consultamedica_has_examen`
--
ALTER TABLE `consultamedica_has_examen`
  ADD PRIMARY KEY (`fkConsulta`,`fkExamen`),
  ADD KEY `fk_ConsultaMedica_has_Examen_Examen1_idx` (`fkExamen`),
  ADD KEY `fk_ConsultaMedica_has_Examen_ConsultaMedica1_idx` (`fkConsulta`);

--
-- Indices de la tabla `consultamedica_has_procedimientoquirurgico`
--
ALTER TABLE `consultamedica_has_procedimientoquirurgico`
  ADD PRIMARY KEY (`fkConsulta`,`fkProcedimientoQuirurgico`),
  ADD KEY `fk_ConsultaMedica_has_ProcedimientoQuirurgico_Procedimiento_idx` (`fkProcedimientoQuirurgico`),
  ADD KEY `fk_ConsultaMedica_has_ProcedimientoQuirurgico_ConsultaMedic_idx` (`fkConsulta`);

--
-- Indices de la tabla `consultamedica_has_vacuna`
--
ALTER TABLE `consultamedica_has_vacuna`
  ADD PRIMARY KEY (`fkConsulta`,`fkVacuna`),
  ADD KEY `fk_ConsultaMedica_has_Vacuna_Vacuna1_idx` (`fkVacuna`),
  ADD KEY `fk_ConsultaMedica_has_Vacuna_ConsultaMedica1_idx` (`fkConsulta`);

--
-- Indices de la tabla `especie`
--
ALTER TABLE `especie`
  ADD PRIMARY KEY (`idEspecie`);

--
-- Indices de la tabla `estadoagenda`
--
ALTER TABLE `estadoagenda`
  ADD PRIMARY KEY (`idestadoAgenda`);

--
-- Indices de la tabla `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`idExamen`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`idGenero`);

--
-- Indices de la tabla `historiaclinica`
--
ALTER TABLE `historiaclinica`
  ADD PRIMARY KEY (`idHistoriaClinica`),
  ADD KEY `fk_HistoriaClinica_Mascota1_idx` (`fkMascota`);

--
-- Indices de la tabla `mascota`
--
ALTER TABLE `mascota`
  ADD PRIMARY KEY (`idMascota`),
  ADD KEY `fk_Mascota_Usuario1_idx` (`fkUsuario`),
  ADD KEY `fk_Mascota_Raza1_idx` (`fkRaza`),
  ADD KEY `fk_Mascota_Sexo1_idx` (`fkGenero`);

--
-- Indices de la tabla `procedimientoquirurgico`
--
ALTER TABLE `procedimientoquirurgico`
  ADD PRIMARY KEY (`idProcedimientoQuirurgico`);

--
-- Indices de la tabla `raza`
--
ALTER TABLE `raza`
  ADD PRIMARY KEY (`idRaza`),
  ADD KEY `fk_Raza_Especie1_idx` (`fkEspecie`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`idServicio`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`idTipoDocu`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `fk_Usuario_TipoDocumento_idx` (`fkTipoDocu`),
  ADD KEY `fk_Usuario_Rol1_idx` (`fkRol`),
  ADD KEY `fk_Usuario_Sexo1_idx` (`fkGenero`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`idVacuna`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `agenda`
--
ALTER TABLE `agenda`
  MODIFY `idAgenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `consultamedica`
--
ALTER TABLE `consultamedica`
  MODIFY `idConsulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `especie`
--
ALTER TABLE `especie`
  MODIFY `idEspecie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `examen`
--
ALTER TABLE `examen`
  MODIFY `idExamen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `idGenero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `historiaclinica`
--
ALTER TABLE `historiaclinica`
  MODIFY `idHistoriaClinica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `mascota`
--
ALTER TABLE `mascota`
  MODIFY `idMascota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `procedimientoquirurgico`
--
ALTER TABLE `procedimientoquirurgico`
  MODIFY `idProcedimientoQuirurgico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `raza`
--
ALTER TABLE `raza`
  MODIFY `idRaza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `idVacuna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
