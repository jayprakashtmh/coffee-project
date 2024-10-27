package jay.ui.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;

public class ViewOrderDAO {
	public ArrayList<Order> viewOrder(int cid) {
		ArrayList<Order> ord = new ArrayList<Order>();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from orders where cid=?");
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order o = new Order();
				o.setId(rs.getInt(1));
				o.setProdName(rs.getString(2));
				o.setProdPicUrl(rs.getString(3));
				o.setProdQty(rs.getInt(4));
				o.setProdPrice(rs.getDouble(5));
				o.setOrdType(rs.getString(6));
				o.setCustId(cid);
				o.setAddId(rs.getInt(8));
				ord.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ord;
	}
}
