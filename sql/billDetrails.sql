create table billDetails(
   Order_Id varchar(15) not null, 
   Customer_Name varchar(15) not null,
   Contact_Number bigint unique not null,
   Order_Date Date not null,
   Delivery_Date Date not null, 
   Bill float(10) not null, 
   GST float (5) not null,
   Final_Bill float (10) not null
);