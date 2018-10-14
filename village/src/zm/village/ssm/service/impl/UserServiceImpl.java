package zm.village.ssm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.village.dao.User;
import zm.village.service.UserService;
import zm.village.ssm.mapper.UserInfMapper;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 用户功能服务实现层
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserInfMapper mapper;
	
	@Override
	public List<User> selectAll() {
		
		return mapper.selectAll();
	}

	@Override
	public boolean login(User vo) {
		if(mapper.login(vo)!=null)
		return true;
		return false;
	}

	@Override
	public int update(User vo) {
		
		return mapper.updateByPrimaryKeySelective(vo);
	}

	@Override
	public User getByUserTel(User record) {
		
		return mapper.getByUserTel(record.getTelephone());
	}

	@Override
	public int updateByUserTel(User record) {
		
		return mapper.updateByUserTel(record);
	}

	@Override
	public int delete(User record) {
		
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int insert(User record) {
		
		return mapper.insertSelective(record);
	}

	@Override
	public User select(User record) {
		
		return mapper.selectByPrimaryKey(record.getId());
	}

	@Override
	public int deleteMany(Integer[] record) {
		for(int i : record){
			mapper.deleteByPrimaryKey(i);
		}
		return record.length;
	}

	@Override
	public User getById(Integer record) {
		
		return mapper.selectByPrimaryKey(record);
	}

	@Override
	public int delete(Integer record) {
		return mapper.deleteByPrimaryKey(record);
	}

}
