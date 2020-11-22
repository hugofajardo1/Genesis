DELETE FROM rubros;
ALTER SEQUENCE seq_rubros restart with 1;
INSERT INTO rubros (id,nombre) VALUES(nextval('seq_rubros'),'Rubro');