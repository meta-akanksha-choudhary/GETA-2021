Drop FUNCTION getOrders;
DELIMITER //
CREATE FUNCTION getOrders(date1 DATE) RETURNS int DETERMINISTIC
BEGIN
return (select count(OID) from Orders where month(Date)=month(date1) and year(Date)=year(date1) group by Date);	

END;//

select getOrders(CURDATE());
