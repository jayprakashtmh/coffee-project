package jay.admin.content.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class AddMenuDAO {
	public int addMenu(Menu m) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into menu values(default,?,?,?,?,?)");
			ps.setString(1, m.getName());
			ps.setString(2, m.getPic_url());
			ps.setInt(3, m.getQty());
			ps.setDouble(4, m.getPrice());
			ps.setInt(5, m.getAvl());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
