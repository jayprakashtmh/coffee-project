package jay.ui.order;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateMenuDAO {
	public int updateQty(int id, int qty) {
		int k = 0;
		Connection con = DBConnection.getCon();
		try {
			//Change in Flight Setting Avl to zero or one based on qty
			System.out.println(qty);
			int avl = 1;
			if(qty==0)
				avl=0;
			PreparedStatement ps = con.prepareStatement("update menu set qty=?, avl=? where id=?");
			ps.setInt(1, qty);
			ps.setInt(2, avl);
			ps.setInt(3, id);
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}