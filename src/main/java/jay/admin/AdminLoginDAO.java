package jay.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jay.common.DBConnection;

public class AdminLoginDAO {
	public Admin loginAdmin(String uN, String pW) {
		Connection con = DBConnection.getCon();
		Admin admin = new Admin();
		try {
			PreparedStatement ps = con.prepareStatement("select * from admin where uname=? and pass=?");
			ps.setString(1, uN);
			ps.setString(2, pW);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin.setuName(rs.getString(1));
				admin.setPword(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}
