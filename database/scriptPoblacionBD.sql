insert into TipoEnvio values (0, 'Paquete');
insert into TipoEnvio values (1, 'Animales');
insert into TipoEnvio values (2, 'Líquidos');
insert into TipoEnvio values (3, 'Vehículos');


insert into TipoHito values (0, 'Localización');
insert into TipoHito values (1, 'Envío completado');
insert into TipoHito values (2, 'Retraso en el envío');

insert into TipoEstado values (0, 'Completado');
insert into TipoEstado values (1, 'En progreso');
insert into TipoEstado values (2, 'No asignado');

insert into Usuario values ('juancho@gmail.com', 'Juan', 'juanpssw', 1967-04-24, 'C/ Angustias 45');
insert into Usuario values ('paconejo@gmail.com', 'Paco', 'pacopssw', 1960-07-12, 'C/ Rodolfo XV 13');

insert into Remitente values ('juancho@gmail.com');
insert into Transportista values ('paconejo@gmail.com', '12345V', 543.3, 1, 1, 0, 0);

insert into Envio values (0, 'juancho@gmail.com', 70, 0, '20x130x40', 2016-04-20, 2016-05-10, 'Palencia', 'Valladolid', NULL, 0);
insert into Envio values (1, 'juancho@gmail.com', 70, 0, '20x130x40', 2016-04-20, 2016-05-10, 'Palencia', 'Valladolid', NULL, 1);
insert into Envio values (2, 'juancho@gmail.com', 70, 0, '20x130x40', 2016-04-20, 2016-05-10, 'Palencia', 'Valladolid', NULL, 2);
insert into Envio values (3, 'juancho@gmail.com', 70, 0, '20x130x40', 2016-04-20, 2016-05-10, 'Palencia', 'Valladolid', NULL, 2);
insert into Envio values (4, 'juancho@gmail.com', 70, 0, '20x130x40', 2016-04-20, 2016-05-10, 'Palencia', 'Valladolid', NULL, 2);