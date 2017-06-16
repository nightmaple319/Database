import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Features {
	private static final String dbClassName = "org.mariadb.jdbc.Driver";
    private static final String url = "jdbc:mariadb://140.127.74.226:3306/410477010";
    private static final String username = "410477010";
    private static final String password = "4t78n";
	static Connection connection;
    static Statement smt;
    static ResultSet rs;
    
	public static void main(String [] args) throws Exception{
		connectDatabase();
		Scanner sc = new Scanner(System.in);
		int exit = 1;
		while(exit!=0){
			System.out.println("請輸入功能代碼： 1.查詢電影   2.查詢演員   3.離開");
			String funcCode = sc.nextLine();
			if(funcCode.equals("1")){
				searchMovie();
			}
			if(funcCode.equals("2")){
				searchActor();
			}
			if(funcCode.equals("3")){
				exit = 0;
				connection.close();
			}

		}
	}
	
	public static void connectDatabase() throws Exception{
    	connection = DriverManager.getConnection(url, username, password);
    	smt =connection.createStatement();
        System.out.println("已連接!");
    }
	
	private static void searchMovie() throws Exception{
        ResultSet rs =smt.executeQuery("SELECT * FROM movie");
        while(rs.next()){
              String s = "電影名稱：" + rs.getString("movieName") + ",類型：" + rs.getString("category") +",上映時間："+rs.getString("debut");
              System.out.println(s);
        }
	}
	
	private static void searchActor() throws Exception{
        ResultSet rs =smt.executeQuery("SELECT * FROM actor");
        while(rs.next()){
              String s = "演員名稱：" + rs.getString("actName") + ",演員生日：" + rs.getString("actBirth");
              System.out.println(s);
        }
	}
}
