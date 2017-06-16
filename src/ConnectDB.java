import java.sql.*;
import java.util.Properties;

public class ConnectDB {
	
	private static final String dbClassName = "org.mariadb.jdbc.Driver";
    private static final String url = "jdbc:mariadb://140.127.74.226:3306/410477010";
    private static final String username = "410477010";
    private static final String password = "4t78n";
    private static Connection connection;
    static Statement smt;
    static ResultSet rs;
    
    public ConnectDB(){ }
    
    public void connectDatabase() throws Exception{
    	connection = DriverManager.getConnection(url, username, password);
        System.out.println("已連接!");
    }
    
    
    public static void main(String [] args) throws ClassNotFoundException,SQLException{
      
        /*Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("已連接!");
        
        Statement smt =connection.createStatement();
        ResultSet rs =smt.executeQuery("SELECT * FROM actor");
        while(rs.next()){
              String s = "Name=" + rs.getString("actName") + ",Birth=" + rs.getString("actBirth");
              System.out.println(s);
        }
        connection.close();*/
    }
}
