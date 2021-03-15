DROP DATABASE StoreFront;
CREATE DATABASE StoreFront;

USE StoreFront;

CREATE TABLE Admin(AID int NOT NULL AUTO_INCREMENT,
                   Name varchar(50),ContactNumber varchar(12) , Email varchar(40) UNIQUE,PRIMARY KEY(AID));
				   
CREATE TABLE Shoppers(SID int NOT NULL AUTO_INCREMENT,
                   Name varchar(50),ContactNumber varchar(12) , Email varchar(40) UNIQUE ,PRIMARY KEY(SID));
				   
CREATE TABLE ShoppersAddress (Address varchar(100),SID int , PRIMARY KEY(Address , SID),FOREIGN KEY(SID) REFERENCES Shoppers(SID)
                                                                                        ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE Categories (CID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         Title varchar(50),ParentCategory varchar(50),Description varchar(200));
						 
CREATE TABLE Products(PID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      Name varchar(50),Price double(7,2),Date DATE ,Status varchar(50),Description varchar(200));
					  
CREATE TABLE ProductImages (ImageID int NOT NULL AUTO_INCREMENT, Images BLOB ,PID int ,PRIMARY KEY(ImageID , PID));

CREATE TABLE ProductCategory (PID int , Category varchar(100) ,PRIMARY KEY(PID , Category));

CREATE TABLE Stock(ItemCode int NOT NULL AUTO_INCREMENT PRIMARY KEY , Name varchar(50) , Quantity int);

CREATE TABLE Orders(OID int NOT NULL AUTO_INCREMENT PRIMARY KEY ,Date DATE,SID int,OrderTotal double(7,2));

CREATE TABLE ShoppersOrder(OID int,PID int,PRIMARY KEY(OID , PID),Status varchar(50));

SHOW TABLES;
DROP TABLE Products;
CREATE TABLE Products(PID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      Name varchar(50),Price double(7,2),Date DATE ,Status varchar(50),Description varchar(200));
