package jay.common;

import java.sql.Connection;
import java.sql.DriverManager;
import static jay.common.DBInfo.*;

public class DBConnection {
	public static Connection getCon() {
		try {
			Class.forName(PATH);
			Connection con = DriverManager.getConnection(URL, UNAME, PWORD);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private DBConnection() {
		// TODO Auto-generated constructor stub
	}
}
