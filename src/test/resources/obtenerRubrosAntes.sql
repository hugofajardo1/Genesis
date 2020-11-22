DELETE FROM rubros;

ALTER SEQUENCE seq_rubros RESTART with 1;
INSERT INTO rubros (id, nombre) VALUES (nextval('seq_rubros'), 'Rubro 1');
INSERT INTO rubros (id, nombre) VALUES (nextval('seq_rubros'), 'Rubro 2');