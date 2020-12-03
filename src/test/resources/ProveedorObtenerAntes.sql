DELETE FROM proveedores;
ALTER SEQUENCE seq_proveedores RESTART WITH 1;
INSERT INTO proveedores (id,nombre) VALUES(nextval('seq_proveedores'),'proveedor 1');
INSERT INTO proveedores (id,nombre) VALUES(nextval('seq_proveedores'),'proveedor 2');