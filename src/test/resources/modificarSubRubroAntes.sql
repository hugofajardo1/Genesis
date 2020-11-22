DELETE FROM subrubros;
ALTER SEQUENCE seq_subrubros restart with 1;
INSERT INTO rubros (id,nombre) VALUES(nextval('seq_subrubros'),'SubRubro');