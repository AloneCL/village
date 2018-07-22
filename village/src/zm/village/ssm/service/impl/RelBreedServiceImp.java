package zm.village.ssm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.village.dao.Breed;
import zm.village.service.RelBreedService;
import zm.village.ssm.mapper.RelBreedInfMapper;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 养殖类服务实现层
 * @version 1.0
 */

@Service
public class RelBreedServiceImp implements RelBreedService{

	@Autowired
	private RelBreedInfMapper mapper;
	
	
	@Override
	public int delete(Breed record) {
		
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int insert(Breed record) {
		
		return mapper.insertSelective(record);
	}

	@Override
	public Breed select(Breed record) {
		
		return mapper.selectByPrimaryKey(record.getId());
	}

	@Override
	public int update(Breed record) {
		
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Breed> selectAll() {
		
		return mapper.selectAll();
	}

}
