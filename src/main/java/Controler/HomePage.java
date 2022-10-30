package Controler;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.EntityImpDAO.FavoriteImp;
import Dao.EntityImpDAO.VideoImp;
import Dao.InterfaceClass.FavariteDao;
import Dao.InterfaceClass.VideoDao;
import Model.Favorite;
import Model.User;
import Model.Video;
import constant.SessionAttr;

/**
 * Servlet implementation class HomePage
 */
@WebServlet(urlPatterns = {"/index","/favorite"})
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoDao videoService = new VideoImp();
	FavariteDao favoriteService = new FavoriteImp();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path){
			case "/index" :
				goGetIndex(session,request,response);
				break;
			case "/favorite" :
				goGetFavotite(session,request,response);
				break;
		}

	}

	private void goGetIndex(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session.setAttribute("isAdmin","user");
		List<Video> videos = videoService.findAll();
		int pagesize = (int) Math.ceil((double)videos.size()/9);
		 request.setAttribute("pagesize",pagesize);
		 String pageindex = request.getParameter("indexpage");
		List<Video> videos1;
		if (pageindex == null){
			 videos1 = videoService.findAll(1,9);
			 request.setAttribute("currentPage",1);
		}else {
		int getIndexLoadVideo = Integer.parseInt(request.getParameter("indexpage"));
		 	videos1 = videoService.findAll(getIndexLoadVideo, 9);
			request.setAttribute("currentPage",pageindex);
		}
		request.setAttribute("videos", videos1);
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	private void goGetFavotite(HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		System.out.println(user.getId());
		List<Favorite> listfavorites = favoriteService.finbyUserandIsLike(user,true);
		List<Video> videos = new ArrayList<>();
		for (int i = 0; i < listfavorites.size(); i++) {
			Favorite fv = listfavorites.get(i);
			Video video = videoService.FindbyStringId(fv.getIdvideo().getId());
			videos.add(video);
		}
		request.setAttribute("listfavorites",listfavorites);
		request.setAttribute("videos",videos);
		request.getRequestDispatcher("/views/detailVideo/favorite.jsp").forward(request, response);
	}
	

}
