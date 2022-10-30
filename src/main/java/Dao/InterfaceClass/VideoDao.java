package Dao.InterfaceClass;

import java.util.List;

import Model.Video;

public interface VideoDao {
	Video findById(Integer id); 
	Video findByHref(String href);
	List<Video> findAll();
	List<Video> findAll(int pageNumber, int pageSize);
	Video create(Video entity);
	Video update(Video entity);
	Video delete(Video entity);
	Video FindbyStringId(String id);
	List<Video> FindAllisNotActive();

}
