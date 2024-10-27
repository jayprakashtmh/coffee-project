package jay.admin.content.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;

public class ViewBlogDAO {
	public ArrayList<Blog> viewBlog() {
		ArrayList<Blog> alb = new ArrayList<Blog>();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from blogs");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Blog b = new Blog();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPic_url(rs.getString(3));
				b.setDesc(rs.getString(4));
				b.setDate(rs.getDate(5));
				alb.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alb;
	}
}
