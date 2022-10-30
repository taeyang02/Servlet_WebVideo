package Dao.InterfaceClass;

import java.util.List;

import Model.Share;

public interface ShareDao {
	Share create(Share entity);
	Share update(Share entity);
	Share delete(Share entity);
	Share findbyId(Integer id);
	List<Share> FindAll();
}
