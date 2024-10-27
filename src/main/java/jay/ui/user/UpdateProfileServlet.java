package jay.ui.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateprofile")
public class UpdateProfileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Login First!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		} else {
			User u = (User) hs.getAttribute("user");
			u.setName(req.getParameter("name"));
			u.setPhno(Long.parseLong(req.getParameter("phno")));
			u.setPword(req.getParameter("pword"));
			int i = new UserUpdateProfileDAO().updateProfile(u);
			if (i > 0) {
				req.getRequestDispatcher("index.jsp").forward(req, res);
			}
		}
	}
}
