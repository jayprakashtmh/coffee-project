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

@SuppressWarnings("serial")
@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Login First!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		} else {
			Order o = new Order();
			int qty = Integer.parseInt(req.getParameter("qty"));
			int id = Integer.parseInt(req.getParameter("pid"));
			o.setProdPrice(Double.parseDouble(req.getParameter("price")));
			o.setProdQty(qty);
			o.setOrdType(req.getParameter("type"));
			o.setCustId(Integer.parseInt(req.getParameter("uid")));
			o.setAddId(Integer.parseInt(req.getParameter("addr")));
			if (req.getParameter("type").equals("menu")) {
				ArrayList<Menu> alm = new ViewMenuDAO().viewMenu();
				System.err.println("men: "+alm);
				for (Menu m : alm) {
					if (m.getId() == id) {
						if (m.getQty() - qty != 0) {
							o.setProdName(m.getName());
							o.setProdPicUrl(m.getPic_url());
							new UpdateMenuDAO().updateQty(id, m.getQty() - qty);
						}
					}
				}
			} else {
				ArrayList<Product> alp = new ViewProductDAO().viewProduct();
				for (Product p : alp) {
					if (p.getId() == id) {
						if (p.getQty() - qty != 0) {
							o.setProdName(p.getName());
							o.setProdPicUrl(p.getPic_url());
							new UpdateProductDAO().updateQty(id, p.getQty() - qty);
						}
					}
				}
			}
			System.out.println("O: "+o);
			int k = new PlaceOrderDAO().placeOrder(o);
			if (k > 0) {
				req.setAttribute("msg", "Order Placed Successfully!!!!");
			}else {
				req.setAttribute("msg", "Failed to Place the Order!!!!");
			}
			req.getRequestDispatcher("ResMsg.jsp").forward(req, res);
		}
	}
}
