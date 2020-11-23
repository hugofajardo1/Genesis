DELETE FROM tipo_ivas;

ALTER SEQUENCE seq_tipo_ivas RESTART WITH 1;
INSERT INTO tipo_ivas (id, nombre) VALUES (nextval('seq_tipo_ivas'), 'Responsable Inscripto');
INSERT INTO tipo_ivas (id, nombre) VALUES (nextval('seq_tipo_ivas'), 'Consumidor Final');