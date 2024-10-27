package jay.admin.content.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateMenuDAO {
	public int updateMenu(Menu m) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update menu set qty=?, price=? where id=?");
			ps.setInt(1, m.getQty());
			ps.setDouble(2, m.getPrice());
			ps.setInt(3, m.getId());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
