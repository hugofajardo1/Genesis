DELETE FROM clientes;

DELETE FROM tipo_ivas;

ALTER SEQUENCE seq_clientes RESTART WITH 1;
ALTER SEQUENCE seq_tipo_ivas RESTART WITH 1;

INSERT INTO tipo_ivas (id, nombre) VALUES (nextval('seq_tipo_ivas'), 'Responsable Inscripto');

INSERT INTO clientes (id, nombre, domicilio, telefono, tipo_ivaid) VALUES (nextval('seq_Clientes'), 'Fajardo, Hugo', 'Bs As 245', '3825416543', 1);
