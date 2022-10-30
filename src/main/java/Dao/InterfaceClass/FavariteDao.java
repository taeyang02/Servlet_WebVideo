package Dao.InterfaceClass;

import Model.Favorite;
import Model.User;
import Model.Video;

import java.text.ParseException;
import java.util.List;

public interface FavariteDao {
	List<Favorite> finbyUser(String username);
	List<Favorite>finbyUserandIsLike(User username, boolean isLike);
	Favorite FindByUserIdandVideoId(String username,Integer videoid);
	Favorite create(User user , Video video);
	Favorite findByUserHelf(User user, String helf);
	boolean UpdateLiked(User username,String helfVideo) throws ParseException;
}
