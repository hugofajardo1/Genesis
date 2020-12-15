DELETE FROM usuarios;

DELETE FROM sucursales;
ALTER SEQUENCE seq_sucursales RESTART WITH 1;
INSERT INTO sucursales (id,nombre) VALUES(nextval('seq_sucursales'),'Sucursal 1');

ALTER SEQUENCE seq_usuarios RESTART WITH 1;
INSERT INTO usuarios (id,nombre, nombreusuario, contrasenia, sucursalid) VALUES(nextval('seq_usuarios'),'Usuario 1', 'nusuario', 'contra', 1);
INSERT INTO usuarios (id,nombre, nombreusuario, contrasenia, sucursalid) VALUES(nextval('seq_usuarios'),'Usuario 2', 'nusuario2', 'contra2', 1);