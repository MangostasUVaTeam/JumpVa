/*Creacion de las tablas de la base de datos*/
CREATE TABLE TipoEnvio(
	tipo BYTE,
	valor VARCHAR(30),
	PRIMARY KEY(tipo)
);

CREATE TABLE TipoHito(
	tipo BYTE,
	valor VARCHAR(30),
	PRIMARY KEY(tipo)
);

CREATE TABLE Usuario(
	email VARCHAR(50),
	nUsuario VARCHAR(20),
	contrasenia VARCHAR(20),
	fNac DATE,
	localizacion VARCHAR(30),
	PRIMARY KEY(email)
);

CREATE TABLE Remitente(
	email VARCHAR(50),
	PRIMARY KEY(email),
	FOREIGN KEY(email) REFERENCES Usuario(email)
);

CREATE TABLE Transportista(
	email VARCHAR(50),
	nLicencia VARCHAR(20),
	pesMax FLOAT,
	paquetes BIT,
	liquidos BIT,
	animales BIT,
	vehiculos BIT,
	PRIMARY KEY(email),
	FOREIGN KEY(email) REFERENCES Usuario(email)
);

CREATE TABLE Envio(
	nroEnvio INTEGER,
	email VARCHAR(50),
	peso INTEGER,
	tipo BYTE,
	dimensiones VARCHAR(30),
	fLlegada DATE,
	fRecogida DATE,
	destino VARCHAR(30),
	origen VARCHAR(30),
	valoracion BYTE,
	PRIMARY KEY(nroEnvio),
	FOREIGN KEY(email) REFERENCES Remitente(email),
	FOREIGN KEY(tipo) REFERENCES TipoEnvio(tipo)
);

CREATE TABLE Puja(
	email VARCHAR(50),
	nroEnvio INTEGER,
	oferta FLOAT,
	aceptado BIT,
	PRIMARY KEY(email, nroEnvio),
	FOREIGN KEY(email) REFERENCES Transportista(email),
	FOREIGN KEY(nroEnvio) REFERENCES Envio(nroEnvio)
);

CREATE TABLE Hito(
	nroEnvio INTEGER,
	nroHito INTEGER,
	mensaje VARCHAR(200),
	tipo BYTE,
	fCreacion DATE,
	PRIMARY KEY(nroEnvio, nroHito),
	FOREIGN KEY(nroEnvio) REFERENCES Envio(nroEnvio),
	FOREIGN KEY(tipo) REFERENCES TipoEnvio(tipo)
);
	
