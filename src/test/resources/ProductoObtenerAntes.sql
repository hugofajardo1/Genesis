DELETE FROM productos;

DELETE FROM tipo_unidades;
DELETE FROM rubros;
DELETE FROM subrubros;
DELETE FROM ubicaciones;

ALTER SEQUENCE seq_productos RESTART WITH 1;

ALTER SEQUENCE seq_tipo_unidades RESTART WITH 1;
INSERT INTO tipo_unidades (id, nombre) VALUES (nextval('seq_tipo_unidades'), 'Unidad');

ALTER SEQUENCE seq_rubros RESTART WITH 1;
INSERT INTO rubros (id, nombre) VALUES (nextval('seq_rubros'), 'Hardware');

ALTER SEQUENCE seq_subrubros RESTART WITH 1;
INSERT INTO subrubros (id, nombre) VALUES (nextval('seq_subrubros'), 'Perifericos');

ALTER SEQUENCE seq_ubicaciones RESTART WITH 1;
INSERT INTO ubicaciones (id, nombre) VALUES (nextval('seq_ubicaciones'), 'Estante 1');

INSERT INTO productos (id,nombre, codigousuario, tipounidadid, costo, iva, margen, flete, rubroid, subrubroid, ubicacionid) VALUES(nextval('seq_productos'),'Producto 1', 'F44234', 1, 100.0, 21.0, 35.0, 0.0, 1, 1, 1);
INSERT INTO productos (id,nombre, codigousuario, tipounidadid, costo, iva, margen, flete, rubroid, subrubroid, ubicacionid) VALUES(nextval('seq_productos'),'Producto 2', 'F44235', 1, 100.0, 21.0, 35.0, 0.0, 1, 1, 1);