package zm.village.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zm.village.dao.User;
import zm.village.service.UserService;
import zm.village.ssm.mapper.UserMapper;

/**
* @ClassName: UserServiceImpl.java
* @Description: 用户功能服务实现层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月19日 上午9:37:56 
 */
@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(User vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateSelect(User vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
