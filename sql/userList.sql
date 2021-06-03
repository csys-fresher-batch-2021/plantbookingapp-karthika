create table userlist (
	User_Id varchar(30) PRIMARY KEY NOT NULL,
	User_Name varchar(20) NOT NULL,
	Contact_Number varchar(10) UNIQUE NOT NULL,
    Password varchar(8) NOT NULL
);