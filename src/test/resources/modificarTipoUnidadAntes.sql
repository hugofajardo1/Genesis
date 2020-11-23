DELETE FROM tipo_unidades;
ALTER SEQUENCE seq_tipo_unidades RESTART WITH 1;
INSERT INTO tipo_unidades (id,nombre) VALUES(nextval('seq_tipo_unidades'),'Unidad');