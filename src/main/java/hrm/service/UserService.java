package hrm.service;

import java.util.List;

import hrm.domain.User;

/**
 * 用户的业务逻辑功能
 * @author www
 *
 */
public interface UserService {
	/**
	 * 用户登录功能
	 * @param loginname
	 * @param passwod
	 * @reurn User对象
	 */
	User login(String loginname,String password);
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @reurn User对象
	 */
	User findUserById(Integer id);
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	void removeUserWithId(Integer id);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void modifyUser(User user);
	
	/**
	 * 添加 用户
	 * @param user
	 */
	void addUser(User user);
	
	/**
	 * 用户查询所有用户
	 * @return User对象的List集合
	 */
	/*List<User> fingAllUser(User user);*/
}
