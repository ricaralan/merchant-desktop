/*
Navicat MySQL Data Transfer

Source Server         : Conexión Apache Alternativa
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : db_merchant

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-07-16 20:24:55
*/
CREATE DATABASE db_merchant;
USE db_merchant;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for categoria
-- ----------------------------
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id_categoria` int(2) NOT NULL AUTO_INCREMENT,
  `cat_codigo` varchar(8) DEFAULT NULL,
  `cat_descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categoria
-- ----------------------------

-- ----------------------------
-- Table structure for cliente
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `clte_rfc` varchar(15) NOT NULL,
  `clte_nombre` varchar(145) NOT NULL,
  `clte_tel` varchar(15) NOT NULL,
  `clte_tel2` varchar(15) DEFAULT NULL,
  `clte_email` varchar(45) NOT NULL,
  `clte_fecha_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `clte_status` tinyint(4) DEFAULT NULL,
  `domicilio_fiscal_id_domicilio` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `fk_cliente_domicilio_fiscal1_idx` (`domicilio_fiscal_id_domicilio`),
  CONSTRAINT `fk_cliente_domicilio_fiscal1` FOREIGN KEY (`domicilio_fiscal_id_domicilio`) REFERENCES `domicilio` (`id_domicilio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cliente
-- ----------------------------

