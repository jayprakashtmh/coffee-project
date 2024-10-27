package jay.ui.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

import jay.common.DBConnection;

public class RegisterUserDAO {
	public int regUser(User u) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into user_info values(default,?,?,?,?,?)");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPword());
			ps.setString(3, u.getName());
			ps.setLong(4, u.getPhno());
			ps.setString(5, u.getPic());
			k = ps.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}