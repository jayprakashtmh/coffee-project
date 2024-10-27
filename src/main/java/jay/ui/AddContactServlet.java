package jay.ui;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/sajida")
public class AddContactServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Contact c = new Contact();
		c.setName(req.getParameter("name"));
		c.setEmail(req.getParameter("email"));
		c.setNumber(Long.parseLong(req.getParameter("phno")));
		int k = new AddContactDAO().addContact(c);
		if (k > 0) {
			req.setAttribute("msg", "Thankyou!!!");
			req.getRequestDispatcher("contact.jsp").forward(req, res);
		}
	}
}
