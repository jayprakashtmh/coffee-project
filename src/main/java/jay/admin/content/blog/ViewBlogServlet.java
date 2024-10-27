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
@WebServlet("/viewblog")
public class ViewBlogServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			ArrayList<Blog> alb = new ViewBlogDAO().viewBlog();
			hs.setAttribute("blogs", alb);
			req.getRequestDispatcher("Blogadmin.jsp").forward(req, res);
		}
	}
}
