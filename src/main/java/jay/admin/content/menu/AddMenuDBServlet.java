package jay.admin.content.menu;

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
@WebServlet("/addmenuadmin")
@MultipartConfig
public class AddMenuDBServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			Menu m = new Menu();
			m.setName(req.getParameter("name"));
			m.setPic_url(new Image().saveImage(req.getPart("pic"), Folder.menu_img.toString()));
			m.setQty(Integer.parseInt(req.getParameter("qty")));
			m.setPrice(Double.parseDouble(req.getParameter("price")));
			m.setAvl(1);
			int k = new AddMenuDAO().addMenu(m);
			if (k > 0) {
				req.setAttribute("msg", "Menu Added Sucessfully.");
				req.getRequestDispatcher("Menuadmin.jsp").forward(req, res);
			}
		}
	}
}
