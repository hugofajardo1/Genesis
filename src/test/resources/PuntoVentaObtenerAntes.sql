DELETE FROM puntosventas;
ALTER SEQUENCE seq_puntosventas RESTART WITH 1;
INSERT INTO puntosventas (id, nombre, tipofacturacion) VALUES(nextval('seq_puntosventas'),'Punto Venta 1', 5);
INSERT INTO puntosventas (id, nombre, tipofacturacion) VALUES(nextval('seq_puntosventas'),'Punto Venta 2', 5);