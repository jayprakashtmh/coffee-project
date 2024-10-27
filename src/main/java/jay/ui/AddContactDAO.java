package jay.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class AddContactDAO {
	public int addContact(Contact c) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into contact values(default,?,?,?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setLong(3, c.getNumber());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}