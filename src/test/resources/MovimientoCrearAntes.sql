DELETE FROM movimientositem;
DELETE FROM movimientos;

DELETE FROM puntosventas;
DELETE FROM sucursales;

DELETE FROM fichas;

DELETE FROM tipo_ivas;
DELETE FROM localidades;
DELETE FROM provincias;

ALTER SEQUENCE seq_sucursales RESTART WITH 1;
ALTER SEQUENCE seq_puntosventas RESTART WITH 1;
ALTER SEQUENCE seq_fichas RESTART WITH 1;
ALTER SEQUENCE seq_tipo_ivas RESTART WITH 1;
ALTER SEQUENCE seq_localidades RESTART WITH 1;
ALTER SEQUENCE seq_provincias RESTART WITH 1;

INSERT INTO sucursales (id,nombre) VALUES(nextval('seq_sucursales'),'Sucursal 1');
INSERT INTO puntosventas (id, nombre, sucursalid, tipofacturacion) VALUES(nextval('seq_puntosventas'),'Punto Venta 1', 1, 5);
INSERT INTO tipo_ivas (id, nombre) VALUES (nextval('seq_tipo_ivas'), 'Responsable Inscripto');
INSERT INTO localidades (id, nombre) VALUES (nextval('seq_localidades'), 'Chilecito');
INSERT INTO provincias (id, nombre) VALUES (nextval('seq_provincias'), 'La Rioja');

INSERT INTO fichas (id, nombre, domicilio, localidadid, provinciaid, telefono, tipo_ivaid, cuit, ibrutos, contacto) VALUES (nextval('seq_fichas'), 'Fajardo, Hugo', 'Bs As 245', 1, 1, '3825416543', 1, '20255071336', '007-43536-9', 'hugofajardo1@gmail.com');

DELETE FROM tipo_movimientos;

ALTER SEQUENCE seq_tipo_movimientos RESTART WITH 1;
INSERT INTO tipo_movimientos (id, nombre) VALUES (nextval('seq_tipo_movimientos'), 'Factura A');

DELETE FROM productos;

DELETE FROM tipo_unidades;
DELETE FROM rubros;
DELETE FROM subrubros;
DELETE FROM ubicaciones;
DELETE FROM proveedores;

ALTER SEQUENCE seq_productos RESTART WITH 1;

ALTER SEQUENCE seq_tipo_unidades RESTART WITH 1;
INSERT INTO tipo_unidades (id, nombre) VALUES (nextval('seq_tipo_unidades'), 'Unidad');

ALTER SEQUENCE seq_rubros RESTART WITH 1;
INSERT INTO rubros (id, nombre) VALUES (nextval('seq_rubros'), 'Hardware');

ALTER SEQUENCE seq_subrubros RESTART WITH 1;
INSERT INTO subrubros (id, nombre) VALUES (nextval('seq_subrubros'), 'Perifericos');

ALTER SEQUENCE seq_ubicaciones RESTART WITH 1;
INSERT INTO ubicaciones (id, nombre) VALUES (nextval('seq_ubicaciones'), 'Estante 1');

ALTER SEQUENCE seq_proveedores RESTART WITH 1;
INSERT INTO proveedores (id, nombre) VALUES (nextval('seq_proveedores'), 'Proveedor 1');

INSERT INTO productos (id,nombre, codigousuario, codigobarra, tipounidadid, costo, iva, margen, flete, rubroid, subrubroid, ubicacionid, proveedorid) VALUES(nextval('seq_productos'),'Producto 1', 'F44234', '770077007700770', 1, 100.0, 21.0, 35.0, 0.0, 1, 1, 1, 1);
