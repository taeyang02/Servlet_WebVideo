package Dao.EntityImpDAO;

import java.util.List;

import Dao.AbstractDao;
import Dao.InterfaceClass.ShareDao;
import Model.Share;

public class ShareImp extends AbstractDao<Share> implements ShareDao{

	@Override
	public Share findbyId(Integer id) {
		return super.findById(Share.class, id);
	}

	@Override
	public List<Share> FindAll() {
		return super.findAll(Share.class, false);
	}
	@Override
	public Share create(Share entity) {
		return super.create(entity);
	}
	@Override
	public Share update(Share entity) {
		return null;
	}
	@Override
	public Share delete(Share entity) {
		return null;
	}
	
}
