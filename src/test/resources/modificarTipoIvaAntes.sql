Delete from tipo_ivas;
alter SEQUENCE seq_tipo_ivas restart with 1;
INSERT INTO tipo_ivas (id,nombre) VALUES(nextval('seq_tipo_ivas'),'Responsable Inscripto');