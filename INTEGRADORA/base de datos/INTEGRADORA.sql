create database Integradora;
USE Integradora;

CREATE TABLE USUARIOS(
id int not null auto_increment primary key,
nombre varchar(150),
correo varchar(150),
usuario varchar(150),
contrasenia char(12)
);

Insert into Usuarios (nombre,correo,usuario,contrasenia) 
values ("Imelda","jdelatorre@utma.edu.mx","imelda","12345");

select * from usuarios;

select usuario,contrasenia from usuarios where usuario="Imelda" and contrasenia="98765";
