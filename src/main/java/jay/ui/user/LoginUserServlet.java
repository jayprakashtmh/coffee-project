package jay.ui.user;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.ui.user.address.Address;
import jay.ui.user.address.ViewAddressDAO;

@SuppressWarnings("serial")
@WebServlet("/loginuser")
public class LoginUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User u = new LoginUserDAO().loginUser(req.getParameter("email"), req.getParameter("pword"));
		try {
			u.getName().length();
			HttpSession hs = req.getSession();
			hs.setAttribute("user", u);
			ArrayList<Address> add = new ViewAddressDAO().viewAddress(u.getId());
			hs.setAttribute("address", add);
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} catch (Exception e) {
			req.setAttribute("msg", "Wrong Email or Password!!!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		}
	}
}
