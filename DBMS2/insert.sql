INSERT INTO Admin (Name,ContactNumber,Email) VALUES ('Abhishek','9999244567','abh@gmail.com');

INSERT INTO Shoppers (Name,ContactNumber,Email) VALUES ('Abhi','9999244567','abh@gmail.com');
INSERT INTO Shoppers (Name,ContactNumber,Email) VALUES ('Avi','9999244567','avi@gmail.com');
INSERT INTO Shoppers (Name,ContactNumber,Email) VALUES ('Adi','9999244567','adi@gmail.com');
INSERT INTO Shoppers (Name,ContactNumber,Email) VALUES ('Arun','9999244567','arun@gmail.com');
INSERT INTO Shoppers (Name,ContactNumber,Email) VALUES ('Veena','9999244567','veena@gmail.com');
INSERT INTO Shoppers (Name,ContactNumber,Email) VALUES ('Vamika','9999244567','vam@gmail.com');

INSERT INTO ShoppersAddress(Address,SID) VALUES ('Jaipur',1);
INSERT INTO ShoppersAddress(Address,SID) VALUES ('Ajmer',1);
INSERT INTO ShoppersAddress(Address,SID) VALUES ('Kota',2);
INSERT INTO ShoppersAddress(Address,SID) VALUES ('Kanpur',2);
INSERT INTO ShoppersAddress(Address,SID) VALUES ('Udaipur',3);

INSERT INTO Categories(Title,ParentCategory,Description) VALUES ('Furniture','Top Category','Abcd');
INSERT INTO Categories(Title,ParentCategory,Description) VALUES ('Sofa','Furniture','Abcd');
INSERT INTO Categories(Title,ParentCategory,Description) VALUES ('Cream','Cosmetic','Abcd');
INSERT INTO Categories(Title,ParentCategory,Description) VALUES ('Cosmetic','Top Category','Abcd');
INSERT INTO Categories(Title,ParentCategory,Description) VALUES ('Bakery','Top Category','Abcd');
INSERT INTO Categories(Title,ParentCategory,Description) VALUES ('Pastry','Bakery','Abcd');
INSERT INTO Categories(Title,ParentCategory,Description) VALUES ('Clothes','Top Category','Abcd');


INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Chair',45,NOW(),'Active','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Table',4700,NOW(),'Blocked','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Icecream',400,NOW(),'Active','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Chocolate',400,NOW(),'Active','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Brush',450,NOW(),'Active','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Muffin',30,NOW(),'Blocked','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Shirt',4500,NOW(),'Active','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Top',600,NOW(),'Active','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Jeans',5000,NOW(),'Blocked','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Biscuits',5000,'2021-03-14','Blocked','Abcd');
INSERT INTO Products (Name,Price ,Date,Status,Description) VALUES ('Cakes',5000,'2021-03-14','Active','Abcd');


INSERT INTO ProductImages (PID) VALUES (1);
INSERT INTO ProductImages (PID) VALUES (3);
INSERT INTO ProductImages (PID) VALUES (5);
INSERT INTO ProductImages (PID) VALUES (2);

INSERT INTO ProductCategory(PID , Category) VALUES (1,'Furniture');
INSERT INTO ProductCategory(PID , Category) VALUES (2,'Furniture');
INSERT INTO ProductCategory(PID , Category) VALUES (2,'Sofa');
INSERT INTO ProductCategory(PID , Category) VALUES (3,'Bakery');
INSERT INTO ProductCategory(PID , Category) VALUES (4,'Bakery');
INSERT INTO ProductCategory(PID , Category) VALUES (5,'Cosmetic');
INSERT INTO ProductCategory(PID , Category) VALUES (6,'Bakery');
INSERT INTO ProductCategory(PID , Category) VALUES (7,'Clothes');
INSERT INTO ProductCategory(PID , Category) VALUES (8,'Clothes');
INSERT INTO ProductCategory(PID , Category) VALUES (9,'Clothes');
INSERT INTO ProductCategory(PID , Category) VALUES (10,'Bakery');
INSERT INTO ProductCategory(PID , Category) VALUES (11,'Bakery');

INSERT INTO Stock(Name,Quantity) VALUES ('Chair',10);
INSERT INTO Stock(Name,Quantity) VALUES ('Icecream',20);
INSERT INTO Stock(Name,Quantity) VALUES ('Chocolate',30);
INSERT INTO Stock(Name,Quantity) VALUES ('Brush',15);
INSERT INTO Stock(Name,Quantity) VALUES ('Shirt',25);
INSERT INTO Stock(Name,Quantity) VALUES ('Top',35);

INSERT INTO Orders(Date,SID,OrderTotal) VALUES ('2021-02-5',4,2500);
INSERT INTO Orders(Date,SID,OrderTotal) VALUES (NOW(),2,25000);
INSERT INTO Orders(Date,SID,OrderTotal) VALUES (NOW(),1,3500);
INSERT INTO Orders(Date,SID,OrderTotal) VALUES (NOW(),3,40000);
INSERT INTO Orders(Date,SID,OrderTotal) VALUES (NOW(),1,10000);

INSERT INTO ShoppersOrder(OID,PID,Status) VALUES (1,1,'Shipped');
INSERT INTO ShoppersOrder(OID,PID,Status) VALUES (1,3,'Not Shipped');
INSERT INTO ShoppersOrder(OID,PID,Status) VALUES (1,5,'Shipped');
INSERT INTO ShoppersOrder(OID,PID,Status) VALUES (2,2,'Shipped');
INSERT INTO ShoppersOrder(OID,PID,Status) VALUES (3,6,'Not Shipped');
INSERT INTO ShoppersOrder(OID,PID,Status) VALUES (2,3,'Shipped');