DELETE FROM provincias;
ALTER SEQUENCE seq_provincias RESTART WITH 1;
INSERT INTO provincias (id,nombre) VALUES(nextval('seq_provincias'),'provincia');