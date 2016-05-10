insert into TipoEnvio values (0, 'Paquete');
insert into TipoEnvio values (1, 'Animales');
insert into TipoEnvio values (2, 'Líquidos');
insert into TipoEnvio values (3, 'Vehículos');

insert into TipoHito values (0, 'Localización');
insert into TipoHito values (1, 'Envío completado');
insert into TipoHito values (2, 'Retraso en el envío');
insert into TipoHito values (3, 'Comentario');

insert into TipoEstado values (0, 'Completado');
insert into TipoEstado values (1, 'En progreso');
insert into TipoEstado values (2, 'No asignado o pendiente'); /* Depende de si es cliente o transportista*/

insert into Usuario values ('juancho@gmail.com', 'Juan', 'juanpssw', '1967-04-24', 'C/ Angustias 45');
insert into Usuario values ('paconejo@gmail.com', 'Paco', 'pacopssw', '1960-07-12', 'C/ Rodolfo XV 13');

insert into Remitente values ('juancho@gmail.com');
insert into Transportista values ('paconejo@gmail.com', '12345V', 543.3, 't', 't', 'f', 'f');

insert into Envio values (0, 'juancho@gmail.com', 70, 0, '20x130x40', '2016-04-20', '2016-05-10', 'Palencia', 'Valladolid', NULL, 0);
insert into Envio values (1, 'juancho@gmail.com', 70, 0, '20x130x40', '2016-04-20', '2016-05-10', 'Palencia', 'Valladolid', NULL, 1);
insert into Envio values (2, 'juancho@gmail.com', 70, 0, '20x130x40', '2016-04-20', '2016-05-10', 'Palencia', 'Valladolid', NULL, 2);
insert into Envio values (3, 'juancho@gmail.com', 70, 0, '2x260x10', '2016-04-20', '2016-05-10', 'Teruel', 'Valladolid', NULL, 2);

insert into Puja values ('paconejo@gmail.com', 2, 50, 'f');
insert into Puja values ('paconejo@gmail.com', 3, 50, 'f');
insert into Puja values ('paconejo@gmail.com', 0, 50, 't');
insert into Puja values ('paconejo@gmail.com', 1, 50, 't');

insert into Hito values (0, 0, 'Envío completado', 1, '2016-04-20');
insert into Hito values (1, 0, 'Saliendo de Zaratan', 0, '2016-04-20');
insert into Hito values (1, 1, 'De acuerdo, gracias', 3, '2016-04-20');
insert into Hito values (1, 2, 'El envío llegará el martes', 0, '2016-04-20');