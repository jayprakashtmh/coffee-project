package jay.admin.content.blog;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateblog")
public class UpdateBlogServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			int bid = Integer.parseInt(req.getParameter("bid"));
			int k = 0;
			@SuppressWarnings("unchecked")
			ArrayList<Blog> alb = (ArrayList<Blog>) hs.getAttribute("blogs");
			for (Blog b : alb) {
				if (b.getId() == bid) {
					b.setDesc(req.getParameter("desc"));
					k = new UpdateBlogDAO().updateBlog(b);
					break;
				}
			}
			if (k > 0) {
				req.setAttribute("msg", "Blog Updated Successfully!!!");
			} else {
				req.setAttribute("msg", "Something Went Wrong, Blog Updated Failed!!!");
			}
			req.getRequestDispatcher("Blogadmin.jsp").forward(req, res);
		}
	}
}
