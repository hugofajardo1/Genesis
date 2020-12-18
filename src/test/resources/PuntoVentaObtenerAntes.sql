DELETE FROM puntosventas;

DELETE FROM sucursales;
ALTER SEQUENCE seq_sucursales RESTART WITH 1;
INSERT INTO sucursales (id,nombre) VALUES(nextval('seq_sucursales'),'Sucursal 1');

ALTER SEQUENCE seq_puntosventas RESTART WITH 1;
INSERT INTO puntosventas (id, nombre, sucursalid, tipofacturacion) VALUES(nextval('seq_puntosventas'),'Punto Venta 1', 1, 5);
INSERT INTO puntosventas (id, nombre, sucursalid, tipofacturacion) VALUES(nextval('seq_puntosventas'),'Punto Venta 2', 1, 5);