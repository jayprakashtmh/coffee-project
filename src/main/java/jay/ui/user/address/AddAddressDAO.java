package jay.ui.user.address;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class AddAddressDAO {
	public int addAddress(Address a) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into cust_address values(default,?,?,?,?,?,?,?)");
			ps.setString(1, a.getDoorNo());
			ps.setString(2, a.getStreet());
			ps.setString(3, a.getCity());
			ps.setInt(4, a.getPin());
			ps.setString(5, a.getState());
			ps.setString(6, a.getCountry());
			ps.setInt(7, a.getCid());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
