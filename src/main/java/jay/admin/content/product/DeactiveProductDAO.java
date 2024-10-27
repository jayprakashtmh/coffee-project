package jay.admin.content.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class DeactiveProductDAO {

	public int deactiveProduct(Product p) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update product set avl=? where id=?");
			ps.setInt(1, p.getAvl());
			ps.setInt(2, p.getId());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
