DELETE FROM tipo_movimientos;

ALTER SEQUENCE seq_tipo_movimientos RESTART WITH 1;
INSERT INTO tipo_movimientos (id, nombre, imputacion) VALUES (nextval('seq_tipo_movimientos'), 'Factura A', 'Debe');
INSERT INTO tipo_movimientos (id, nombre, imputacion) VALUES (nextval('seq_tipo_movimientos'), 'Nota de Debito A', 'Debe');