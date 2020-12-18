DELETE FROM puntosventas;

DELETE FROM sucursales;
ALTER SEQUENCE seq_sucursales RESTART WITH 1;
INSERT INTO sucursales (id,nombre) VALUES(nextval('seq_sucursales'),'Sucursal 1');
