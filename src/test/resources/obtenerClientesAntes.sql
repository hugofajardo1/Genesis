DELETE FROM clientes;

ALTER SEQUENCE seq_clientes RESTART WITH 1;
INSERT INTO clientes (id, nombre, domicilio, telefono) VALUES (nextval('seq_clientes'), 'Fajardo, Hugo', 'Bs As 245', '3825416543');
INSERT INTO clientes (id, nombre, domicilio, telefono) VALUES (nextval('seq_clientes'), 'Fajardo, Lourdes', 'Juan XXIII 59', '3453454');