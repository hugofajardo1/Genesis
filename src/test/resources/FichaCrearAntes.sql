DELETE FROM fichas;
DELETE FROM tipo_ivas;
DELETE FROM localidades;
DELETE FROM provincias;

ALTER SEQUENCE seq_tipo_ivas RESTART WITH 1;
INSERT INTO tipo_ivas (id, nombre) VALUES (nextval('seq_tipo_ivas'), 'Responsable Inscripto');
INSERT INTO tipo_ivas (id, nombre) VALUES (nextval('seq_tipo_ivas'), 'Consumidor Final');

ALTER SEQUENCE seq_localidades RESTART WITH 1;
INSERT INTO localidades (id, nombre) VALUES (nextval('seq_localidades'), 'Chilecito');
INSERT INTO localidades (id, nombre) VALUES (nextval('seq_localidades'), 'La Rioja');

ALTER SEQUENCE seq_provincias RESTART WITH 1;
INSERT INTO provincias (id, nombre) VALUES (nextval('seq_provincias'), 'La Rioja');