package jay.admin.content.menu;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/deactivemenu")
public class DeactiveMenuServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<Menu> alm = (ArrayList<Menu>) hs.getAttribute("menus");
			int id = Integer.parseInt(req.getParameter("mid"));
			int k = 0;
			for (Menu m : alm) {
				if (m.getId() == id) {
					if (m.getAvl() == 0)
						m.setAvl(1);
					else
						m.setAvl(0);
					k = new DeactiveMenuDAO().deactiveMenu(m);
					break;
				}
			}
			if (k > 0) {
				req.setAttribute("msg", "Menu update Successfully!!!");
			} else {
				req.setAttribute("msg", "Something went wrong, Failed to Update Menu.");
			}
			req.getRequestDispatcher("Menuadmin.jsp").forward(req, res);
		}
	}
}
