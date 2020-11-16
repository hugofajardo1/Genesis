Delete from tipo_fichas;
alter SEQUENCE seq_tipo_fichas restart with 1;
INSERT INTO tipo_fichas (id,nombre) VALUES(nextval('seq_tipo_fichas'),'Cliente');