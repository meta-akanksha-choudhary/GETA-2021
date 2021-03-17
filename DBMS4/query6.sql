Drop FUNCTION getMonths;
DELIMITER //
CREATE FUNCTION getMonths(date1 DATE) RETURNS int DETERMINISTIC
BEGIN
return (select Month(Date) from Orders where year(Date)=year(date1) group by Date order by count(OID) desc limit 1);	
END;//

select getMonths(CURDATE());
