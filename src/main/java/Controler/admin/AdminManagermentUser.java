package Controler.admin;

import Dao.EntityImpDAO.UserImp;
import Dao.InterfaceClass.UserDao;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/user"})
public class AdminManagermentUser extends HttpServlet {
    UserDao userService = new UserImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("funcion");
        if (path==null){
            doGetUpdate(req,resp);
        }
        switch (path){
            case "update" :
                doGetUpdate(req,resp);
                break;
            case  "delete" :
                doGetDelete(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("idUser");
        User user = userService.findByUsername(username);

        user.setId(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setFullname(req.getParameter("fullname"));
        user.setEmail(req.getParameter("email"));
        if (userService.update(user) !=null){
            resp.sendRedirect(req.getContextPath()+"/admin/user");
        }


    }
    private void doGetUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("funcion")==null){
            req.setAttribute("isFuncion",false);
        }else {
            req.setAttribute("isFuncion",true);
            User user = userService.findByUsername(req.getParameter("idUser"));
            req.setAttribute("userCurren",user);
        }
        req.setAttribute("users",userService.findAllisActive());
        req.getRequestDispatcher("/views/admin/manager/manageruser.jsp").forward(req,resp);
    }
    private void doGetDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("idUser");
        User user = userService.findByUsername(username);
        user.setActive(false);
        User userResult = userService.update(user);
        if (userResult != null){
            resp.sendRedirect("/asm/admin/user");
        }
    }
}
