DELETE FROM localidades;
ALTER SEQUENCE seq_localidades RESTART WITH 1;
INSERT INTO localidades (id,nombre) VALUES(nextval('seq_localidades'),'Ubicacion');