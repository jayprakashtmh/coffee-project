package jay.ui.user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UserUpdateProfileDAO {
	public int updateProfile(User u) {
		int i = 0;
		Connection con = DBConnection.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("update user_info set pword=?, name=?, phno=?  where id=?");
			ps.setString(1, u.getPword());
			ps.setString(2, u.getName());
			ps.setLong(3, u.getPhno());
			ps.setInt(4, u.getId());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
