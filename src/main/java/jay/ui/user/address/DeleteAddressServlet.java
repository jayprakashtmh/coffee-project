package jay.ui.user.address;

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
@WebServlet("/deladd")
public class DeleteAddressServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Login First!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		} else {
			User u = (User) hs.getAttribute("user");
			int k = 0;
			int id = Integer.parseInt(req.getParameter("aid"));
			@SuppressWarnings("unchecked")
			ArrayList<Address> add = (ArrayList<Address>) hs.getAttribute("address");
			for (Address a : add) {
				if (a.getId() == id && u.getId() == a.getCid()) {
					add.remove(a);
					k = new DeleteAddressDAO().delAddress(id);
					break;
				}
			}
			if(k>0)
			req.getRequestDispatcher("address.jsp").forward(req, res);
		}
	}
}
