DELETE FROM subrubros;

ALTER SEQUENCE seq_subrubros RESTART with 1;
INSERT INTO subrubros (id, nombre) VALUES (nextval('seq_subrubros'), 'SubRubro 1');
INSERT INTO subrubros (id, nombre) VALUES (nextval('seq_subrubros'), 'SubRubro 2');