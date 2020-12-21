DELETE FROM permisos;
ALTER SEQUENCE seq_permisos RESTART WITH 1;
INSERT INTO permisos (id,nombre) VALUES(nextval('seq_permisos'),'Permiso 1');
INSERT INTO permisos (id,nombre) VALUES(nextval('seq_permisos'),'Permiso 2');