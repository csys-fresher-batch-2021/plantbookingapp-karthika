CREATE TABLE adminlist (
	Admin_Name varchar(20) NOT NULL,
	Contact_Number varchar(10) UNIQUE NOT NULL,
    Password varchar(8) NOT NULL
);

INSERT INTO adminlist(Admin_Name,Contact_Number,Password) 
values ('Karthika','9080246689','kart1727');
INSERT INTO adminlist(Admin_Name,Contact_Number,Password) 
values ('Aruna','9443145867','aruna123');
