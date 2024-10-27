package jay.admin.content.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class AddProductDAO {
	public int addProd(Product p) {
		int k = 0;

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into product values(default,?,?,?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getPic_url());
			ps.setInt(3, p.getQty());
			ps.setDouble(4, p.getPrice());
			ps.setInt(5, p.getRating());
			ps.setInt(6, 1);
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
}
