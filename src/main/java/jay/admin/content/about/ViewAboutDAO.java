package jay.admin.content.about;

import java.sql.Connection;
import java.sql.ResultSet;

import jay.common.DBConnection;

public class ViewAboutDAO {
	public About showAbout() {
		About a = new About();
		try {
			Connection con = DBConnection.getCon();
			ResultSet rs = con.prepareStatement("select * from about").executeQuery();
			if (rs.next()) {
				a.setName(rs.getString(1));
				a.setPic_url(rs.getString(2));
				a.setQtext(rs.getString(3));
				a.setDesc(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
}
