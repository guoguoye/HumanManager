package hrm.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrm.domain.User;
import hrm.mapper.UserMapper;
import hrm.service.UserService;


/**
 * @author www
 * @service("userService")用于将当前类注释为一个Spring的bean，名为userService
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	/**
	 * @Autowired 自动注入UserMapper
	 *
	 */
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(readOnly=true)
	public User login(String loginname, String password) {
		// TODO Auto-generated method stub
		return userMapper.selectByLoginnameAndPassword(loginname, password);
	}

	@Transactional(readOnly=true)
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectById(id);
	}

	public void removeUserWithId(Integer id) {
		// TODO Auto-generated method stub
		userMapper.deleteById(id);
	}

	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.inser(user);
	}

	/*@Transactional(readOnly=true)
	public List<User> fingAllUser(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("user", user);
		List<User> users = userMapper.selectByPage(params);
		return users;
	}*/

}
