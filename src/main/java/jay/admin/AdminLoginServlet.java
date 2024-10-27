package jay.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminlogin")
@SuppressWarnings("serial")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Admin ad = new AdminLoginDAO().loginAdmin(req.getParameter("uname"), req.getParameter("pword"));
		try {
			ad.getuName().length();
			HttpSession hs = req.getSession();
			hs.setAttribute("admin", ad);
			req.getRequestDispatcher("Choiceadmin.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("msg", "Login Denyed!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		}
	}
}
