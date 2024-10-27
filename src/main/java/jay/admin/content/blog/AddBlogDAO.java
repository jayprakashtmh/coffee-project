package jay.admin.content.blog;

import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class AddBlogDAO {
	public int addBlog(Blog b) {
		int k = 0;
		try {
			PreparedStatement ps = DBConnection.getCon().prepareStatement("insert into blogs values(default,?,?,?,?)");
			ps.setString(1, b.getName());
			ps.setString(2, b.getPic_url());
			ps.setString(3, b.getDesc());
			ps.setDate(4, b.getDate());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
