package jay.admin.content.about;

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
@WebServlet("/updateaboutadmin")
@MultipartConfig
public class UpdateAboutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if (hs == null) {
			req.setAttribute("msg", "Session Expired!!!!!");
			req.getRequestDispatcher("Msgadmin.jsp").forward(req, res);
		} else {
			About ab = (About) hs.getAttribute("about");
			ab.setName(req.getParameter("name"));
			String img = new Image().saveImage(req.getPart("pic"), Folder.img.toString());
			ab.setPic_url(img);
			ab.setQtext(req.getParameter("qtext"));
			ab.setDesc(req.getParameter("desc"));
			int k = new UpdateAboutDAO().updateAbout(ab);
			if (k > 0) {
				req.setAttribute("msg", "About Data Updated Successfully!!!");
				req.getRequestDispatcher("Aboutadmin.jsp").forward(req, res);
			}
		}
	}
}
