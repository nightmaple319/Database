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
    static Scanner sc;
    
	public static void main(String [] args) throws Exception{
		connectDatabase();
		sc = new Scanner(System.in);
		int exit = 1;
		while(exit!=0){
			System.out.println("請輸入功能代碼： 1.查詢電影   2.查詢演員   3.新增   4.離開");
			String funcCode = sc.nextLine();
			if(funcCode.equals("1")){
				searchMovie();
			}
			if(funcCode.equals("2")){
				searchActor();
			}
			if(funcCode.equals("3")){
				addAll();
			}
			if(funcCode.equals("4")){
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
		System.out.println("若要列出所有電影請按1，若要由演員來查詢電影請按2，若要由導演來查詢電影請按3，若要由年份來查詢電影請按4");
		String sCode = sc.nextLine();
		if(sCode.equals("1")){
			ResultSet rs =smt.executeQuery("SELECT * FROM movie");
	        while(rs.next()){
	              String s = "電影名稱：" + rs.getString("movieName") + ",  類型：" + rs.getString("category") +",  上映時間："+rs.getString("debut");
	              System.out.println(s);
	        }
		}
		else if(sCode.equals("2")){
			System.out.println("請輸入演員名稱");
			String actName = sc.nextLine();
			ResultSet rs =smt.executeQuery("SELECT * FROM actor Natural join perform Natural join movie where actName='"+actName+"'");
	        while(rs.next()){
	              String s = "電影名稱：" + rs.getString("movieName") + ",類型：" + rs.getString("category") +",上映時間："+rs.getString("debut");
	              System.out.println(s);
	        }
		}
		
		else if(sCode.equals("3")){
			System.out.println("請輸入導演名稱");
			String dirName = sc.nextLine();
			ResultSet rs =smt.executeQuery("SELECT * FROM director Natural join movie where dirName='"+dirName+"'");
	        while(rs.next()){
	              String s = "電影名稱：" + rs.getString("movieName") + ",類型：" + rs.getString("category") +",上映時間："+rs.getString("debut");
	              System.out.println(s);
	        }
		}
		else if(sCode.equals("4")){
			System.out.println("請輸入年份");
			String year = sc.nextLine();
			ResultSet rs =smt.executeQuery("SELECT * FROM movie where debut='"+year+"'");
	        while(rs.next()){
	              String s = "電影名稱：" + rs.getString("movieName") + ",類型：" + rs.getString("category") +",上映時間："+rs.getString("debut");
	              System.out.println(s);
	        }
		}
	}
	
	private static void searchActor() throws Exception{
        ResultSet rs =smt.executeQuery("SELECT * FROM actor");
        while(rs.next()){
              String s = "演員名稱：" + rs.getString("actName") + ",演員生日：" + rs.getString("actBirth");
              System.out.println(s);
        }
	}
	
	private static void addAll() throws Exception{
		System.out.println("請輸入欲新增項目 1.演員   2.電影   3.");
		String item = sc.nextLine();
		if(item.equals("1")){
			System.out.println("請輸入演員名稱：");
			String actName = sc.nextLine();
			System.out.println("請輸入演員出生日期：");
			String actBirth = sc.nextLine();
			smt.executeUpdate(" INSERT INTO actor (actName,actBirth) values('" + actName  + "','"+ actBirth + "')");
			ResultSet rs = smt.executeQuery("SELECT * FROM actor where actName='"+actName+"'");
			while(rs.next()){
				String s = "已新增   演員名稱：" + rs.getString("actName") +",  出生日期："+rs.getString("actBirth");
				System.out.println(s);
			}
		}
		else if(item.equals("2")){
			
		}
	}
}
