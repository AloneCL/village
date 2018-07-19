package zm.village.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zm.village.dao.Land;
import zm.village.service.LandService;
import zm.village.ssm.mapper.LandMapper;

/**
* @ClassName: LandServiceImpl.java
* @Description: 土地服务层实现类
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月13日 下午5:45:19 
 */

@Service
public class LandServiceImpl implements LandService {
    
	@Autowired
	private LandMapper mapper; 
	
	@Override
	public List<Land> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Land getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Land update(Land land) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Land insert(Land land) {
		// TODO Auto-generated method stub
		return null;
	}
       
}
