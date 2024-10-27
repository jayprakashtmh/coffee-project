package jay.admin.content.blog;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.common.Folder;
import jay.common.Image;

@SuppressWarnings("serial")
@WebServlet("/addblogadmin")
@MultipartConfig
public class AddBlogDBServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			Blog b = new Blog();
			b.setName(req.getParameter("name"));
			b.setPic_url(new Image().saveImage(req.getPart("pic"), Folder.blog_img.toString()));
			b.setDesc(req.getParameter("desc"));
			b.setDate(Date.valueOf(LocalDate.now()));
			int k = new AddBlogDAO().addBlog(b);
			if (k > 0) {
				req.setAttribute("msg", "Blog Added!!!");
				req.getRequestDispatcher("Blogadmin.jsp").forward(req, res);
			}
		}
	}
}
