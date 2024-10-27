package jay.ui.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jay.common.DBConnection;

public class LoginUserDAO {
	public User loginUser(String eM, String pW) {
		User u = new User();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from user_info where email=? and pword=?");
			ps.setString(1, eM);
			ps.setString(2, pW);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setPword(rs.getString(3));
				u.setName(rs.getString(4));
				u.setPhno(rs.getLong(5));
				u.setPic(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
