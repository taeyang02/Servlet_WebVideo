package Controler.admin;

import Dao.EntityImpDAO.VideoImp;
import Dao.InterfaceClass.VideoDao;
import Model.Video;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/homepage","/admin"})
public class HomepageAdmin extends HttpServlet {
    VideoDao videoService = new VideoImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("isAdmin","admin");
        List<Video> videos = videoService.findAll();
        int pagesize = (int) Math.ceil((double)videos.size()/9);
        req.setAttribute("pagesize",pagesize);
        String pageindex = req.getParameter("indexpage");
        List<Video> videos1;
        if (pageindex == null){
            videos1 = videoService.findAll(1,9);
            req.setAttribute("currentPage",1);
        }else {
            int getIndexLoadVideo = Integer.parseInt(req.getParameter("indexpage"));
            videos1 = videoService.findAll(getIndexLoadVideo, 9);
            req.setAttribute("currentPage",pageindex);
        }
        req.setAttribute("videos", videos1);
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
