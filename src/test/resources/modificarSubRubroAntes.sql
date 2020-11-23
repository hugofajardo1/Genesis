DELETE FROM subrubros;
ALTER SEQUENCE seq_subrubros RESTART WITH 1;
INSERT INTO rubros (id,nombre) VALUES(nextval('seq_subrubros'),'SubRubro');