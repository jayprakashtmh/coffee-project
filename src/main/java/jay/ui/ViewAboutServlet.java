package jay.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jay.admin.content.about.About;
import jay.admin.content.about.ViewAboutDAO;

@SuppressWarnings("serial")
@WebServlet("/viewui")
public class ViewAboutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		About ab = new ViewAboutDAO().showAbout();
		req.setAttribute("about", ab);
		req.getRequestDispatcher("about.jsp").forward(req, resp);
	}
}
