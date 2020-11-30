DELETE FROM ubicaciones;

ALTER SEQUENCE seq_ubicaciones RESTART WITH 1;
INSERT INTO ubicaciones (id, nombre) VALUES (nextval('seq_ubicaciones'), 'Ubicacion 1');
INSERT INTO ubicaciones (id, nombre) VALUES (nextval('seq_ubicaciones'), 'Ubicacion 2');