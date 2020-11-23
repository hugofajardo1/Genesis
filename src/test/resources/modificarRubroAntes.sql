DELETE FROM rubros;
ALTER SEQUENCE seq_rubros RESTART WITH 1;
INSERT INTO rubros (id,nombre) VALUES(nextval('seq_rubros'),'Rubro');