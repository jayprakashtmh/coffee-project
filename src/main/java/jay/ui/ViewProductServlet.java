package jay.ui;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jay.admin.content.product.Product;

@SuppressWarnings("serial")
@WebServlet("/productsui")
public class ViewProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Product> alp = new ViewProductDAO().viewProduct();
		req.setAttribute("product", alp);
		req.getRequestDispatcher("products.jsp").forward(req, res);
	}
}
