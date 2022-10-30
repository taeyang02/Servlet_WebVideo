package Dao.EntityImpDAO;

import java.util.List;

import Dao.AbstractDao;
import Dao.InterfaceClass.VideoDao;
import Model.Video;

public class VideoImp extends AbstractDao<Video> implements VideoDao{

	@Override
	public Video findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String query = "Select o from Video o where o.link = ?0";
		return super.finOne(Video.class, query, href);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}
	@Override
	public Video FindbyStringId(String id) {
		String qr = "select o from Video o where o.id = ?0";
		return super.finOne(Video.class,qr,id);
	}

	@Override
	public List<Video> FindAllisNotActive() {
		String querry = "Select o from Video o";
		return super.CreateQuery(querry);
	}


	@Override
	public Video create(Video entity){
		try {
			Video video = super.create(entity);
			return video;
		} catch (Exception e) {
			return null;
		}

	}
	@Override
	public Video update(Video entity){
		try {
			Video video = super.update(entity);
			return video;
		} catch (Exception e) {
			return null;
		}

	}


}
