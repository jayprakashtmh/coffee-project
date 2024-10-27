package jay.admin.content.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class DeactiveMenuDAO {
	public int deactiveMenu(Menu m) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update menu set avl=? where id=?");
			ps.setInt(1, m.getAvl());
			ps.setInt(2, m.getId());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