-- ----------------------------
-- Table structure for compra
-- ----------------------------
DROP TABLE IF EXISTS `compra`;
CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL AUTO_INCREMENT,
  `cpra_fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cpra_total` float NOT NULL,
  `cpra_tipo_pago` varchar(10) NOT NULL,
  `cpra_status` varchar(10) NOT NULL,
  `cpra_status_liquidez` tinyint(4) NOT NULL,
  `cpra_fecha_pago_limite` date DEFAULT NULL,
  `cpra_numero_pagos` int(11) DEFAULT NULL,
  `proveedor_id_proveedor` int(11) NOT NULL,
  `empleado_id_empleado` int(11) NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `fk_compra_proveedor1_idx` (`proveedor_id_proveedor`),
  KEY `fk_compra_empleado1_idx` (`empleado_id_empleado`),
  CONSTRAINT `fk_compra_empleado1` FOREIGN KEY (`empleado_id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_compra_proveedor1` FOREIGN KEY (`proveedor_id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of compra
-- ----------------------------

-- ----------------------------
-- Table structure for detalle_compra
-- ----------------------------
DROP TABLE IF EXISTS `detalle_compra`;
CREATE TABLE `detalle_compra` (
  `producto_id_prod_cod_barra` varchar(20) NOT NULL,
  `compra_id_compra` int(11) NOT NULL,
  `det_cpra_prod_costo_unitario` float DEFAULT NULL,
  `det_cpra_prod_cantidad` float NOT NULL,
  PRIMARY KEY (`producto_id_prod_cod_barra`,`compra_id_compra`),
  KEY `fk_producto_detalle_compra_compra1_idx` (`compra_id_compra`),
  KEY `fk_producto_detalle_compra_producto1_idx` (`producto_id_prod_cod_barra`),
  CONSTRAINT `fk_producto_detalle_compra_compra1` FOREIGN KEY (`compra_id_compra`) REFERENCES `compra` (`id_compra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_detalle_compra_producto1` FOREIGN KEY (`producto_id_prod_cod_barra`) REFERENCES `producto` (`id_prod_cod_barra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detalle_compra
-- ----------------------------

-- ----------------------------
-- Table structure for detalle_producto
-- ----------------------------
DROP TABLE IF EXISTS `detalle_producto`;
CREATE TABLE `detalle_producto` (
  `proveedor_id_proveedor` int(11) NOT NULL,
  `producto_id_prod_cod_barra` varchar(20) NOT NULL,
  `det_prod_precio_compra` float NOT NULL,
  PRIMARY KEY (`proveedor_id_proveedor`,`producto_id_prod_cod_barra`),
  KEY `fk_proveedor_detalle_producto_producto1_idx` (`producto_id_prod_cod_barra`),
  KEY `fk_proveedor_detalle_producto_proveedor1_idx` (`proveedor_id_proveedor`),
  CONSTRAINT `fk_proveedor_detalle_producto_producto1` FOREIGN KEY (`producto_id_prod_cod_barra`) REFERENCES `producto` (`id_prod_cod_barra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proveedor_detalle_producto_proveedor1` FOREIGN KEY (`proveedor_id_proveedor`) REFERENCES `proveedor` (`id_proveedor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detalle_producto
-- ----------------------------

-- ----------------------------
-- Table structure for detalle_venta
-- ----------------------------
DROP TABLE IF EXISTS `detalle_venta`;
CREATE TABLE `detalle_venta` (
  `producto_id_prod_cod_barra` varchar(20) NOT NULL,
  `venta_id_venta` int(11) NOT NULL,
  `det_vta_cantidad` float NOT NULL,
  PRIMARY KEY (`producto_id_prod_cod_barra`,`venta_id_venta`),
  KEY `fk_venta_detalle_producto_producto1_idx` (`producto_id_prod_cod_barra`),
  KEY `fk_venta_detalle_producto_venta1_idx` (`venta_id_venta`),
  CONSTRAINT `fk_venta_detalle_producto_producto1` FOREIGN KEY (`producto_id_prod_cod_barra`) REFERENCES `producto` (`id_prod_cod_barra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_venta_detalle_producto_venta1` FOREIGN KEY (`venta_id_venta`) REFERENCES `venta` (`id_venta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detalle_venta
-- ----------------------------

-- ----------------------------
-- Table structure for domicilio
-- ----------------------------
DROP TABLE IF EXISTS `domicilio`;
CREATE TABLE `domicilio` (
  `id_domicilio` int(11) NOT NULL AUTO_INCREMENT,
  `dom_calle` varchar(45) NOT NULL,
  `dom_numExt` varchar(45) DEFAULT NULL,
  `dom_numInt` varchar(5) DEFAULT NULL,
  `dom_colonia` varchar(45) DEFAULT NULL,
  `dom_cod_postal` varchar(45) DEFAULT NULL,
  `dom_localidad` varchar(45) DEFAULT NULL,
  `dom_municipio` varchar(45) DEFAULT NULL,
  `dom_estado` varchar(45) DEFAULT NULL,
  `dom_pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_domicilio`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of domicilio
-- ----------------------------
INSERT INTO `domicilio` VALUES ('1', 'Av. Avila Camacho ', '1010', '02', 'Obrero Campesino', '91000', 'Xalapa', 'Xalapa', 'Veracruz', 'México');

-- ----------------------------
-- Table structure for empleado
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `id_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `emp_rfc` varchar(25) NOT NULL,
  `tipo_empleado_id_tipo_empleado` int(2) NOT NULL,
  `emp_nombre` varchar(45) NOT NULL,
  `emp_apellidos` varchar(60) NOT NULL,
  `emp_telefono_celular` varchar(20) DEFAULT NULL,
  `emp_telefono_casa` varchar(20) DEFAULT NULL,
  `emp_email` varchar(45) DEFAULT NULL,
  `emp_salario_diario` double NOT NULL,
  `emp_dias_laborales` int(11) DEFAULT NULL,
  `emp_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_id_usuario` int(11) NOT NULL,
  `domicilio_id_domicilio` int(11) NOT NULL,
  `sucursal_id_sucursal` int(11) NOT NULL,
  `emp_baja` timestamp NULL DEFAULT NULL,
  `emp_status` tinyint(4) DEFAULT '1',
  `imagen_empleado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`,`sucursal_id_sucursal`,`domicilio_id_domicilio`,`usuario_id_usuario`),
  KEY `fk_empleado_usuario1_idx` (`usuario_id_usuario`),
  KEY `fk_empleado_sucursal1_idx` (`sucursal_id_sucursal`),
  KEY `fk_empleado_tipoEmpleado1_idx` (`tipo_empleado_id_tipo_empleado`),
  KEY `fk_empleado_domicilio_fiscal1_idx` (`domicilio_id_domicilio`) USING BTREE,
  CONSTRAINT `fk_empleado_domicilio_fiscal1` FOREIGN KEY (`domicilio_id_domicilio`) REFERENCES `domicilio` (`id_domicilio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_empleado_sucursal1` FOREIGN KEY (`sucursal_id_sucursal`) REFERENCES `sucursal` (`id_sucursal`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_empleado_tipoEmpleado1` FOREIGN KEY (`tipo_empleado_id_tipo_empleado`) REFERENCES `tipo_empleado` (`id_tipo_empleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_empleado_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of empleado
-- ----------------------------
INSERT INTO `empleado` VALUES ('1', 'XAXX010101000', '1', 'Administrador', '', null, null, 'administrador@gmail.com', '0', null, '2015-07-16 20:05:35', '1', '1', '1', null, '1', null);

-- ----------------------------
-- Table structure for empresa
-- ----------------------------
DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `id_empresa` int(11) NOT NULL AUTO_INCREMENT,
  `emp_nombre` varchar(45) NOT NULL,
  `emp_rfc` varchar(15) NOT NULL COMMENT 'Se debe de ingresar el RFC con homoclave, lo cual ayudará para emitir comprobantes fiscales',
  `emp_logo` varchar(145) DEFAULT NULL,
  `emp_tel` varchar(15) DEFAULT NULL,
  `emp_tel2` varchar(15) DEFAULT NULL,
  `emp_email` varchar(45) DEFAULT NULL,
  `emp_web` varchar(45) DEFAULT NULL,
  `emp_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `regimen_id_regimen` int(11) NOT NULL,
  PRIMARY KEY (`id_empresa`,`regimen_id_regimen`),
  KEY `fk_empresa_regimenFiscal1_idx` (`regimen_id_regimen`),
  CONSTRAINT `fk_empresa_regimenFiscal1` FOREIGN KEY (`regimen_id_regimen`) REFERENCES `regimen` (`id_regimen`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Cuando la empresa emite facturas a clientes como publico general se debe de \r\nutilizar el RFC generico XAXX010101000 y en el caso de que se cliente extranjero\r\nse debe de utilizar el RC generico exclusivo para ellos: XEXX010101000';

-- ----------------------------
-- Records of empresa
-- ----------------------------
INSERT INTO `empresa` VALUES ('1', 'Empresa Merchant S.A. de C.V.', 'FERA19901994', null, '2288462124', '2282030394', 'support-merchant@merchant.com', 'http://www.merchant.com', '2015-07-16 17:21:34', '5');

-- ----------------------------
-- Table structure for impuesto
-- ----------------------------
DROP TABLE IF EXISTS `impuesto`;
CREATE TABLE `impuesto` (
  `id_impuesto` int(2) NOT NULL AUTO_INCREMENT,
  `impto_codigo` varchar(8) DEFAULT NULL,
  `impto_descripcion` varchar(50) DEFAULT NULL,
  `impto_valor` float DEFAULT NULL,
  PRIMARY KEY (`id_impuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of impuesto
-- ----------------------------
INSERT INTO `impuesto` VALUES ('1', 'TASA 0%', 'TASA CERO', '0');
INSERT INTO `impuesto` VALUES ('2', 'IVA', 'IMPUESTO AL VALOR AGREGADO', '0.16');
INSERT INTO `impuesto` VALUES ('3', 'ISR', 'IMPUESTO SOBRE LA RENTA', '0');
INSERT INTO `impuesto` VALUES ('4', 'IEPS', 'IMPUESTO ESPECIAL SOBRE PRODUCCIÓN Y SERVICIOS', '0');
INSERT INTO `impuesto` VALUES ('5', 'IDE', 'IMPUESTO SOBRE DEPÓSITO EN EFECTIVO', '0');
INSERT INTO `impuesto` VALUES ('6', 'IETU', 'IMPUESTO EMPRESARIAL A TASA ÚNICA', '0');

-- ----------------------------
-- Table structure for pagos_compra
-- ----------------------------
DROP TABLE IF EXISTS `pagos_compra`;
CREATE TABLE `pagos_compra` (
  `id_pago_compra` int(11) NOT NULL AUTO_INCREMENT,
  `pag_cpra_monto` varchar(45) DEFAULT NULL,
  `pag_cpra_fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `compra_id_compra` int(11) NOT NULL,
  PRIMARY KEY (`id_pago_compra`,`compra_id_compra`),
  KEY `fk_pagosCompra_compra1_idx` (`compra_id_compra`),
  CONSTRAINT `fk_pagosCompra_compra1` FOREIGN KEY (`compra_id_compra`) REFERENCES `compra` (`id_compra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pagos_compra
-- ----------------------------

-- ----------------------------
-- Table structure for producto
-- ----------------------------
DROP TABLE IF EXISTS `producto`;
CREATE TABLE `producto` (
  `id_prod_cod_barra` varchar(20) NOT NULL,
  `prod_descripcion` varchar(95) DEFAULT NULL,
  `prod_existencia` float NOT NULL,
  `prod_stock_minimo` float NOT NULL,
  `precio_venta` float NOT NULL,
  `tipo_unidad_id_tipo_unidad` int(2) NOT NULL,
  `impuesto_id_impuesto` int(2) NOT NULL,
  `prod_status` tinyint(4) DEFAULT NULL,
  `categoria_id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id_prod_cod_barra`,`tipo_unidad_id_tipo_unidad`,`impuesto_id_impuesto`,`categoria_id_categoria`),
  KEY `fk_producto_tipoUnidad1_idx` (`tipo_unidad_id_tipo_unidad`),
  KEY `fk_producto_impuesto1_idx` (`impuesto_id_impuesto`),
  KEY `fk_producto_categoria1_idx` (`categoria_id_categoria`),
  CONSTRAINT `fk_producto_categoria1` FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_impuesto1` FOREIGN KEY (`impuesto_id_impuesto`) REFERENCES `impuesto` (`id_impuesto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_tipoUnidad1` FOREIGN KEY (`tipo_unidad_id_tipo_unidad`) REFERENCES `unidad_medida` (`id_tipo_unidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of producto
-- ----------------------------

-- ----------------------------
-- Table structure for proveedor
-- ----------------------------
DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `prov_rfc` varchar(15) NOT NULL,
  `prov_nombre` varchar(45) NOT NULL,
  `prov_tel` varchar(15) DEFAULT NULL,
  `prov_tel2` varchar(15) DEFAULT NULL,
  `prov_email` varchar(45) DEFAULT NULL,
  `domicilio_fiscal_id_domicilio` int(11) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  KEY `fk_proveedor_domicilio_fiscal1_idx` (`domicilio_fiscal_id_domicilio`),
  CONSTRAINT `fk_proveedor_domicilio_fiscal1` FOREIGN KEY (`domicilio_fiscal_id_domicilio`) REFERENCES `domicilio` (`id_domicilio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of proveedor
-- ----------------------------

-- ----------------------------
-- Table structure for regimen
-- ----------------------------
DROP TABLE IF EXISTS `regimen`;
CREATE TABLE `regimen` (
  `id_regimen` int(11) NOT NULL AUTO_INCREMENT,
  `reg_descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_regimen`),
  KEY `id_regimen` (`id_regimen`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='Regímenes emitidos por el SAT';

-- ----------------------------
-- Records of regimen
-- ----------------------------
INSERT INTO `regimen` VALUES ('1', 'ASALARIADOS');
INSERT INTO `regimen` VALUES ('2', 'HONORARIOS(SERVICIOS PROFECIONALES)');
INSERT INTO `regimen` VALUES ('3', 'ARRENDAMIENTO DE INMUEBLES');
INSERT INTO `regimen` VALUES ('4', 'ACTIVIDADES EMPRESARIALES');
INSERT INTO `regimen` VALUES ('5', 'INCORPORACION FISCAL');
INSERT INTO `regimen` VALUES ('6', 'PERSONAS MORALES DEL R�GIMEN GENERAL');
INSERT INTO `regimen` VALUES ('7', 'PERSONAS MORALES CON FINES NO LUCRATIVOS');
INSERT INTO `regimen` VALUES ('8', 'ASOCIACIONES RELIGIOSAS');
INSERT INTO `regimen` VALUES ('9', 'R�GIMEN FISCAL DE EXTRANJEROS QUE PERCIBEN INGRESO');

-- ----------------------------
-- Table structure for sucursal
-- ----------------------------
DROP TABLE IF EXISTS `sucursal`;
CREATE TABLE `sucursal` (
  `id_sucursal` int(11) NOT NULL AUTO_INCREMENT,
  `suc_nombre` varchar(45) DEFAULT NULL,
  `empresa_id_empresa` int(11) NOT NULL,
  `domicilio_id_domicilio` int(11) NOT NULL,
  PRIMARY KEY (`id_sucursal`,`empresa_id_empresa`,`domicilio_id_domicilio`),
  KEY `fk_sucursal_empresa1_idx` (`empresa_id_empresa`),
  KEY `fk_sucursal_domicilio_fiscal1_idx` (`domicilio_id_domicilio`),
  CONSTRAINT `fk_sucursal_domicilio_fiscal1` FOREIGN KEY (`domicilio_id_domicilio`) REFERENCES `domicilio` (`id_domicilio`) ON UPDATE CASCADE,
  CONSTRAINT `fk_sucursal_empresa1` FOREIGN KEY (`empresa_id_empresa`) REFERENCES `empresa` (`id_empresa`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sucursal
-- ----------------------------
INSERT INTO `sucursal` VALUES ('1', 'Xalapa', '1', '1');

-- ----------------------------
-- Table structure for tipo_comprobante
-- ----------------------------
DROP TABLE IF EXISTS `tipo_comprobante`;
CREATE TABLE `tipo_comprobante` (
  `id_tipo_comprobante` int(2) NOT NULL AUTO_INCREMENT,
  `tip_comp_codigo` varchar(8) DEFAULT NULL,
  `tip_comp_descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_comprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tipo_comprobante
-- ----------------------------

-- ----------------------------
-- Table structure for tipo_empleado
-- ----------------------------
DROP TABLE IF EXISTS `tipo_empleado`;
CREATE TABLE `tipo_empleado` (
  `id_tipo_empleado` int(2) NOT NULL AUTO_INCREMENT,
  `tipo_empleado` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tipo_empleado
-- ----------------------------
INSERT INTO `tipo_empleado` VALUES ('1', 'Administrador');
INSERT INTO `tipo_empleado` VALUES ('2', 'Vendedor');
INSERT INTO `tipo_empleado` VALUES ('3', 'Recursos Humanos');
INSERT INTO `tipo_empleado` VALUES ('4', 'Finanzas');
INSERT INTO `tipo_empleado` VALUES ('5', 'Contador');

-- ----------------------------
-- Table structure for unidad_medida
-- ----------------------------
DROP TABLE IF EXISTS `unidad_medida`;
CREATE TABLE `unidad_medida` (
  `id_tipo_unidad` int(2) NOT NULL AUTO_INCREMENT,
  `tip_und_codigo` varchar(8) DEFAULT NULL,
  `tip_und_descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_unidad`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unidad_medida
-- ----------------------------
INSERT INTO `unidad_medida` VALUES ('1', 'KG', 'KILO');
INSERT INTO `unidad_medida` VALUES ('2', 'GR', 'GRAMO');
INSERT INTO `unidad_medida` VALUES ('3', 'M LINEAL', 'METRO LINEAL');
INSERT INTO `unidad_medida` VALUES ('4', 'M2', 'METRO CUADRADO');
INSERT INTO `unidad_medida` VALUES ('5', 'M3', 'METRO CUBICO');
INSERT INTO `unidad_medida` VALUES ('6', 'PZ', 'PIEZA');
INSERT INTO `unidad_medida` VALUES ('7', 'CZA', 'CABEZA');
INSERT INTO `unidad_medida` VALUES ('8', 'LT', 'LITRO');
INSERT INTO `unidad_medida` VALUES ('9', 'PAR', 'PAR');
INSERT INTO `unidad_medida` VALUES ('10', 'KW', 'KILOWATT');
INSERT INTO `unidad_medida` VALUES ('11', 'MILLAR', 'MILLAR');
INSERT INTO `unidad_medida` VALUES ('12', 'JUEGO', 'JUEGO');
INSERT INTO `unidad_medida` VALUES ('13', 'KW/HR', 'KILOWATT/HORA');
INSERT INTO `unidad_medida` VALUES ('14', 'TON', 'TONELADA');
INSERT INTO `unidad_medida` VALUES ('15', 'BARRIL', 'BARRIL');
INSERT INTO `unidad_medida` VALUES ('16', 'GR. NTO', 'GRAMO NETO');
INSERT INTO `unidad_medida` VALUES ('17', 'DEC', 'DECENAS');
INSERT INTO `unidad_medida` VALUES ('18', 'CEN', 'CIENTOS');
INSERT INTO `unidad_medida` VALUES ('19', 'DOC', 'DOCENAS');
INSERT INTO `unidad_medida` VALUES ('20', 'CJ', 'CAJA');
INSERT INTO `unidad_medida` VALUES ('21', 'BOT', 'BOTELLA');
INSERT INTO `unidad_medida` VALUES ('22', 'N/P', 'NO APLICA');

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usu_nombre` varchar(45) NOT NULL COMMENT 'nombre que se asigna a un empleado para que pueda acceder a la aplicación',
  `usu_password` varchar(45) NOT NULL,
  `usu_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT 'Define si el usuario esta activo(1), inactivo(0),asignado a un empleado en especifico(2)',
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES ('1', 'admin', 'admin', '1');

-- ----------------------------
-- Table structure for venta
-- ----------------------------
DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `vta_fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `vta_subTotal` float NOT NULL,
  `vta_iva` float NOT NULL,
  `vta_total` float NOT NULL,
  `vta_status` varchar(10) NOT NULL,
  `vta_tipo` varchar(10) DEFAULT NULL,
  `cliente_id_cliente` int(11) NOT NULL,
  `empleado_id_empleado` int(11) NOT NULL,
  `tipo_comprobante_id_tipo_comprobante` int(2) NOT NULL,
  PRIMARY KEY (`id_venta`,`tipo_comprobante_id_tipo_comprobante`),
  KEY `fk_venta_cliente1_idx` (`cliente_id_cliente`),
  KEY `fk_venta_empleado1_idx` (`empleado_id_empleado`),
  KEY `fk_venta_tipoComprobante1_idx` (`tipo_comprobante_id_tipo_comprobante`),
  CONSTRAINT `fk_venta_cliente1` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_venta_empleado1` FOREIGN KEY (`empleado_id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_tipoComprobante1` FOREIGN KEY (`tipo_comprobante_id_tipo_comprobante`) REFERENCES `tipo_comprobante` (`id_tipo_comprobante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of venta
-- ----------------------------
