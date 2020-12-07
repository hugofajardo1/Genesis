DELETE FROM usuarios;

ALTER SEQUENCE seq_usuarios RESTART WITH 1;
INSERT INTO usuarios (id,nombre, nombreusuario, contrasenia) VALUES(nextval('seq_usuarios'),'Usuario 1', 'nusuario', 'contra');
INSERT INTO usuarios (id,nombre, nombreusuario, contrasenia) VALUES(nextval('seq_usuarios'),'Usuario 2', 'nusuario2', 'contra2');