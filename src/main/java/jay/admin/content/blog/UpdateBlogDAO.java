package jay.admin.content.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateBlogDAO {
	public int updateBlog(Blog b) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update blogs set description=? where id=?");
			ps.setString(1, b.getDesc());
			ps.setInt(2, b.getId());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
