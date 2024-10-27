package jay.ui.order;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.admin.content.menu.Menu;
import jay.admin.content.menu.ViewMenuDAO;
import jay.admin.content.product.Product;
import jay.admin.content.product.ViewProductDAO;

@WebServlet("/plceord")
@SuppressWarnings("serial")
public class PlaceOrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Login First!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		}else {
			if(req.getParameter("type").equals("menu")) {
				ArrayList<Menu> alm = new ViewMenuDAO().viewMenu();
				req.setAttribute("data", alm);
			}else {	
				ArrayList<Product> alp = new ViewProductDAO().viewProduct();
				req.setAttribute("data", alp);
			}
			req.getRequestDispatcher("PlaceOrder.jsp").forward(req, res);
		}
	}
}
