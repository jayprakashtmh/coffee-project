package jay.ui;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jay.admin.content.blog.Blog;
import jay.admin.content.blog.ViewBlogDAO;

@SuppressWarnings("serial")
@WebServlet("/blogsui")
public class ViewBlogServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Blog> alb = new ViewBlogDAO().viewBlog();
		req.setAttribute("blog", alb);
		req.getRequestDispatcher("blogs.jsp").forward(req, res);
	}
}
