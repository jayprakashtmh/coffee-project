package jay.ui.order;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.ui.user.User;

@SuppressWarnings("serial")
@WebServlet("/order")
public class ViewOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Login First!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		} else {
			User u = (User) hs.getAttribute("user");
			ArrayList<Order> alo = new ViewOrderDAO().viewOrder(u.getId());
			req.setAttribute("order", alo);
			req.getRequestDispatcher("Orders.jsp").forward(req, res);
		}
	}
}
