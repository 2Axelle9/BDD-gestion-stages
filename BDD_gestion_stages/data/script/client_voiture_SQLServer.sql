


IF EXISTS (select * from sysobjects where name='VOITURE')
DROP TABLE VOITURE;
GO

IF EXISTS (select * from sysobjects where name='CLIENT')
DROP TABLE CLIENT;
GO

CREATE TABLE CLIENT ( 
    Id_cl smallint PRIMARY KEY, 
    Nom_cl varchar(100), 
    Pren_cl varchar(100), 
    Age smallint 
    );

CREATE TABLE VOITURE ( 
    N_Serie smallint, 
    Marque varchar(100), 
    Id_cl smallint REFERENCES CLIENT(Id_cl), 
    Modele varchar(100),
    CONSTRAINT cle_primaire PRIMARY KEY (N_Serie,Marque)
    );

INSERT INTO CLIENT VALUES (1,'Norris','Carlos Ray',74),
			(2,'Tureaud','Laurence',62),
			(3,'Li','Lianjie',51),
			(4,'Statham','jason',47),
			(5,'Wahlberg','Mark',43);


INSERT INTO VOITURE VALUES (1042,'Peugeot',3,'408'),
			(2068,'Renault',1,'Megane'),
			(3021,'Mercedes',2,'SLK'),
			(4104,'Lada',1,'Jigouli'),
			(1042,'Ferrari',4,'599 GTO');


