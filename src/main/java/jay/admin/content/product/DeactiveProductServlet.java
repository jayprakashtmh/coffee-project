package jay.admin.content.product;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/deactive")
public class DeactiveProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<Product> alp = (ArrayList<Product>) hs.getAttribute("prods");
			int id = Integer.parseInt(req.getParameter("pid"));
			int k = 0;
			for (Product p : alp) {
				if (p.getId() == id) {
					if (p.getAvl() == 0)
						p.setAvl(1);
					else
						p.setAvl(0);
					k = new DeactiveProductDAO().deactiveProduct(p);
					break;
				}
			}
			if (k > 0) {
				req.setAttribute("msg", "Product update Successfully!!!");
			} else {
				req.setAttribute("msg", "Something went wrong, Failed to Update Product.");
			}
			req.getRequestDispatcher("Productadmin.jsp").forward(req, res);
		}
	}
}
