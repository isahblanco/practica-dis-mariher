--Derby does not support DROP TABLE IF EXISTS 
DROP TABLE DISPONIBILIDAD;
DROP TABLE VINCULACIONCONLAEMPRESA;
DROP TABLE ROLESENEMPRESA;
DROP TABLE TIPODEDISPONIBILIDAD;
DROP TABLE TIPODEVINCULACION;
DROP TABLE TIPODEROL;
DROP TABLE COMPONENTE;
DROP TABLE PC;
DROP TABLE PEDIDOPC;
DROP TABLE COMPONENTESENCONFIGURACION;
DROP TABLE CONFIGURACIONPC;
DROP TABLE CPU; 
DROP TABLE PEDIDOCOMPONENTES;
DROP TABLE ESTADOCOMPRACOMPONENTES;
DROP TABLE DESCRIPCIONCOMPONENTE;
DROP TABLE TIPOCOMPONENTE;
DROP TABLE ESTADOVENTAPCS;
DROP TABLE ESPACIOALMACENAMIENTO;
DROP TABLE EMPRESA;
DROP TABLE EMPLEADO;
DROP TABLE USUARIO;

-- Enum
create table TIPODEROL
(
	IdTipo SMALLINT not null,
	NombreTipo VARCHAR(20) not null unique,
		PRIMARY KEY(IdTipo)
);

INSERT INTO TIPODEROL
VALUES  (1,'PersonalAlmacen'),
        (2,'GerenteVentas'),
        (3,'TecnicoDelTaller');

-- Enum
create table TIPODEVINCULACION
(
	IdTipo SMALLINT not null,
	NombreTipo VARCHAR(20) not null unique,
		PRIMARY KEY(IdTipo)

);

INSERT INTO TIPODEVINCULACION
VALUES  (1,'Contratado'),
        (2,'Despedido'),
        (3,'EnERTE');

-- Enum
create table TIPODEDISPONIBILIDAD
(
	IdTipo SMALLINT not null,
	NombreTipo VARCHAR(20) not null unique,
		PRIMARY KEY(IdTipo)
);

INSERT INTO TIPODEDISPONIBILIDAD
VALUES  (1,'Vacaciones'),
        (2,'BajaTemporal'),
		(3, 'Trabajando');


create table USUARIO
(
	NifCif VARCHAR(9) not null primary key,
	Nombre VARCHAR(30) not null,
	DireccionPostal VARCHAR(50),
	DireccionElectronica VARCHAR(50),
	Telefono VARCHAR(20)
);

create table EMPRESA
(
	Cif VARCHAR(9) not null primary key,
	EsCliente BOOLEAN,
	EsProveedor BOOLEAN,
            FOREIGN KEY(Cif) REFERENCES USUARIO(NifCif)
);

create table EMPLEADO
(
	Nif VARCHAR(9) not null primary key,
	Password VARCHAR(20) not null,
	FechaInicio DATE not null,
            FOREIGN KEY(Nif) REFERENCES USUARIO(NifCif)
);

-- Association
create table ROLESENEMPRESA
(
	ComienzoEnRol DATE not null,
	Empleado VARCHAR(9) not null,
	Rol SMALLINT not null,
            FOREIGN KEY(Empleado) REFERENCES EMPLEADO(Nif),
            FOREIGN KEY(Rol) REFERENCES TIPODEROL(IdTipo)
);

-- Association
create table VINCULACIONCONLAEMPRESA
(
	inicio DATE not null,
	Empleado VARCHAR(9) not null,
	Vinculo SMALLINT not null,
		FOREIGN KEY(Empleado) REFERENCES EMPLEADO(Nif),
		FOREIGN KEY(Vinculo) REFERENCES TIPODEVINCULACION(IdTipo) 
);

-- Association
create table DISPONIBILIDADEMPLEADO
(
	Comienzo DATE not null,
	FinalPrevisto DATE,
	Empleado VARCHAR(9) not null,
	Disponibilidad SMALLINT not null,
		FOREIGN KEY(Empleado) REFERENCES EMPLEADO(Nif),
		FOREIGN KEY(Disponibilidad) REFERENCES TIPODEDISPONIBILIDAD(IdTipo)
);

create table ESPACIOALMACENAMIENTO
(
	IdUbicacion INTEGER not null primary key,
	Seccion SMALLINT,
	Zona SMALLINT not null,
	Estanteria SMALLINT,
	Ocupado BOOLEAN
);

-- Enum
create table CPU 
(
	IdTipoCPU SMALLINT not null primary key,
	NombreTipoCPU VARCHAR(20) not null
);

INSERT INTO CPU
VALUES  (1,'AMD'),
        (2,'IntelCore');


create table CONFIGURACIONPC
(
	IdConfiguracion INTEGER not null primary key,
	TipoCPU SMALLINT not null,
	VelocidadCPU REAL not null,
	CapacidadRAM INTEGER not null,
	CapacidadDD INTEGER not null,
	VelocidadTarjetaGrafica REAL,
	MemoriaTarjetaGrafica INTEGER,
            FOREIGN KEY(TipoCPU) REFERENCES CPU(IdTipoCPU)
);

