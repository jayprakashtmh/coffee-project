package jay.ui.user.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jay.common.DBConnection;

public class DeleteAddressDAO {
	public int delAddress(int id) {
		int k = 0;
		Connection con = DBConnection.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("delete from cust_address where id=?");
			ps.setInt(1, id);
			k = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}
}
