DELETE FROM tipo_fichas;

ALTER SEQUENCE seq_tipo_fichas RESTART with 1;
INSERT INTO tipo_fichas (id, nombre) VALUES (nextval('seq_tipo_fichas'), 'Cliente');
INSERT INTO tipo_fichas (id, nombre) VALUES (nextval('seq_tipo_fichas'), 'Proveedor');