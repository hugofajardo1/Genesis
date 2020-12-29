DELETE FROM tipo_operaciones;
ALTER SEQUENCE seq_tipo_operaciones RESTART WITH 1;
INSERT INTO tipo_operaciones (id,nombre) VALUES(nextval('seq_tipo_operaciones'),'Venta');