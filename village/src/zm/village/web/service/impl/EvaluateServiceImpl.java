package zm.village.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zm.village.dao.Evaluate;
import zm.village.service.EvaluateService;
import zm.village.web.mapper.EvaInfMapper;


/**
* @author 李子帆
* @version 1.0
* @date 2018年10月16日 下午3:37:20
* @Description 评价服务层实现类
*/
@Service
public class EvaluateServiceImpl implements EvaluateService {
	
	@Autowired private EvaInfMapper mapper;

	@Override
	public int addOne(Evaluate evaluate) {
		return mapper.insertSelective(evaluate);
	}

	@Override
	public int deleteOne(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Evaluate getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Evaluate> getAll() {
		return mapper.selectAll();
	}

	@Override
	public List<Evaluate> getByUserId(Integer userId) {
		return mapper.selectByUserId(userId);
	}
	
	@Override
	public List<Evaluate> getByUserIdWithDetail(Integer userId) {
		return mapper.selectByUserIdWithDetail(userId);
	}

	@Override
	public int updateOne(Evaluate evaluate) {
		return mapper.updateByPrimaryKeySelective(evaluate);
	}

	@Override
	public List<Evaluate> getAllWithDetail() {
		return mapper.selectAllWithDetail();
	}

}
