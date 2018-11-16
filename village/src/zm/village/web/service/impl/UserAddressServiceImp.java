package zm.village.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.village.dao.UserAddress;
import zm.village.service.UserAddressService;
import zm.village.web.mapper.UserAddressMapper;

@Service
public class UserAddressServiceImp implements UserAddressService{

	@Autowired
	private UserAddressMapper mapper;
	
	@Override
	public int delete(Integer record) {
		
		return mapper.deleteByPrimaryKey(record);
	}

	@Override
	public int insert(UserAddress record) {
		
		return mapper.insertSelective(record);
	}

	@Override
	public UserAddress select(Integer record) {
		
		return mapper.selectByPrimaryKey(record);
	}

	@Override
	public List<UserAddress> getByUser(Integer record) {
		
		return mapper.getByUser(record);
	}

	@Override
	public int update(UserAddress record) {
		
		return mapper.updateByPrimaryKeySelective(record);
	}

}
