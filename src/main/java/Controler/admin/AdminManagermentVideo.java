package Controler.admin;

import Dao.EntityImpDAO.VideoImp;
import Dao.InterfaceClass.VideoDao;
import Model.Video;
import Test.test;
import org.hibernate.type.TrueFalseType;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@MultipartConfig(fileSizeThreshold   = 1024 * 1024 * 1,maxFileSize= 1024 * 1024 * 10, maxRequestSize= 1024 * 1024 * 15)
@WebServlet(urlPatterns = {"/admin/video","/admin/video/"})

public class AdminManagermentVideo extends HttpServlet {
    VideoDao videoService = new VideoImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("funcion");
        String pathEdit = req.getParameter("idvideo");
        if (path == null){doGetVideo(req,resp);}
        switch (path){
            case "homepage":
                doGetVideo(req,resp);
                break;
            case "update" :
                doGetUpdateVideo(req,resp);
                break;
            case "delete" :
                doGetDeleteVideo(req,resp);
                break;
            case "edit" :
                doGetEditVideo(req,resp);
                break;
        }
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("funcion");
        switch (path){
            case "homepage" :
                doPostCreate(req,resp);
                break;
            case "update" :
                doPostUpdateVideo(req,resp);
                break;
            case "delete" :
                doPostDeleteVideo(req,resp);
                break;
            case "edit" :
                doPostEditVideo(req,resp);
                break;
        }
    }

    private void doGetVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Video> videos = videoService.FindAllisNotActive();
        req.setAttribute("videos",videos);
        req.getRequestDispatcher("/views/admin/manager/managervideo.jsp").forward(req,resp);
    }
    private void doGetCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void doGetUpdateVideo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/manager/managervideo.jsp").forward(req,resp);
    }
    private void doGetDeleteVideo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/manager/managervideo.jsp").forward(req,resp);
    }


    private void doPostCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String applicationPath = req.getServletContext().getRealPath("");
        int x = applicationPath.lastIndexOf("\\target");
        String appPath = applicationPath.substring(0,x)+"\\src\\main\\webapp\\views\\detailVideo\\images";
        System.out.println(appPath);
        Part filePart = req.getPart("fileUploadDetail");
        String date = new SimpleDateFormat("ddMMMyyyyHHmmss").format(new Date())+".png";
        String FileNameSave = filePart.getSubmittedFileName()+date;
        File fileSave = new File(appPath,FileNameSave);
        filePart.write(fileSave.getAbsolutePath());

        Video videoImp = new Video();
        videoImp.setId(req.getParameter("youtubeid"));
        videoImp.setTitle(req.getParameter("title"));;
        videoImp.setLink(req.getParameter("youtubeLink"));
        videoImp.setPoster(FileNameSave);
        videoImp.setViews(Integer.parseInt(req.getParameter("count")));
        videoImp.setDepscription(req.getParameter("textarea"));
        boolean isActive=false;
        if (req.getParameter("isActive").equals("active")){
            isActive = true;
        };
        videoImp.setActive(isActive);
        Video video = videoService.create(videoImp);
        if (video != null){
            resp.sendRedirect("/asm/admin/homepage");
        }
    }
    private void doPostUpdateVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Video videoImp = new Video();
        String applicationPath = req.getServletContext().getRealPath("");
        int x = applicationPath.lastIndexOf("\\target");
        String appPath = applicationPath.substring(0,x)+"\\src\\main\\webapp\\views\\detailVideo\\images";
        System.out.println(appPath);
        Part filePart = req.getPart("fileUploadDetail");
        String date = new SimpleDateFormat("ddMMMyyyyHHmmss").format(new Date())+".png";
        String FileNameSave = filePart.getSubmittedFileName()+date;
        File fileSave = new File(appPath,FileNameSave);
        filePart.write(fileSave.getAbsolutePath());
        videoImp.setId(req.getParameter("youtubeid"));
        videoImp.setTitle(req.getParameter("title"));;
        videoImp.setLink(req.getParameter("youtubeLink"));
        videoImp.setPoster(FileNameSave);
        videoImp.setViews(Integer.parseInt(req.getParameter("count")));
        videoImp.setDepscription(req.getParameter("textarea"));
        boolean isActive=false;
        if (req.getParameter("isActive").equals("active")){
            isActive = true;
        };
        videoImp.setActive(isActive);
        Video video = videoService.update(videoImp);
        if (video != null){
            resp.sendRedirect(req.getContextPath()+"/admin/video?funcion=homepage");
        }
    }

    private void doPostDeleteVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       Video video = videoService.FindbyStringId(req.getParameter("youtubeid"));
        video.setActive(false);
       Video videox = videoService.update(video);
       if (videox != null){
           resp.sendRedirect(req.getContextPath()+"/admin/video?funcion=homepage");
       }
    }

    private void doGetEditVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Video video = videoService.findByHref(req.getParameter("idvideohelf"));
        req.setAttribute("videoCurren",video);
        List<Video> videos = videoService.FindAllisNotActive();
        req.setAttribute("videos",videos);
        req.getRequestDispatcher("/views/admin/manager/managervideo.jsp").forward(req,resp);
    }
    private void doPostEditVideo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
