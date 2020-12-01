DELETE FROM fichas;

DELETE FROM tipo_ivas;
DELETE FROM localidades;
DELETE FROM provincias;

ALTER SEQUENCE seq_fichas RESTART WITH 1;
ALTER SEQUENCE seq_tipo_ivas RESTART WITH 1;
ALTER SEQUENCE seq_localidades RESTART WITH 1;
ALTER SEQUENCE seq_provincias RESTART WITH 1;

INSERT INTO tipo_ivas (id, nombre) VALUES (nextval('seq_tipo_ivas'), 'Responsable Inscripto');
INSERT INTO localidades (id, nombre) VALUES (nextval('seq_localidades'), 'Chilecito');
INSERT INTO provincias (id, nombre) VALUES (nextval('seq_provincias'), 'La Rioja');

INSERT INTO fichas (id, nombre, domicilio, localidadid, provinciaid, telefono, tipo_ivaid, cuit, ibrutos, contacto) VALUES (nextval('seq_fichas'), 'Fajardo, Hugo', 'Bs As 245', 1, 1, '3825416543', 1, '20255071336', '007-43536-9', 'hugofajardo1@gmail.com');
INSERT INTO fichas (id, nombre, domicilio, localidadid, provinciaid, telefono, tipo_ivaid, cuit, ibrutos, contacto) VALUES (nextval('seq_fichas'), 'Fajardo, Lourdes', 'Juan XXIII 59', 1, 1, '3825121212', 1, '20255071336', '007-43536-9', 'luli@gmail.com');