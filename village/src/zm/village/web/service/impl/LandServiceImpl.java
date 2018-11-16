package zm.village.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.village.dao.Land;
import zm.village.service.LandService;
import zm.village.web.mapper.LandInfMapper;

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

	@Override
	public Land getById(Integer record) {
		
		return mapper.selectByPrimaryKey(record);
	}

	@Override
	public int deleteMany(Integer[] record) {
		for (int i : record) {
			mapper.deleteByPrimaryKey(i);
		}
		return record.length;
	}

	@Override
	public int delete(Integer record) {
		
		return mapper.deleteByPrimaryKey(record);
	}

	@Override
	public List<Land> getByuserId(Integer record) {
		
		return mapper.getByUserId(record);
	}

	@Override
	public List<Land> getByType(Integer type) {
		
		return mapper.getByType(type);
	}
	
       
}
