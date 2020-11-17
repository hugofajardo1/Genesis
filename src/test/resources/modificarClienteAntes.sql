DELETE FROM clientes;

DELETE FROM clientes;

ALTER SEQUENCE seq_Clientes RESTART with 1;
INSERT INTO clientes (id, nombre, domicilio, telefono) VALUES (nextval('seq_Clientes'), 'Fajardo, Hugo', 'Bs As 245', '3825416543');
