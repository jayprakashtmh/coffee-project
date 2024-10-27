package jay.ui.user.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;

public class ViewAddressDAO {
	public ArrayList<Address> viewAddress(int id) {
		ArrayList<Address> ala = new ArrayList<Address>();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from cust_address where cid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Address a = new Address();
				a.setId(rs.getInt(1));
				a.setDoorNo(rs.getString(2));
				a.setStreet(rs.getString(3));
				a.setCity(rs.getString(4));
				a.setPin(rs.getInt(5));
				a.setState(rs.getString(6));
				a.setCountry(rs.getString(7));
				a.setCid(rs.getInt(8));
				ala.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ala;
	}
}
