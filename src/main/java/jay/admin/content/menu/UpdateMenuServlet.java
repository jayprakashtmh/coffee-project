package jay.admin.content.menu;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updatemenu")
public class UpdateMenuServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			int mid = Integer.parseInt(req.getParameter("mid"));
			int k = 0;
			@SuppressWarnings("unchecked")
			ArrayList<Menu> alm = (ArrayList<Menu>) hs.getAttribute("menus");
			for (Menu m : alm) {
				if (m.getId() == mid) {
					m.setQty(Integer.parseInt(req.getParameter("qty")));
					m.setPrice(Double.parseDouble(req.getParameter("price")));
					k = new UpdateMenuDAO().updateMenu(m);
					break;
				}
			}
			if(k>0) {
				req.setAttribute("msg", "Menu Updated Successfully!!!");
			}else {
				req.setAttribute("msg", "Something Went Wrong, Menu Updated Failed!!!");
			}
			req.getRequestDispatcher("Menuadmin.jsp").forward(req, res);
		}
	}
}
