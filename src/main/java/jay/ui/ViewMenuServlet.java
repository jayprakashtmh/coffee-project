package jay.ui;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jay.admin.content.menu.Menu;

@SuppressWarnings("serial")
@WebServlet("/menuui")
public class ViewMenuServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Menu> alm = new ViewMenuDAO().viewMenu();
		req.setAttribute("menu", alm);
		req.getRequestDispatcher("menu.jsp").forward(req, res);
	}
}
