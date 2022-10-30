package Dao.EntityImpDAO;

import java.util.List;

import Dao.AbstractDao;
import Dao.InterfaceClass.UserDao;
import Model.User;

public class UserImp extends AbstractDao<User> implements UserDao{
	@Override
	public User findByID(Integer id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String query = "Select o from User o where o.email = ?0";
		return super.finOne(User.class, query, email);
	}

	@Override
	public User findByUsername(String username) {
		String query = "Select o from User o where o.id = ?0";
		return super.finOne(User.class, query, username);
	}

	@Override
	public User login(String user, String pass) {
		String query = "Select o from User o where o.id =?0 and o.password=?1 and o.active = true";
		try {
		User userx = super.finOne(User.class, query, user,pass);
		return userx;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public User resetPass(String email) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, false);
	}

	@Override
	public List<User> findAll(int PageNumber, int PageSize) {
		return super.findAll(User.class, false, PageNumber, PageSize);
	}

	@Override
	public User create(String username, String Password, String Email, String Fullname) {
		User newuser = new User();
		newuser.setId(username);
		newuser.setPassword(Password);
		newuser.setEmail(Email);
		newuser.setFullname(Fullname);
		newuser.setAdmin(false);
		newuser.setActive(true);
		return super.create(newuser);
	}

	@Override
	public User delete(String Username) {
		String queryfind = "select o from User o where o.id = ?0";
		User usz = super.finOne(User.class, queryfind, Username);
		usz.setActive(false);
		return super.update(usz);
	}

	@Override
	public List<User> findAllisActive() {
		return super.findAll(User.class,true);
	}

	@Override
	public User update(User entity) {
		return super.update(entity);
	}

	

}
