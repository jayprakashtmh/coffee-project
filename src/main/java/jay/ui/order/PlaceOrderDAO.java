package jay.ui.order;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class PlaceOrderDAO {
	public int placeOrder(Order o) {
		System.err.println("Order: "+o);
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into orders values(default,?,?,?,?,?,?,?)");
			ps.setString(1, o.getProdName());
			ps.setString(2, o.getProdPicUrl());
			ps.setInt(3, o.getProdQty());
			ps.setDouble(4, o.getProdPrice());
			ps.setString(5, o.getOrdType());
			ps.setInt(6, o.getCustId());
			ps.setInt(7, o.getAddId());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
