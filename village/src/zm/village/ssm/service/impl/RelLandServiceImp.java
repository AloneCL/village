package zm.village.ssm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.village.dao.Crop;
import zm.village.service.RelLandService;
import zm.village.ssm.mapper.RelLandInfMapper;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 土地可种植类服务实现层
 * @version 1.0
 */


@Service
public class RelLandServiceImp implements RelLandService{
	
	@Autowired
	private RelLandInfMapper mapper;

	@Override
	public int delete(Crop record) {
		
		return mapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int insert(Crop record) {
		
		return mapper.insertSelective(record);
	}

	@Override
	public Crop select(Crop record) {
		
		return mapper.selectByPrimaryKey(record.getId());
	}

	@Override
	public int update(Crop record) {
		
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Crop> selectAll() {
		
		return mapper.selectAll();
	}
	

	
}
