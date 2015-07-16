/*
Navicat MySQL Data Transfer

Source Server         : Conexión Apache Alternativa
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : merchant

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-07-15 18:01:38
*/

CREATE DATABASE merchant;
USE merchant;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `rfcCliente` varchar(15) NOT NULL,
  `nombreCliente` varchar(145) NOT NULL,
  `telCliente` varchar(15) NOT NULL,
  `tel2Cliente` varchar(15) DEFAULT NULL,
  `mailCliente` varchar(45) NOT NULL,
  `altaCliente` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `statusCliente` tinyint(4) DEFAULT NULL,
  `domicilioFiscal_idDomicilioFiscal` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_cliente_domicilioFiscal1_idx` (`domicilioFiscal_idDomicilioFiscal`),
  CONSTRAINT `fk_cliente_domicilioFiscal1` FOREIGN KEY (`domicilioFiscal_idDomicilioFiscal`) REFERENCES `domiciliofiscal` (`idDomicilioFiscal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cliente
-- ----------------------------

-- ----------------------------
-- Table structure for compra
-- ----------------------------
DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `fechaCompra` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `totalCompra` float NOT NULL,
  `tipoPagoCompra` varchar(10) NOT NULL,
  `statusCompra` varchar(10) NOT NULL,
  `statusLiquidezCompra` tinyint(4) NOT NULL,
  `fechaPagoLimiteCompra` date DEFAULT NULL,
  `numeroPagos` int(11) DEFAULT NULL,
  `proveedor_idProveedor` int(11) NOT NULL,
  `empleado_idEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_compra_proveedor1_idx` (`proveedor_idProveedor`),
  KEY `fk_compra_empleado1_idx` (`empleado_idEmpleado`),
  CONSTRAINT `fk_compra_empleado1` FOREIGN KEY (`empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_compra_proveedor1` FOREIGN KEY (`proveedor_idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of compra
-- ----------------------------

-- ----------------------------
-- Table structure for detallecompra
-- ----------------------------
DROP TABLE IF EXISTS `detallecompra`;
CREATE TABLE `detallecompra` (
  `producto_idCodigoBarraProducto` varchar(20) NOT NULL,
  `compra_idCompra` int(11) NOT NULL,
  `costoUnitarioProducto` float DEFAULT NULL,
  `cantidad` float NOT NULL,
  PRIMARY KEY (`producto_idCodigoBarraProducto`,`compra_idCompra`),
  KEY `fk_producto_has_compra_compra1_idx` (`compra_idCompra`),
  KEY `fk_producto_has_compra_producto1_idx` (`producto_idCodigoBarraProducto`),
  CONSTRAINT `fk_producto_has_compra_compra1` FOREIGN KEY (`compra_idCompra`) REFERENCES `compra` (`idCompra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_has_compra_producto1` FOREIGN KEY (`producto_idCodigoBarraProducto`) REFERENCES `producto` (`idCodigoBarraProducto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of detallecompra
-- ----------------------------

-- ----------------------------
-- Table structure for detalleproducto
-- ----------------------------
DROP TABLE IF EXISTS `detalleproducto`;
CREATE TABLE `detalleproducto` (
  `proveedor_idProveedor` int(11) NOT NULL,
  `producto_idCodigoBarraProducto` varchar(20) NOT NULL,
  `precioCompra` float NOT NULL,
  PRIMARY KEY (`proveedor_idProveedor`,`producto_idCodigoBarraProducto`),
  KEY `fk_proveedor_has_producto_producto1_idx` (`producto_idCodigoBarraProducto`),
  KEY `fk_proveedor_has_producto_proveedor1_idx` (`proveedor_idProveedor`),
  CONSTRAINT `fk_proveedor_has_producto_producto1` FOREIGN KEY (`producto_idCodigoBarraProducto`) REFERENCES `producto` (`idCodigoBarraProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proveedor_has_producto_proveedor1` FOREIGN KEY (`proveedor_idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of detalleproducto
-- ----------------------------

-- ----------------------------
-- Table structure for detalleventa
-- ----------------------------
DROP TABLE IF EXISTS `detalleventa`;
CREATE TABLE `detalleventa` (
  `producto_idCodigoBarraProducto` varchar(20) NOT NULL,
  `venta_idVenta` int(11) NOT NULL,
  `cantidad` float NOT NULL,
  PRIMARY KEY (`producto_idCodigoBarraProducto`,`venta_idVenta`),
  KEY `fk_venta_has_producto_producto1_idx` (`producto_idCodigoBarraProducto`),
  KEY `fk_venta_has_producto_venta1_idx` (`venta_idVenta`),
  CONSTRAINT `fk_venta_has_producto_producto1` FOREIGN KEY (`producto_idCodigoBarraProducto`) REFERENCES `producto` (`idCodigoBarraProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_venta_has_producto_venta1` FOREIGN KEY (`venta_idVenta`) REFERENCES `venta` (`idVenta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of detalleventa
-- ----------------------------

-- ----------------------------
-- Table structure for domiciliofiscal
-- ----------------------------
DROP TABLE IF EXISTS `domiciliofiscal`;
CREATE TABLE `domiciliofiscal` (
  `idDomicilioFiscal` int(11) NOT NULL AUTO_INCREMENT,
  `calle` varchar(45) NOT NULL,
  `numExt` varchar(45) DEFAULT NULL,
  `numInt` varchar(5) DEFAULT NULL,
  `colonia` varchar(45) DEFAULT NULL,
  `codigoPostal` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `municipio` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDomicilioFiscal`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of domiciliofiscal
-- ----------------------------
INSERT INTO `domiciliofiscal` VALUES ('1', 'Av. Principal', '1903', '10', 'Zona Industrial Mercantil', '91000', 'Distrito Federal', 'Distrito Federal', 'México', 'México');
INSERT INTO `domiciliofiscal` VALUES ('2', 'Diana Laura ', '19', null, '23 de Marzo', '91153', 'Xalapa', 'Xalapa', 'Veracruz', 'Mexico');
INSERT INTO `domiciliofiscal` VALUES ('3', 'Diana Laura Riojas de Colosio', '19', '19', '23 de Marzo ', '911153', 'Xalapa', 'Xalapa', 'Veracruz', 'México');
INSERT INTO `domiciliofiscal` VALUES ('4', 'Diana Laura Riojas de Colosio', '19', '19', '23 de Marzo ', '911153', 'Xalapa', 'Xalapa', 'Veracruz', 'México');

-- ----------------------------
-- Table structure for empleado
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `rfcEmpleado` varchar(25) NOT NULL,
  `tipoEmpleado_idtipoEmpleado` int(2) NOT NULL,
  `nombreEmpleado` varchar(45) NOT NULL,
  `apellidosEmpleado` varchar(60) NOT NULL,
  `telefonoCelularEmpleado` varchar(45) DEFAULT NULL,
  `telefonoEmpleado` varchar(45) DEFAULT NULL,
  `mailEmpleado` varchar(45) DEFAULT NULL,
  `salarioDiarioEmpleado` float NOT NULL DEFAULT '0',
  `diasLaboralesEmpleado` int(11) DEFAULT NULL,
  `altaEmpleado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_idUsuario` int(11) DEFAULT NULL,
  `domicilioFiscal_idDomicilioFiscal` int(11) NOT NULL,
  `sucursal_idSucursal` int(11) NOT NULL,
  `bajaEmpleado` timestamp NULL DEFAULT NULL,
  `statusEmpleado` tinyint(4) DEFAULT NULL,
  `imagenEmpleado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`,`sucursal_idSucursal`),
  KEY `fk_empleado_usuario1_idx` (`usuario_idUsuario`),
  KEY `fk_empleado_domicilioFiscal1_idx` (`domicilioFiscal_idDomicilioFiscal`),
  KEY `fk_empleado_sucursal1_idx` (`sucursal_idSucursal`),
  KEY `fk_empleado_tipoEmpleado1_idx` (`tipoEmpleado_idtipoEmpleado`),
  CONSTRAINT `fk_empleado_domicilioFiscal1` FOREIGN KEY (`domicilioFiscal_idDomicilioFiscal`) REFERENCES `domiciliofiscal` (`idDomicilioFiscal`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_empleado_sucursal1` FOREIGN KEY (`sucursal_idSucursal`) REFERENCES `sucursal` (`idSucursal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_tipoEmpleado1` FOREIGN KEY (`tipoEmpleado_idtipoEmpleado`) REFERENCES `tipoempleado` (`idtipoEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_empleado_usuario1` FOREIGN KEY (`usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empleado
-- ----------------------------
INSERT INTO `empleado` VALUES ('1', '', '1', 'Eleazar', 'Fernández Ramírez', null, '2288462124', 'evi_skorpion@hotmail.com', '0', '1', '2015-07-04 23:11:00', '1', '2', '1', null, '1', null);
INSERT INTO `empleado` VALUES ('2', 'XXXXXXXXXXXXXX', '1', 'Eleazar  ', 'Fernández Ramírez ', null, '2288452124', 'evi_skorpion@hotmail.com', '63.99', '14', '2015-07-15 17:35:38', '4', '4', '1', null, '1', '/images/empleados/capture-20150521-000057.png');

-- ----------------------------
-- Table structure for empresa
-- ----------------------------
DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEmpresa` varchar(45) NOT NULL,
  `rfcEmpresa` varchar(15) NOT NULL,
  `logoEmpresa` varchar(250) DEFAULT NULL,
  `telEmpresa` varchar(15) DEFAULT NULL,
  `tel2Empresa` varchar(15) DEFAULT NULL,
  `mailEmpresa` varchar(45) DEFAULT NULL,
  `webEmpresa` varchar(45) DEFAULT NULL,
  `altaEmpresa` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `regimenFiscal_idregimenFiscal` int(11) NOT NULL,
  PRIMARY KEY (`idEmpresa`,`regimenFiscal_idregimenFiscal`),
  KEY `fk_empresa_regimenFiscal1_idx` (`regimenFiscal_idregimenFiscal`),
  CONSTRAINT `fk_empresa_regimenFiscal1` FOREIGN KEY (`regimenFiscal_idregimenFiscal`) REFERENCES `regimenFiscFl` (`idregimenFiscal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empresa
-- ----------------------------
INSERT INTO `empresa` VALUES ('1', 'Empresa Merchant', 'FERERAOR1993', null, '2288462124', '2282023056', 'ferandbet@gmail.com', 'http://www.merchant.com', '2015-06-29 15:57:48', '1');
INSERT INTO `empresa` VALUES ('3', '', 'ghbnjkm', '', '', '', '', '', '2015-07-05 21:43:02', '1');
INSERT INTO `empresa` VALUES ('4', 'legnlerk', 'QWER098763', '/images/empresas/picture_lenguaje_probabilistico_4.jpg', '', '', 'RICHARD.ALAN.OL@JRHF.COM', '', '2015-07-15 17:21:19', '1');

-- ----------------------------
-- Table structure for impuesto
-- ----------------------------
DROP TABLE IF EXISTS `impuesto`;
CREATE TABLE `impuesto` (
  `idImpuesto` int(2) NOT NULL AUTO_INCREMENT,
  `codigoImpuesto` varchar(8) DEFAULT NULL,
  `descripcionImpuesto` varchar(50) DEFAULT NULL,
  `valorImpuesto` float DEFAULT NULL,
  PRIMARY KEY (`idImpuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of impuesto
-- ----------------------------

-- ----------------------------
-- Table structure for linea
-- ----------------------------
DROP TABLE IF EXISTS `linea`;
CREATE TABLE `linea` (
  `idLinea` int(2) NOT NULL AUTO_INCREMENT,
  `codigoLinea` varchar(8) DEFAULT NULL,
  `descripcionLinea` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLinea`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of linea
-- ----------------------------

-- ----------------------------
-- Table structure for pagoscompra
-- ----------------------------
DROP TABLE IF EXISTS `pagoscompra`;
CREATE TABLE `pagoscompra` (
  `idPagosCompra` int(11) NOT NULL AUTO_INCREMENT,
  `montoPago` varchar(45) DEFAULT NULL,
  `fechaPagoCompra` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `compra_idCompra` int(11) NOT NULL,
  PRIMARY KEY (`idPagosCompra`,`compra_idCompra`),
  KEY `fk_pagosCompra_compra1_idx` (`compra_idCompra`),
  CONSTRAINT `fk_pagosCompra_compra1` FOREIGN KEY (`compra_idCompra`) REFERENCES `compra` (`idCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pagoscompra
-- ----------------------------

-- ----------------------------
-- Table structure for producto
-- ----------------------------
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `idCodigoBarraProducto` varchar(20) NOT NULL,
  `descripcionProducto` varchar(95) DEFAULT NULL,
  `existenciaProducto` float NOT NULL,
  `stockMinimoProducto` float NOT NULL,
  `precioVenta` float NOT NULL,
  `tipoUnidad_idtipoUnidad` int(2) NOT NULL,
  `impuesto_idImpuesto` int(2) NOT NULL,
  `statusProducto` tinyint(4) DEFAULT NULL,
  `linea_idLinea` int(11) NOT NULL,
  PRIMARY KEY (`idCodigoBarraProducto`,`tipoUnidad_idtipoUnidad`,`impuesto_idImpuesto`,`linea_idLinea`),
  KEY `fk_producto_tipoUnidad1_idx` (`tipoUnidad_idtipoUnidad`),
  KEY `fk_producto_impuesto1_idx` (`impuesto_idImpuesto`),
  KEY `fk_producto_linea1_idx` (`linea_idLinea`),
  CONSTRAINT `fk_producto_impuesto1` FOREIGN KEY (`impuesto_idImpuesto`) REFERENCES `impuesto` (`idImpuesto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_linea1` FOREIGN KEY (`linea_idLinea`) REFERENCES `linea` (`idLinea`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_tipoUnidad1` FOREIGN KEY (`tipoUnidad_idtipoUnidad`) REFERENCES `tipounidad` (`idtipoUnidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of producto
-- ----------------------------

-- ----------------------------
-- Table structure for proveedor
-- ----------------------------
DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `rfcProveedor` varchar(15) NOT NULL,
  `nombreProveedor` varchar(45) NOT NULL,
  `telProveedor` varchar(15) DEFAULT NULL,
  `tel2Proveedor` varchar(15) DEFAULT NULL,
  `mailProveedor` varchar(45) DEFAULT NULL,
  `domicilioFiscal_idDomicilioFiscal` int(11) NOT NULL,
  PRIMARY KEY (`idProveedor`),
  KEY `fk_proveedor_domicilioFiscal1_idx` (`domicilioFiscal_idDomicilioFiscal`),
  CONSTRAINT `fk_proveedor_domicilioFiscal1` FOREIGN KEY (`domicilioFiscal_idDomicilioFiscal`) REFERENCES `domiciliofiscal` (`idDomicilioFiscal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of proveedor
-- ----------------------------

-- ----------------------------
-- Table structure for regimenFiscal
-- ----------------------------
DROP TABLE IF EXISTS `regimenFiscal`;
CREATE TABLE `regimenFiscal` (
  `idregimenFiscal` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionRegimenFiscal` varchar(50) NOT NULL,
  PRIMARY KEY (`idregimenFiscal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of regimenFiscal
-- ----------------------------
INSERT INTO `regimenFiscal` VALUES ('1', 'Régimen de Incorporación Fiscal');

-- ----------------------------
-- Table structure for sucursal
-- ----------------------------
DROP TABLE IF EXISTS `sucursal`;
CREATE TABLE `sucursal` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `nombreSucursal` varchar(45) DEFAULT NULL,
  `empresa_idEmpresa` int(11) NOT NULL,
  `domiciliofiscal_idDomicilioFiscal` int(11) NOT NULL,
  PRIMARY KEY (`idSucursal`,`empresa_idEmpresa`,`domiciliofiscal_idDomicilioFiscal`),
  KEY `fk_sucursal_empresa1_idx` (`empresa_idEmpresa`),
  KEY `fk_sucursal_domiciliofiscal1_idx` (`domiciliofiscal_idDomicilioFiscal`),
  CONSTRAINT `fk_sucursal_domiciliofiscal1` FOREIGN KEY (`domiciliofiscal_idDomicilioFiscal`) REFERENCES `domiciliofiscal` (`idDomicilioFiscal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sucursal_empresa1` FOREIGN KEY (`empresa_idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sucursal
-- ----------------------------
INSERT INTO `sucursal` VALUES ('1', 'Sucursal Principal', '1', '1');

-- ----------------------------
-- Table structure for tipocomprobante
-- ----------------------------
DROP TABLE IF EXISTS `tipocomprobante`;
CREATE TABLE `tipocomprobante` (
  `idTipoComprobante` int(2) NOT NULL AUTO_INCREMENT,
  `codigoTipo` varchar(8) DEFAULT NULL,
  `descripcionComprobante` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idTipoComprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tipocomprobante
-- ----------------------------

-- ----------------------------
-- Table structure for tipoempleado
-- ----------------------------
DROP TABLE IF EXISTS `tipoempleado`;
CREATE TABLE `tipoempleado` (
  `idtipoEmpleado` int(2) NOT NULL AUTO_INCREMENT,
  `tipoEmpleado` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idtipoEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tipoempleado
-- ----------------------------
INSERT INTO `tipoempleado` VALUES ('1', 'Administrador');
INSERT INTO `tipoempleado` VALUES ('2', 'Contador');
INSERT INTO `tipoempleado` VALUES ('3', 'Recursos Humanos');

-- ----------------------------
-- Table structure for tipounidad
-- ----------------------------
DROP TABLE IF EXISTS `tipounidad`;
CREATE TABLE `tipounidad` (
  `idtipoUnidad` int(2) NOT NULL AUTO_INCREMENT,
  `codigoUnidad` varchar(8) DEFAULT NULL,
  `descripcionUnidad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idtipoUnidad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tipounidad
-- ----------------------------

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) NOT NULL,
  `passwordUsuario` varchar(45) NOT NULL,
  `statusUsuario` tinyint(4) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `usuario` VALUES ('2', 'lo', 'lo', '1');
INSERT INTO `usuario` VALUES ('3', 'null', 'null', '0');
INSERT INTO `usuario` VALUES ('4', 'null', 'null', '0');

-- ----------------------------
-- Table structure for venta
-- ----------------------------
DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `fechaVenta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `subTotalVenta` float NOT NULL,
  `ivaVenta` float NOT NULL,
  `totalVenta` float NOT NULL,
  `estatusVenta` varchar(10) NOT NULL,
  `tipoVenta` varchar(10) DEFAULT NULL,
  `cliente_idCliente` int(11) NOT NULL,
  `empleado_idEmpleado` int(11) NOT NULL,
  `tipoComprobante_idTipoComprobante` int(2) NOT NULL,
  PRIMARY KEY (`idVenta`,`tipoComprobante_idTipoComprobante`),
  KEY `fk_venta_cliente1_idx` (`cliente_idCliente`),
  KEY `fk_venta_empleado1_idx` (`empleado_idEmpleado`),
  KEY `fk_venta_tipoComprobante1_idx` (`tipoComprobante_idTipoComprobante`),
  CONSTRAINT `fk_venta_cliente1` FOREIGN KEY (`cliente_idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_venta_empleado1` FOREIGN KEY (`empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_tipoComprobante1` FOREIGN KEY (`tipoComprobante_idTipoComprobante`) REFERENCES `tipocomprobante` (`idTipoComprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of venta
-- ----------------------------
