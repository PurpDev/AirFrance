drop database if exists airfrance_p141; 
create database airfrance_p141; 
use airfrance_p141; 

create table pilote ( 
	idpilote int(3) not null auto_increment, 
	nom varchar(100) not null, 
	prenom varchar(100) not null,
	email varchar(100) not null,
	bip varchar(20) not null,
	primary key(idpilote)
); 

create table avion ( 
	idavion int(3) not null auto_increment, 
	designation varchar(100) not null, 
	constructeur varchar(100) not null,
	nbplaces int(5),
	primary key(idavion)
); 

create table vol ( 
	idvol int(3) not null auto_increment, 
	designation varchar(100) not null, 
	datevol date,
	heurevol time,
	idpilote1 int(3) not null, 
	idpilote2 int(3) not null, 
	idavion int(3) not null, 
	primary key(idvol),
	foreign key (idpilote1) references pilote (idpilote), 
	foreign key (idpilote2) references pilote (idpilote),
	foreign key (idavion) references avion (idavion)
); 

# view : pilote (nom, prenom), avion (designation), vol (designation, date)

create view tb as (
	select p.nom, p.prenom, a.designation as avion, 
	v.designation as vol, 
	v.datevol as date 
	from pilote p, avion a, vol v 
	where a.idavion = v.idavion
	and p.idpilote = v.idpilote1
);


create table user (
	iduser int (3) not null auto_increment, 
	nom varchar(50), 
	prenom varchar(50), 
	email varchar(100), 
	mdp varchar(255), 
	role enum("admin", "user"), 
	primary key (iduser)
);

 
create view pav as (select p.nom,p.prenom,a.designation as avion, v.designation as vol, v.datevol,.v.heurevol
    from pilote p, avion a, vol v
    where p.idpilote=v.idpilote1
    and a.idavion = v.idavion
);
 

insert into user values (null, "Thomas", "Naoki", 
"a@gmail.com", "123", "admin"), 
(null, "Mustapha", "Gabriel", "b@gmail.com", 
"456", "user"); 








