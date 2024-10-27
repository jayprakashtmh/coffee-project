package jay.admin.content.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;

public class ViewMenuDAO {
	public ArrayList<Menu> viewMenu() {
		ArrayList<Menu> alm = new ArrayList<Menu>();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from menu");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Menu m = new Menu();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPic_url(rs.getString(3));
				m.setQty(rs.getInt(4));
				m.setPrice(rs.getDouble(5));
				m.setAvl(rs.getInt(6));
				alm.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alm;
	}
}
