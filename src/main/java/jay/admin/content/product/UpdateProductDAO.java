package jay.admin.content.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateProductDAO {
	public int updateProduct(Product p) {
		int k=0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update product set qty=?, price=?, rating=? where id=?");
			ps.setInt(1, p.getQty());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getRating());
			ps.setInt(4, p.getId());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
