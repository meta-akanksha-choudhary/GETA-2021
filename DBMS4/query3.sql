DROP PROCEDURE averageSale;
delimiter //
CREATE PROCEDURE averageSale(date1 Date)
BEGIN
  select avg(t1.OrderTotal),t2.PID from Orders t1 INNER JOIN ShoppersOrder t2 ON t1.OID=t2.OID where month(Date)=month(date1) and year(Date)=year(date1) Group by t2.PID ;
END;//

CALL averageSale(curdate());//