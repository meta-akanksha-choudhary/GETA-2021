select t1.PID , t1.Name, count(t2.PID) from Products t1 INNER JOIN ProductCategory t2 ON t1.PID=t2.PID GROUP BY t2.PID HAVING count(t2.PID)>1;

select count(PID) as total from Products where Price BETWEEN 0 and 100;
select count(PID) as total from Products where Price BETWEEN 100 and 500;
select count(PID) as total from Products where Price>500;

select t1.Title , count(t2.Category) from Categories t1 INNER JOIN ProductCategory t2 ON t1.Title=t2.Category GROUP BY t2.Category;



select t1.SID,t1.Name,t1.ContactNumber , count(t2.SID) from Shoppers t1 INNER JOIN Orders t2 ON t1.SID=t2.SID where DATEDIFF(CURDATE(),t2.Date)<=30 GROUP BY t2.SID ;

select t1.Name from Shoppers t1 INNER JOIN Orders t2 ON t1.SID=t2.SID where CURDATE()-t2.Date<=30 GROUP BY t2.SID order by count(t2.OrderTotal) desc limit 10;

select t1.Name from Products t1 INNER JOIN ShoppersOrder t2 ON t1.PID=t2.PID 
                                INNER JOIN Orders t3 ON t2.OID=t3.OID where DATEDIFF(CURDATE(),t3.Date)<=60 GROUP BY t2.PID order by count(t2.PID) desc limit 20;
								
select MONTH(Date) as ForMonth ,sum(OrderTotal) from Orders where MONTH(CURDATE())-MONTH(Date)<=6 GROUP BY MONTH(Date);

update Products t1 set t1.Status='Inactive' where t1.Status='Active' and t1.PID NOT IN (Select t2.PID from ShoppersOrder t2
                                           INNER JOIN Orders t3 ON t2.OID=t3.OID where DATEDIFF(CURDATE(),t3.Date)<=90);

select t1.Name from Products t1 INNER JOIN ProductCategory t2 ON t1.PID=t2.PID where t2.Category='Clothes';
								
select t1.name from Products t1 INNER JOIN ShoppersOrder t2 ON t1.PID=t2.PID where t2.Status='Cancelled' GROUP BY t2.PID order by count(t2.PID) desc limit 10;


CREATE VIEW OrderD AS
select t1.OID,t4.Name as Title,t1.OrderTotal ,t2.Name,t2.Email,t1.Date,t3.Status from Orders t1 
                                  INNER JOIN Shoppers t2 ON t1.SID=t2.SID 
                                  INNER JOIN ShoppersOrder t3 ON t1.OID=t3.OID 
								  INNER JOIN Products t4 ON t4.PID=t3.PID where DATEDIFF(CURDATE(),t1.Date)<=60;
								  
select Title from OrderD where Status='Shipped';
								  
select Title from OrderD GROUP BY Title order by count(Title) desc limit 5;			  