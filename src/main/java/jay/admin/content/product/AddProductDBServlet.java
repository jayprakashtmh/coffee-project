package jay.admin.content.product;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jay.common.Folder;
import jay.common.Image;

@SuppressWarnings("serial")
@WebServlet("/addprodadmin")
@MultipartConfig
public class AddProductDBServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			Product p = new Product();
			p.setName(req.getParameter("name"));
			p.setPic_url(new Image().saveImage(req.getPart("pic"), Folder.product_img.toString()));
			p.setQty(Integer.parseInt(req.getParameter("qty")));
			p.setPrice(Double.parseDouble(req.getParameter("price")));
			p.setRating(Integer.parseInt(req.getParameter("rating")));

			int k = new AddProductDAO().addProd(p);
			if (k > 0) {
				req.setAttribute("msg", "Product Added Successfully!!");
				req.getRequestDispatcher("/viewprodp").forward(req, res);
			}
		}
	}
}
