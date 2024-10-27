package jay.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.admin.content.product.Product;
import jay.common.DBConnection;

public class ViewProductDAO {
	public ArrayList<Product> viewProduct() {
		ArrayList<Product> alp = new ArrayList<Product>();
		try {
			Connection con = DBConnection.getCon();
			ResultSet rs = con.prepareStatement("select * from product where avl=1").executeQuery();
			while (rs.next()){
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPic_url(rs.getString(3));
				p.setQty(rs.getInt(4));
				p.setPrice(rs.getDouble(5));
				p.setRating(rs.getInt(6));
				p.setAvl(rs.getInt(7));
				alp.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alp;
	}
}
