package Dao.EntityImpDAO;

import Dao.AbstractDao;
import Dao.InterfaceClass.FavariteDao;
import Model.Favorite;
import Model.User;
import Model.Video;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class FavoriteImp extends AbstractDao<Favorite> implements FavariteDao{
	VideoImp videoService;
	public FavoriteImp(){
		videoService = new VideoImp();
	}
	@Override
	public List<Favorite> finbyUser(String username) {
		String query = "select o from Favorite o where o.iduser =?0";
		return super.findAllQuery(Favorite.class,query,username);
	}

	@Override
	public List<Favorite> finbyUserandIsLike(User username, boolean isLike) {
		String query = "select o from Favorite o where o.iduser = ?0 and o.islike = ?1";
		return super.findAllQuery(Favorite.class,query,username,isLike);
	}

	@Override
	public Favorite FindByUserIdandVideoId(String username, Integer videoid) {
		String query = "Select o from Favorite o where iduser = ?0 and idvideo=?1";
		return finOne(Favorite.class,query,username,videoid);
	}

	@Override
	public Favorite create(User user, Video video) {
		Favorite fav = new Favorite();
		Date date = new Date();
		fav.setLikedate(date);
		fav.setIduser(user);
		fav.setIdvideo(video);
		fav.setIslike(true);
		return super.create(fav);
	}

	@Override
	public Favorite findByUserHelf(User user, String helf) {
		Video video = videoService.findByHref(helf);
		String query = "Select o from Favorite o where o.iduser = ?0 and o.idvideo = ?1";
		try {
			Favorite favorite =	super.finOne(Favorite.class,query,user,video);
			return favorite;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public boolean UpdateLiked(User username, String helfVideo) throws ParseException {
		Favorite fav = findByUserHelf(username,helfVideo);
		Video video = videoService.findByHref(helfVideo);
		Date date = new Date();
		if (fav == null){
			create(username,video);
		}else {
			if (fav.getIslike() == true){
			fav.setIslike(false);
			}else {
				fav.setIslike(true);
			}
			update(fav);
			return true;
		}
		return false;
	}


}
