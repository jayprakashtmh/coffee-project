package jay.admin.content.blog;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class DeleteBlogDAO {
	public int deleteBlog(int id) {
		int k = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("delete from blogs where id=?");
			ps.setInt(1, id);
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
