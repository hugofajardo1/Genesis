DELETE FROM vendedores;

ALTER SEQUENCE seq_vendedores RESTART WITH 1;
INSERT INTO vendedores (id, nombre) VALUES (nextval('seq_vendedores'), 'Vendedor 1');
INSERT INTO vendedores (id, nombre) VALUES (nextval('seq_vendedores'), 'Vendedor 2');