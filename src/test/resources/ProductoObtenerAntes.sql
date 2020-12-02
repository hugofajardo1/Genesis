DELETE FROM productos;
ALTER SEQUENCE seq_productos RESTART WITH 1;
INSERT INTO productos (id,nombre) VALUES(nextval('seq_productos'),'Producto 1');
INSERT INTO productos (id,nombre) VALUES(nextval('seq_productos'),'Producto 2');