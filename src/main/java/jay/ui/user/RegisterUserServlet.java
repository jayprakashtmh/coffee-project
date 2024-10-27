package jay.ui.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jay.common.Folder;
import jay.common.Image;

@SuppressWarnings("serial")
@WebServlet("/reguser")
@MultipartConfig
public class RegisterUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User u = new User();
		u.setName(req.getParameter("name"));
		u.setEmail(req.getParameter("email"));
		u.setPword(req.getParameter("pword"));
		u.setPhno(Long.parseLong(req.getParameter("phno")));
		u.setPic(new Image().saveImage(req.getPart("pic"), Folder.img.toString()));
	
		int k = new RegisterUserDAO().regUser(u);
		if (k > 0) {
			req.setAttribute("msg", "Register Successfull!!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		}if(k==-1) {
			req.setAttribute("msg", "User Already Exist!!!");
			req.getRequestDispatcher("LoginUser.jsp").forward(req, res);
		}
	}
}
