package jay.ui.user.address;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/addcustaddr")
public class AddAddressDBServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Login First!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		}else {
			
			Address a = new Address();
			a.setCid(Integer.parseInt(req.getParameter("cid")));
			a.setDoorNo(req.getParameter("doorno"));
			a.setStreet(req.getParameter("street"));
			a.setCity(req.getParameter("city"));
			a.setPin(Integer.parseInt(req.getParameter("pin")));
			a.setState(req.getParameter("state"));
			a.setCountry(req.getParameter("country"));
			
			int k = new AddAddressDAO().addAddress(a);
			if(k>0) {
				req.getRequestDispatcher("viewaddressp").forward(req, res);
			}
		}
	}
}
