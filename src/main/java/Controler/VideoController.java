package Controler;

import Dao.EntityImpDAO.FavoriteImp;
import Dao.EntityImpDAO.ShareImp;
import Dao.EntityImpDAO.VideoImp;
import Dao.InterfaceClass.FavariteDao;
import Dao.InterfaceClass.ShareDao;
import Dao.InterfaceClass.VideoDao;
import Model.Favorite;
import Model.Share;
import Model.User;
import Model.Video;
import Test.sendMail;
import constant.SessionAttr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/video","/share"})
public class VideoController extends HttpServlet {
    private VideoDao videoService = new VideoImp();
    private FavariteDao favoriteService = new FavoriteImp();
    private ShareDao shareService = new ShareImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        String href = request.getParameter("id");
        if (path.contains("/video")){
        String action = request.getParameter("action");
        switch (action){
            case "watch":
                doGetWatch(session,href,request,response);
                break;
            case "like" :
                try {
                    doGetLike(session,href,request,response);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                break;
        }}else if (path.contains("/share")){
            doGetShare(href,session,request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        if (path.contains("/share")){
            String href = request.getParameter("id");
            doPostShare(session,href,request,response);
        }
    }

    private void doGetWatch(HttpSession session,String herf,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Video video = videoService.findByHref(herf);
        request.setAttribute("video",video);
        int view = video.getViews();
        video.setViews(view+1);
        videoService.update(video);
        List<Video> videos = videoService.findAll(1,6);
        request.setAttribute("videos",videos);
        User crUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);

        Favorite favorite =  favoriteService.findByUserHelf(crUser,video.getLink());
        if (favorite == null){
            request.setAttribute("flagLikedBtn",false);
        }else {
            request.setAttribute("flagLikedBtn", favorite.getIslike());
        }
        request.getRequestDispatcher("/views/detailVideo/detailvideo.jsp").forward(request,response);
    }

    private void doGetLike(HttpSession session,String herf,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        User crUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
        if (crUser == null){
            response.sendRedirect("/asm/user/login");
        }else {
            boolean likeResult = favoriteService.UpdateLiked(crUser,herf);
            response.sendRedirect("/asm/video?action=watch&id="+request.getParameter("id"));
        }
    }
    private void doGetShare(String href,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User crUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
        if (crUser == null){
            response.sendRedirect("/asm/user/login");
        }else {
        String nameId = request.getParameter("id");
        request.setAttribute("id",nameId);
        request.getRequestDispatcher("/views/detailVideo/share.jsp").forward(request,response);}
    }

    private void doPostShare(HttpSession session,String helf,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String linkshare =  "http://localhost:8080/asm/video?action=watch&id="+request.getParameter("id");
        String GmailShare = request.getParameter("emailAndress");
        sendMail.send(GmailShare,linkshare);
        User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
        Video video = videoService.findByHref(request.getParameter("id"));
        Share share = new Share();
        share.setIdusers(user);
        share.setEmails(GmailShare);
        share.setIdvideos(video);
        share.setSharedate(new Date());
        Share share1 = shareService.create(share);
        response.sendRedirect("/asm/index");
    }
}
