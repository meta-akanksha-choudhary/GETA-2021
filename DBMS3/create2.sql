DROP DATABASE Zip;
CREATE DATABASE Zip;

USE Zip;

CREATE TABLE StateDetails(ID int NOT NULL AUTO_INCREMENT, City varchar(50),StateD varchar(50),PRIMARY KEY(ID));
CREATE TABLE ZipDetails(ZipCode int NOT NULL, City varchar(50),PRIMARY KEY(ZipCode,City));

INSERT INTO StateDetails(City,Stated) VALUES ('Jaipur','Rajasthan');
INSERT INTO StateDetails(City,Stated) VALUES ('Ajmer','Rajasthan');
INSERT INTO StateDetails(City,Stated) VALUES ('Kota','Rajasthan');
INSERT INTO StateDetails(City,Stated) VALUES ('Mumbai','Maharashtra');
INSERT INTO StateDetails(City,Stated) VALUES ('Nashik','Maharashtra');
INSERT INTO StateDetails(City,Stated) VALUES ('Lucknow','Uttar Pradesh');
INSERT INTO StateDetails(City,Stated) VALUES ('Banaras','Uttar Pradesh');
INSERT INTO StateDetails(City,Stated) VALUES ('Udaipur','Rajasthan');


INSERT INTO ZipDetails VALUES (302012,'Jaipur');
INSERT INTO ZipDetails VALUES (302013,'Ajmer');
INSERT INTO ZipDetails VALUES (302014,'Kota');
INSERT INTO ZipDetails VALUES (302015,'Mumbai');
INSERT INTO ZipDetails VALUES (302016,'Nashik');
INSERT INTO ZipDetails VALUES (302017,'Lucknow');
INSERT INTO ZipDetails VALUES (302018,'Banaras');
INSERT INTO ZipDetails VALUES (302019,'Udaipur');

select t1.ZipCode , t2.City,t2.StateD from ZipDetails t1 INNER JOIN StateDetails t2 ON t1.City=t2.City order by t2.StateD,t2.City;