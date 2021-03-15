select t1.PID , t1.Name,t2.Category,t1.Price from Products t1 INNER JOIN ProductCategory t2 ON t1.PID=t2.PID where t1.Status='Active' order by t1.Date desc;

select t1.Name from Products t1 INNER JOIN ProductImages t2 ON t1.PID=t2.PID and t2.Images IS NULL;
  
select CID,Title,ParentCategory from Categories order by ParentCategory,Title;

select t1.CID , t1.Title ,t1.ParentCategory from Categories t1 where t1.Title NOT IN (select t2.ParentCategory from Categories t2);

select t1.Name ,t1.Price,t1.Description from Products t1 INNER JOIN ProductCategory t2 ON t1.PID=t2.PID and t2.Category='Bakery';

select Name from Stock where Quantity<=50;



select OID,Date,OrderTotal from Orders order by Date desc LIMIT 50;

select OID ,OrderTotal from Orders order by OrderTotal desc LIMIT 10;

select t1.OID , t1.Date,t1.OrderTotal from Orders t1 INNER JOIN ShoppersOrder t2 ON t1.OID=t2.OID and t2.Status='Not Shipped' and CURDATE()-t1.Date>=10;

select t1.Name , t2.OID , t2.Date from Shoppers t1 INNER JOIN Orders t2 ON t1.SID=t2.SID  where t1.SID NOT IN
                                  (select t3.SID from Shoppers t3 INNER JOIN Orders t4 ON t3.SID=t4.SID and CURDATE()-t4.Date<=31);

select t1.Name , t2.OID , t2.Date from Shoppers t1 INNER JOIN Orders t2 ON t1.SID=t2.SID and CURDATE()-t2.Date<=15;

select t1.Name from Products t1 INNER JOIN ShoppersOrder t2 ON t1.PID=t2.PID and t2.Status='Shipped' and t2.OID=1
                                INNER JOIN Orders t3 ON t2.OID=t3.OID ;
								
select t1.Name,t1.Price ,t3.Date from Products t1 INNER JOIN ShoppersOrder t2 ON t1.PID=t2.PID and t1.Price >=20 and t1.Price<=50
                                               INNER JOIN Orders t3 ON t2.OID=t3.OID;
											   
										 