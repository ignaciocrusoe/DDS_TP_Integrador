select * from entidades;
select * from personas;
select * from incidentes;
select * from establecimientos;

select * from prestadores;
select * from organismos_control;

insert into organismos_control (mail_organismo_control, nombre_organismo_control) values
('secretaria@cas.com.ar', 'Cámara Argentina de Supermercados (CAS)'),
('atencionalciudadano@cnrt.gob.ar', 'Comisión Nacional de Regulación del Transporte (CNRT)');

insert into prestadores (mail_prestador, nombre_prestador) values
('info@coto.com.ar', 'COTO'),
('informacionpublica@trenesargentinos.gob.ar', 'Trenes Argentinos');

insert into entidades (id, nombre, organismo_control, prestador) values
(1,'COTO', 4, 1),
(2, 'Trenes Argentinos', 5, 2);

-- agregar localizaciones (municipio, departamento y provincia), establecimientos, personas, comunidades e incidentes

