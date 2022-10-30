package Dao.InterfaceClass;

import java.util.List;

import Model.User;

public interface UserDao {
	User findByID(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User login(String user , String pass);
	User resetPass(String email);
	List<User> findAll();
	List<User> findAll(int PageNumber , int PageSize);
	User create(String username,String Password, String Email, String Fullname);
	User update(User entity);
	User delete(String Username);
	List<User> findAllisActive();
}
