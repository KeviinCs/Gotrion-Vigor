create database gotrionvigor_db;

use gotrionvigor_db;
create table usuario(
    id int primary key auto_increment,
    nombre varchar (50),
    edad int,
    correo varchar (50),
    tipousuario varchar (50)
);

create table dieta (
    id int primary key AUTO_INCREMENT,
    nombre varchar(50),
    descripcion text,
    tipousuario varchar(50)
);

create table receta (
    id int primary key AUTO_INCREMENT,
    nombre varchar(50),
    ingredientes TEXT,
    instrucciones TEXT
);