DELETE FROM permisosusuarios;
DELETE FROM permisos;
DELETE FROM usuarios;
DELETE FROM sucursales;

ALTER SEQUENCE seq_permisos RESTART WITH 1;
INSERT INTO permisos (id,nombre) VALUES(nextval('seq_permisos'),'Permiso 1');
INSERT INTO permisos (id,nombre) VALUES(nextval('seq_permisos'),'Permiso 2');

ALTER SEQUENCE seq_sucursales RESTART WITH 1;
INSERT INTO sucursales (id,nombre) VALUES(nextval('seq_sucursales'),'Sucursal 1');

ALTER SEQUENCE seq_usuarios RESTART WITH 1;
INSERT INTO usuarios (id,nombre, nombreusuario, contrasenia, sucursalid) VALUES(nextval('seq_usuarios'),'Usuario 1', 'nusuario', 'contra', 1);

ALTER SEQUENCE seq_permisosusuarios RESTART WITH 1;
INSERT INTO permisosusuarios(id, permisoid, usuarioid) VALUES(nextval('seq_permisosusuarios'), 1, 1);
INSERT INTO permisosusuarios(id, permisoid, usuarioid) VALUES(nextval('seq_permisosusuarios'), 2, 1);