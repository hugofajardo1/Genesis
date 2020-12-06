DELETE FROM usuarios;

ALTER SEQUENCE seq_usuarios RESTART WITH 1;
INSERT INTO usuarios (id, nombre) VALUES (nextval('seq_usuarios'), 'Usuario 1');
INSERT INTO usuarios (id, nombre) VALUES (nextval('seq_usuarios'), 'Usuario 2');