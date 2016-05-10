insert into TipoEnvio values (0, 'Paquete');
insert into TipoEnvio values (1, 'Animales');
insert into TipoEnvio values (2, 'Líquidos');
insert into TipoEnvio values (3, 'Vehículos');


insert into TipoHito values (0, 'Localización');
insert into TipoHito values (1, 'Envío completado');
insert into TipoHito values (2, 'Retraso en el envío');

insert into Usuario values ('juancho@gmail.com', 'Juan', 'juanpssw', 1967-04-24, 'C/ Angustias 45');
insert into Usuario values ('paconejo@gmail.com', 'Paco', 'pacopssw', 1960-07-12, 'C/ Rodolfo XV 13');

insert into Remitente values ('juancho@gmail.com');
insert into Transportista values ('paconejo@gmail.com', '12345V', 543.3, 1, 1, 0, 0);