--Enum
create table TIPOCOMPONENTE
(
	IdTipoComponente SMALLINT not null primary key,
	NombreTipoComponente VARCHAR(20) not null
);

INSERT INTO TIPOCOMPONENTE
VALUES  (1,'TarjetaGrafica'),
        (2,'DiscoDuro'),
        (3,'PlacaBase'),
        (4,'Caja'),
        (5,'Procesador'),
        (6,'RAM');

create table DESCRIPCIONCOMPONENTE
(
	IdDescripcion INTEGER not null primary key,
	Tipo SMALLINT not null,
	Marca VARCHAR(20) not null,
	Modelo VARCHAR(20),
	Precio REAL,
	CaracteristicasTecnicas VARCHAR(250),
            FOREIGN KEY(Tipo) REFERENCES TIPOCOMPONENTE(IdTipoComponente)
);

-- Association
create table COMPONENTESENCONFIGURACION
(
	IdDescripcion INTEGER not null,
	IdConfiguracion INTEGER not null,
            FOREIGN KEY(IdConfiguracion) REFERENCES CONFIGURACIONPC(IdConfiguracion),
            FOREIGN KEY(IdDescripcion) REFERENCES DESCRIPCIONCOMPONENTE(IdDescripcion)
);

-- Enum
create table ESTADOVENTAPCS
(
	IdEstadoVenta SMALLINT not null primary key,
	NombreEstadoVenta VARCHAR(20) not null
);

INSERT INTO ESTADOVENTAPCs
VALUES  (1,'Solicitado'),
        (2,'EnProceso'),
        (3,'Completado'),
        (4,'Enviado'),
        (5,'Entregado');

create table PEDIDOPC
(
	IdPedido INTEGER not null primary key,
	CantidadSolicitada SMALLINT not null,
	FechaPedido DATE not null,
    	Estado SMALLINT not null,
	ConfiguracionSolicitada INTEGER not null,
	EncargadoPor VARCHAR(9) not null,
            FOREIGN KEY(ConfiguracionSolicitada) REFERENCES CONFIGURACIONPC(IdConfiguracion),
            FOREIGN KEY(EncargadoPor) REFERENCES EMPRESA(Cif),
            FOREIGN KEY(Estado) REFERENCES ESTADOVENTAPCS(IdEstadoVenta)
);

-- Enum
create table ESTADOCOMPRACOMPONENTES
(
	IdEstadoCompra SMALLINT not null primary key,
	NombreEstadoCompra VARCHAR(20) not null
);

INSERT INTO ESTADOCOMPRACOMPONENTES
VALUES  (1,'Encargada'),
        (2,'Enviada'),
        (3,'Recibida');

create table PEDIDOCOMPONENTES
(
	IdPedido INTEGER not null primary key,
	ComponentePedido INTEGER not null,
	CantidadPedida SMALLINT,
	FechaPedido DATE not null,
	FechaOfertaEntrega DATE,
	Estado SMALLINT not null,
	SolicitadoA VARCHAR(9) not null,
        FOREIGN KEY(SolicitadoA) REFERENCES EMPRESA(Cif),
	    FOREIGN KEY(ComponentePedido) REFERENCES DESCRIPCIONCOMPONENTE(IdDescripcion),
	    FOREIGN KEY(Estado) REFERENCES ESTADOCOMPRACOMPONENTES(IdEstadoCompra)
);

create table PC
(
	IdEtiqueta INTEGER not null primary key,
	Reservado BOOLEAN,
	FechaMontaje DATE not null,
	IdConfiguracion INTEGER not null,
	MontadoPor VARCHAR(9) not null,
	IdPedido INTEGER,
	Ubicacion INTEGER,
            FOREIGN KEY(IdConfiguracion) REFERENCES CONFIGURACIONPC(IdConfiguracion),
            FOREIGN KEY(MontadoPor) REFERENCES EMPLEADO(Nif),
            FOREIGN KEY(Ubicacion) REFERENCES ESPACIOALMACENAMIENTO(IdUbicacion),
	    	FOREIGN KEY(IdPedido) REFERENCES PEDIDOPC(IdPedido)
);

create table COMPONENTE
(
	IdEtiqueta INTEGER not null primary key,
	FechaEntrada DATE not null,
	Reservado BOOLEAN,
	IdDescripcion INTEGER not null,
	EtiquetaPC INTEGER,
	RecibidoEnCompra INTEGER not null,
	Ubicacion INTEGER,
            FOREIGN KEY(Ubicacion) REFERENCES ESPACIOALMACENAMIENTO(IdUbicacion),
            FOREIGN KEY(EtiquetaPC) REFERENCES PC(IdEtiqueta),
            FOREIGN KEY(RecibidoEnCompra) REFERENCES PEDIDOCOMPONENTES(IdPedido),
            FOREIGN KEY(IdDescripcion) REFERENCES DESCRIPCIONCOMPONENTE(IdDescripcion)
);


