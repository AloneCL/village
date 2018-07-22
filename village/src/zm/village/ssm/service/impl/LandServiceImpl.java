package zm.village.ssm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.village.dao.Land;
import zm.village.service.LandService;
import zm.village.ssm.mapper.LandInfMapper;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 土地服务层实现类
 * @version 1.0
 */

@Service
public class LandServiceImpl implements LandService {
    
	@Autowired
	private LandInfMapper mapper;

	@Override
	public int delete(Land record) {
		
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int insert(Land record) {
		
		return mapper.insertSelective(record);
	}

	@Override
	public List<Land> selectAll() {
		
		return mapper.selectAll();
	}

	@Override
	public Land select(Land record) {
		
		return mapper.selectByPrimaryKey(record.getId());
	}

	@Override
	public int update(Land record) {
		
		return mapper.updateByPrimaryKeySelective(record);
	}
	
       
}
