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
@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<Product> alp = (ArrayList<Product>) hs.getAttribute("prods");
			int id = Integer.parseInt(req.getParameter("pid"));
			int k=0;
			for(Product p : alp) {
				if(p.getId()==id) {
					p.setQty(Integer.parseInt(req.getParameter("qty")));
					p.setPrice(Double.parseDouble(req.getParameter("price")));
					p.setRating(Integer.parseInt(req.getParameter("rating")));
					k=new UpdateProductDAO().updateProduct(p);
					break;
				}
			}
			if(k>0) {
				req.setAttribute("msg", "Product update Successfully!!!");
			}else {
				req.setAttribute("msg", "Something went wrong, Failed to Update Product.");
			}
			req.getRequestDispatcher("Productadmin.jsp").forward(req, res);
		}
	}
}
