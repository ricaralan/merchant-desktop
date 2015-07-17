/**
 *
 *Nombre de la base de datos(Schema)
 *
 **/

CREATE SCHEMA `db_merchant` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `db_merchant` ;


/**
 *
 * Tabla  `db_merchant`.`domicilio`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`domicilio` (
  `id_domicilio` INT(11) NOT NULL AUTO_INCREMENT,
  `dom_calle` VARCHAR(45) NOT NULL,
  `dom_numExt` VARCHAR(45) NULL DEFAULT NULL,
  `dom_numInt` VARCHAR(5) NULL DEFAULT NULL,
  `dom_colonia` VARCHAR(45) NULL DEFAULT NULL,
  `dom_cod_postal` VARCHAR(45) NULL DEFAULT NULL,
  `dom_localidad` VARCHAR(45) NULL DEFAULT NULL,
  `dom_municipio` VARCHAR(45) NULL DEFAULT NULL,
  `dom_estado` VARCHAR(45) NULL DEFAULT NULL,
  `dom_pais` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_domicilio`))
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`cliente`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `clte_rfc` VARCHAR(15) NOT NULL,
  `clte_nombre` VARCHAR(145) NOT NULL,
  `clte_tel` VARCHAR(15) NOT NULL,
  `clte_tel2` VARCHAR(15) NULL DEFAULT NULL,
  `clte_email` VARCHAR(45) NOT NULL,
  `clte_fecha_alta` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `clte_status` TINYINT(4) NULL DEFAULT NULL,
  `domicilio_fiscal_id_domicilio` INT(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_cliente_domicilio_fiscal1_idx` (`domicilio_fiscal_id_domicilio` ASC),
  CONSTRAINT `fk_cliente_domicilio_fiscal1`
    FOREIGN KEY (`domicilio_fiscal_id_domicilio`)
    REFERENCES `db_merchant`.`domicilio` (`id_domicilio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`regimen_fiscal`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`regimen_fiscal` (
  `id_reg_fiscal` INT NOT NULL AUTO_INCREMENT,
  `reg_fis_descripcion` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_reg_fiscal`))
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`empresa`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`empresa` (
  `id_empresa` INT(11) NOT NULL AUTO_INCREMENT,
  `emp_nombre` VARCHAR(45) NOT NULL,
  `emp_rfc` VARCHAR(15) NOT NULL,
  `emp_logo` VARCHAR(145) NULL DEFAULT NULL,
  `emp_tel` VARCHAR(15) NULL DEFAULT NULL,
  `emp_tel2` VARCHAR(15) NULL DEFAULT NULL,
  `emp_mail` VARCHAR(45) NULL DEFAULT NULL,
  `emp_web` VARCHAR(45) NULL DEFAULT NULL,
  `emp_alta` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `emp_regimen_fiscal_id_reg_fiscal` INT NOT NULL,
  PRIMARY KEY (`id_empresa`, `emp_regimen_fiscal_id_reg_fiscal`),
  INDEX `fk_empresa_regimenFiscal1_idx` (`emp_regimen_fiscal_id_reg_fiscal` ASC),
  CONSTRAINT `fk_empresa_regimenFiscal1`
    FOREIGN KEY (`emp_regimen_fiscal_id_reg_fiscal`)
    REFERENCES `db_merchant`.`regimen_fiscal` (`id_reg_fiscal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`sucursal`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`sucursal` (
  `id_sucursal` INT(11) NOT NULL AUTO_INCREMENT,
  `suc_nombre` VARCHAR(45) NULL DEFAULT NULL,
  `empresa_id_empresa` INT(11) NOT NULL,
  `domicilio_fiscal_id_domicilio` INT(11) NOT NULL,
  PRIMARY KEY (`id_sucursal`, `empresa_id_empresa`, `domicilio_fiscal_id_domicilio`),
  INDEX `fk_sucursal_empresa1_idx` (`empresa_id_empresa` ASC),
  INDEX `fk_sucursal_domicilio_fiscal1_idx` (`domicilio_fiscal_id_domicilio` ASC),
  CONSTRAINT `fk_sucursal_domicilio_fiscal1`
    FOREIGN KEY (`domicilio_fiscal_id_domicilio`)
    REFERENCES `db_merchant`.`domicilio` (`id_domicilio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sucursal_empresa1`
    FOREIGN KEY (`empresa_id_empresa`)
    REFERENCES `db_merchant`.`empresa` (`id_empresa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`tipo_empleado`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`tipo_empleado` (
  `id_tipo_empleado` INT(2) NOT NULL AUTO_INCREMENT,
  `tipo_empleado` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_empleado`))
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`usuario`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `usu_nombre` VARCHAR(45) NOT NULL,
  `usu_password` VARCHAR(45) NOT NULL,
  `usu_status` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`empleado`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`empleado` (
  `id_empleado` INT(11) NOT NULL AUTO_INCREMENT,
  `emp_rfc` VARCHAR(25) NOT NULL,
  `tipo_empleado_id_tipo_mpleado` INT(2) NOT NULL,
  `emp_nombre` VARCHAR(45) NOT NULL,
  `emp_apellidos` VARCHAR(60) NOT NULL,
  `emp_telefono` VARCHAR(45) NULL DEFAULT NULL,
  `emp_mail` VARCHAR(45) NULL DEFAULT NULL,
  `emp_salarioDiario` DOUBLE NOT NULL,
  `emp_diasLaborales` INT(11) NULL DEFAULT NULL,
  `emp_alta` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_id_usuario` INT(11) NOT NULL,
  `domicilio_fiscal_id_domicilio` INT(11) NOT NULL,
  `sucursal_id_sucursal` INT(11) NOT NULL,
  `emp_baja` TIMESTAMP NULL DEFAULT NULL,
  `emp_status` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id_empleado`, `sucursal_id_sucursal`),
  INDEX `fk_empleado_usuario1_idx` (`usuario_id_usuario` ASC),
  INDEX `fk_empleado_domicilio_fiscal1_idx` (`domicilio_fiscal_id_domicilio` ASC),
  INDEX `fk_empleado_sucursal1_idx` (`sucursal_id_sucursal` ASC),
  INDEX `fk_empleado_tipoEmpleado1_idx` (`tipo_empleado_id_tipo_mpleado` ASC),
  CONSTRAINT `fk_empleado_domicilio_fiscal1`
    FOREIGN KEY (`domicilio_fiscal_id_domicilio`)
    REFERENCES `db_merchant`.`domicilio` (`id_domicilio`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_empleado_sucursal1`
    FOREIGN KEY (`sucursal_id_sucursal`)
    REFERENCES `db_merchant`.`sucursal` (`id_sucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_tipoEmpleado1`
    FOREIGN KEY (`tipo_empleado_id_tipo_mpleado`)
    REFERENCES `db_merchant`.`tipo_empleado` (`id_tipo_empleado`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_empleado_usuario1`
    FOREIGN KEY (`usuario_id_usuario`)
    REFERENCES `db_merchant`.`usuario` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`proveedor`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`proveedor` (
  `id_proveedor` INT(11) NOT NULL AUTO_INCREMENT,
  `prov_rfc` VARCHAR(15) NOT NULL,
  `prov_nombre` VARCHAR(45) NOT NULL,
  `prov_tel` VARCHAR(15) NULL DEFAULT NULL,
  `prov_tel2` VARCHAR(15) NULL DEFAULT NULL,
  `prov_email` VARCHAR(45) NULL DEFAULT NULL,
  `domicilio_fiscal_id_domicilio` INT(11) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  INDEX `fk_proveedor_domicilio_fiscal1_idx` (`domicilio_fiscal_id_domicilio` ASC),
  CONSTRAINT `fk_proveedor_domicilio_fiscal1`
    FOREIGN KEY (`domicilio_fiscal_id_domicilio`)
    REFERENCES `db_merchant`.`domicilio` (`id_domicilio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`compra`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`compra` (
  `id_compra` INT(11) NOT NULL AUTO_INCREMENT,
  `cpra_fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `cpra_total` FLOAT NOT NULL,
  `cpra_tipo_pago` VARCHAR(10) NOT NULL,
  `cpra_status` VARCHAR(10) NOT NULL,
  `cpra_status_liquidez` TINYINT(4) NOT NULL,
  `cpra_fecha_pago_limite` DATE NULL DEFAULT NULL,
  `cpra_numero_pagos` INT(11) NULL DEFAULT NULL,
  `proveedor_id_proveedor` INT(11) NOT NULL,
  `empleado_id_empleado` INT(11) NOT NULL,
  PRIMARY KEY (`id_compra`),
  INDEX `fk_compra_proveedor1_idx` (`proveedor_id_proveedor` ASC),
  INDEX `fk_compra_empleado1_idx` (`empleado_id_empleado` ASC),
  CONSTRAINT `fk_compra_empleado1`
    FOREIGN KEY (`empleado_id_empleado`)
    REFERENCES `db_merchant`.`empleado` (`id_empleado`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_compra_proveedor1`
    FOREIGN KEY (`proveedor_id_proveedor`)
    REFERENCES `db_merchant`.`proveedor` (`id_proveedor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`impuesto`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`impuesto` (
  `id_impuesto` INT(2) NOT NULL AUTO_INCREMENT,
  `impto_codigo` VARCHAR(8) NULL DEFAULT NULL,
  `impto_descripcion` VARCHAR(50) NULL DEFAULT NULL,
  `impto_valor` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`id_impuesto`))
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`categoria`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`categoria` (
  `id_categoria` INT(2) NOT NULL AUTO_INCREMENT,
  `cat_codigo` VARCHAR(8) NULL DEFAULT NULL,
  `cat_descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`tipo_unidad`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`tipo_unidad` (
  `id_tipo_unidad` INT(2) NOT NULL AUTO_INCREMENT,
  `tip_und_codigo` VARCHAR(8) NULL DEFAULT NULL,
  `tip_und_descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_unidad`))
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`producto`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`producto` (
  `id_prod_cod_barra` VARCHAR(20) NOT NULL,
  `prod_descripcion` VARCHAR(95) NULL DEFAULT NULL,
  `prod_existencia` FLOAT NOT NULL,
  `prod_stock_minimo` FLOAT NOT NULL,
  `precio_venta` FLOAT NOT NULL,
  `tipo_unidad_id_tipo_unidad` INT(2) NOT NULL,
  `impuesto_id_impuesto` INT(2) NOT NULL,
  `prod_status` TINYINT(4) NULL DEFAULT NULL,
  `categoria_id_categoria` INT(11) NOT NULL,
  PRIMARY KEY (`id_prod_cod_barra`, `tipo_unidad_id_tipo_unidad`, `impuesto_id_impuesto`, `categoria_id_categoria`),
  INDEX `fk_producto_tipoUnidad1_idx` (`tipo_unidad_id_tipo_unidad` ASC),
  INDEX `fk_producto_impuesto1_idx` (`impuesto_id_impuesto` ASC),
  INDEX `fk_producto_categoria1_idx` (`categoria_id_categoria` ASC),
  CONSTRAINT `fk_producto_impuesto1`
    FOREIGN KEY (`impuesto_id_impuesto`)
    REFERENCES `db_merchant`.`impuesto` (`id_impuesto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_categoria1`
    FOREIGN KEY (`categoria_id_categoria`)
    REFERENCES `db_merchant`.`categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto_tipoUnidad1`
    FOREIGN KEY (`tipo_unidad_id_tipo_unidad`)
    REFERENCES `db_merchant`.`tipo_unidad` (`id_tipo_unidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`detalle_compra`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`detalle_compra` (
  `producto_id_prod_cod_barra` VARCHAR(20) NOT NULL,
  `compra_id_compra` INT(11) NOT NULL,
  `det_cpra_prod_costo_unitario` FLOAT NULL DEFAULT NULL,
  `det_cpra_prod_cantidad` FLOAT NOT NULL,
  PRIMARY KEY (`producto_id_prod_cod_barra`, `compra_id_compra`),
  INDEX `fk_producto_detalle_compra_compra1_idx` (`compra_id_compra` ASC),
  INDEX `fk_producto_detalle_compra_producto1_idx` (`producto_id_prod_cod_barra` ASC),
  CONSTRAINT `fk_producto_detalle_compra_compra1`
    FOREIGN KEY (`compra_id_compra`)
    REFERENCES `db_merchant`.`compra` (`id_compra`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_detalle_compra_producto1`
    FOREIGN KEY (`producto_id_prod_cod_barra`)
    REFERENCES `db_merchant`.`producto` (`id_prod_cod_barra`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`detalle_producto`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`detalle_producto` (
  `proveedor_id_proveedor` INT(11) NOT NULL,
  `producto_id_prod_cod_barra` VARCHAR(20) NOT NULL,
  `det_prod_precio_compra` FLOAT NOT NULL,
  PRIMARY KEY (`proveedor_id_proveedor`, `producto_id_prod_cod_barra`),
  INDEX `fk_proveedor_detalle_producto_producto1_idx` (`producto_id_prod_cod_barra` ASC),
  INDEX `fk_proveedor_detalle_producto_proveedor1_idx` (`proveedor_id_proveedor` ASC),
  CONSTRAINT `fk_proveedor_detalle_producto_producto1`
    FOREIGN KEY (`producto_id_prod_cod_barra`)
    REFERENCES `db_merchant`.`producto` (`id_prod_cod_barra`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_proveedor_detalle_producto_proveedor1`
    FOREIGN KEY (`proveedor_id_proveedor`)
    REFERENCES `db_merchant`.`proveedor` (`id_proveedor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`tipo_comprobante`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`tipo_comprobante` (
  `id_tipo_comprobante` INT(2) NOT NULL AUTO_INCREMENT,
  `tip_comp_codigo` VARCHAR(8) NULL DEFAULT NULL,
  `tip_comp_descripcion` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_comprobante`))
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`venta`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`venta` (
  `id_venta` INT(11) NOT NULL AUTO_INCREMENT,
  `vta_fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `vta_subTotal` FLOAT NOT NULL,
  `vta_iva` FLOAT NOT NULL,
  `vta_total` FLOAT NOT NULL,
  `vta_status` VARCHAR(10) NOT NULL,
  `vta_tipo` VARCHAR(10) NULL DEFAULT NULL,
  `cliente_id_cliente` INT(11) NOT NULL,
  `empleado_id_empleado` INT(11) NOT NULL,
  `tipo_comprobante_id_tipo_comprobante` INT(2) NOT NULL,
  PRIMARY KEY (`id_venta`, `tipo_comprobante_id_tipo_comprobante`),
  INDEX `fk_venta_cliente1_idx` (`cliente_id_cliente` ASC),
  INDEX `fk_venta_empleado1_idx` (`empleado_id_empleado` ASC),
  INDEX `fk_venta_tipoComprobante1_idx` (`tipo_comprobante_id_tipo_comprobante` ASC),
  CONSTRAINT `fk_venta_cliente1`
    FOREIGN KEY (`cliente_id_cliente`)
    REFERENCES `db_merchant`.`cliente` (`id_cliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_venta_empleado1`
    FOREIGN KEY (`empleado_id_empleado`)
    REFERENCES `db_merchant`.`empleado` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_tipoComprobante1`
    FOREIGN KEY (`tipo_comprobante_id_tipo_comprobante`)
    REFERENCES `db_merchant`.`tipo_comprobante` (`id_tipo_comprobante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`detalle_venta`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`detalle_venta` (
  `producto_id_prod_cod_barra` VARCHAR(20) NOT NULL,
  `venta_id_venta` INT(11) NOT NULL,
  `det_vta_cantidad` FLOAT NOT NULL,
  PRIMARY KEY (`producto_id_prod_cod_barra`, `venta_id_venta`),
  INDEX `fk_venta_detalle_producto_producto1_idx` (`producto_id_prod_cod_barra` ASC),
  INDEX `fk_venta_detalle_producto_venta1_idx` (`venta_id_venta` ASC),
  CONSTRAINT `fk_venta_detalle_producto_producto1`
    FOREIGN KEY (`producto_id_prod_cod_barra`)
    REFERENCES `db_merchant`.`producto` (`id_prod_cod_barra`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_venta_detalle_producto_venta1`
    FOREIGN KEY (`venta_id_venta`)
    REFERENCES `db_merchant`.`venta` (`id_venta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



/**
 *
 * Tabla  `db_merchant`.`pagos_compra`
 *
 */

CREATE TABLE IF NOT EXISTS `db_merchant`.`pagos_compra` (
  `id_pago_compra` INT(11) NOT NULL AUTO_INCREMENT,
  `pag_cpra_monto` VARCHAR(45) NULL DEFAULT NULL,
  `pag_cpra_fecha` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `compra_id_compra` INT(11) NOT NULL,
  PRIMARY KEY (`id_pago_compra`, `compra_id_compra`),
  INDEX `fk_pagosCompra_compra1_idx` (`compra_id_compra` ASC),
  CONSTRAINT `fk_pagosCompra_compra1`
    FOREIGN KEY (`compra_id_compra`)
    REFERENCES `db_merchant`.`compra` (`id_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
