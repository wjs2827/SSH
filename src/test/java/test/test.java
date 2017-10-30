package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://106.15.52.104:3306/wangjs_test";
		String u="root";
		String p="caidongcai1!";
		try {
			Class.forName(driver);
			try {
				Connection conn=DriverManager.getConnection(url,u,p);
				if(!conn.isClosed()){
					 System.out.println("Succeeded connecting to the Database!");
				}
				Statement statement = conn.createStatement();
				String sql="select * from tuser";
				ResultSet rs = statement.executeQuery(sql);
				 while(rs.next()) {
					 System.out.println(rs.getString("username"));
				 }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
