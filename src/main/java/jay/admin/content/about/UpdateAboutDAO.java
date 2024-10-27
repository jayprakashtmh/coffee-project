package jay.admin.content.about;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateAboutDAO {
	public int updateAbout(About ab) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update about set name=?, pic_url=?,  qtext=?, description=?");
			ps.setString(1, ab.getName());
			ps.setString(2, ab.getPic_url());
			ps.setString(3, ab.getQtext());
			ps.setString(4, ab.getDesc());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
