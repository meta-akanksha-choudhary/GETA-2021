
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
public class Test {
    public static void main(String[] arg) throws SQLException, FileNotFoundException {
   	 String host = "jdbc:mysql://localhost:3306/";
   	 String dbName = "storefront";
   	 String mysqlURL = host + dbName;
   	 String userId = "root";
   	 String password = "akku";
   	 try {
   		  Class.forName("com.mysql.cj.jdbc.Driver");  
   		  Connection con= (Connection) DriverManager.getConnection(mysqlURL,userId,password); 
   		  
   		  Statement stmt=((java.sql.Connection) con).createStatement();  
   		  ResultSet rs=stmt.executeQuery("select OID,OrderTotal,Date from Orders where SID=1 and Status ='Shipped' order by Date;");
   		  System.out.println("OID\tOrderTotal\tDate");
   		  while(rs.next())  
   		        System.out.println(rs.getInt(1)+"\t"+rs.getDouble(2)+"\t\t"+rs.getDate(3));  
   		  
          String sql = "Delete from Products where PID NOT IN(select PID from ShoppersOrder where DATEDIFF(curdate(),date)<=365)";
          int result1=stmt.executeUpdate(sql);
          System.out.println("The number of rows deleted: "+ result1);
          
          InputStream in=new FileInputStream("C:\\Users\\akanksha.choudhary_m\\Downloads\\CSS Assignment\\images\\images\\logo.png");
          String sqlQuery = "insert into ProductImages (Images,PID) values (?,?)";
          PreparedStatement psmt = ((java.sql.Connection) con).prepareStatement(sqlQuery);
          for(int i=1; i<= 5;i++){
                psmt.setBlob(1,in);
                psmt.setInt(2,i);
                psmt.addBatch();
               }
            int[] result = psmt.executeBatch();
            System.out.println("The number of rows inserted: "+ result.length);
            
            ResultSet rst=stmt.executeQuery("select t1.Title,count(t2.Title) from Categories t1 INNER JOIN Categories t2 ON t1.Title=t2.ParentCategory where t1.ParentCategory='Top Category' group by (t2.ParentCategory);"); 
            System.out.println("Title \t    Child Category");
       		while(rst.next())  
       		System.out.println(rst.getString(1)+"\t"+rst.getInt(2));
       		
   	 } catch (ClassNotFoundException cnfe) {
   		 System.out.println("Error loading driver: " + cnfe);
   	 }
    }
}

