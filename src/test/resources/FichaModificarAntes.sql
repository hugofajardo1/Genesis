DELETE FROM fichas;

DELETE FROM tipo_ivas;

ALTER SEQUENCE seq_fichas RESTART WITH 1;
ALTER SEQUENCE seq_tipo_ivas RESTART WITH 1;

INSERT INTO tipo_ivas (id, nombre) VALUES (nextval('seq_tipo_ivas'), 'Responsable Inscripto');

INSERT INTO fichas (id, nombre, domicilio, telefono, tipo_ivaid, cuit) VALUES (nextval('seq_fichas'), 'Fajardo, Hugo', 'Bs As 245', '3825416543', 1, '20255071336');
