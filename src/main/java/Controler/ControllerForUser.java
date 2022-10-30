package Controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.EntityImpDAO.UserImp;
import Dao.InterfaceClass.UserDao;
import Model.User;
import constant.SessionAttr;

/**
 * Servlet implementation class ControllerForUser
 */
@WebServlet(urlPatterns = {"/user/login","/user/logout","/user/register","/user/changepass","/user/updateaccount"})
public class ControllerForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao UserService = new UserImp();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path){
			case "/user/login" :
				doGetLogin(request,response);
				break;
			case "/user/register" :
				doGetRegister(request,response);
				break;
			case "/user/logout" :
				doGetLogout(session,request,response);
				break;
			case "/user/changepass" :
				doGetChangePassword(request,response);
				break;
			case "/user/updateaccount" :
				doGetEditprofile(request,response);
				break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path){
			case "/user/login" :
				doPostLogin(session,request,response);
				break;
			case "/user/register" :
				doPostRegister(session,request,response);
				break;
			case "/user/changepass" :
				doPostChangePassword(session,request,response);
				break;
			case "/user/updateaccount" :
				doPostEditprofile(session,request,response);
				break;
		}
	}
//	Sử lý login
	private void doGetLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/views/user/login.jsp").forward(request,response);
	}
	private void doPostLogin(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user =  UserService.login(username,password);
		if (user != null){
			session.setAttribute(SessionAttr.CURRENT_USER,user);
			response.sendRedirect("/asm/index");
		}else {
			response.sendRedirect("/asm/user/login");
		}
	}
//	sử lý đăng ký
	private void doGetRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/register.jsp").forward(request,response);
	}
	private void doPostRegister(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		User user =  UserService.create(username,password,email,fullname);
		if (user != null){
			response.sendRedirect("/asm/index");
		}
	}
	private void doGetLogout(HttpSession session ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session.removeAttribute(SessionAttr.CURRENT_USER);
		response.sendRedirect("/asm/index");
	}

	private void doGetChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/changepass.jsp").forward(request,response);
	}
	private void doPostChangePassword(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String passwordOld = request.getParameter("passwordOld");
		String passwordNew = request.getParameter("passwordChange");
		String passwordComfim = request.getParameter("confimPasswordChange");
		User userchange = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		userchange.setPassword(passwordNew);
		User user =  UserService.update(userchange);
		if (user != null){
			session.setAttribute(SessionAttr.CURRENT_USER,user);
			response.sendRedirect("/asm/index");
		}else {
			response.sendRedirect("/asm/user/login");
		}
	}

	private void doGetEditprofile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/updateaccount.jsp").forward(request,response);
	}
	private void doPostEditprofile(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FullName = request.getParameter("fullname");
		String Gmail = request.getParameter("email");
		User userchange = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		userchange.setFullname(FullName);
		userchange.setEmail(Gmail);
		User user =  UserService.update(userchange);
		if (user != null){
			response.sendRedirect("/asm/index");
		}else {
			response.sendRedirect("/asm/user/login");
		}
	}
}
