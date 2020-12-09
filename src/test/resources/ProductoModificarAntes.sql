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