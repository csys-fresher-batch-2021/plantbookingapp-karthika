CREATE TABLE plantList (
	Plant_Name varchar(20) UNIQUE NOT NULL,
	Cost FLOAT(5)	 NOT NULL,
	Type varchar(10)  NOT NULL,
    Category varchar(10) NOT NULL
);

INSERT INTO plantList(Plant_Name,Cost,Type,Category) 
values ('Neem Tree',60,'TREE','MEDICINAL');
