Drop PROCEDURE getOrderDetails;
delimiter //
CREATE PROCEDURE getOrderDetails(date1 Date,date2 Date)
BEGIN
  if(date2<date1)
  then
  set date1=date_format(date1,'%Y-%m-01');
  end if;
  select OID,Status from Orders where date between date1 and date2;
 
END;//

CALL getOrderDetails('2021-02-05','2021-03-16');//