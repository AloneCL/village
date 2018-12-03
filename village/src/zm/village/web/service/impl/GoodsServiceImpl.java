package zm.village.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zm.village.dao.Goods;
import zm.village.service.GoodsService;
import zm.village.web.mapper.GoodsInfMapper;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsInfMapper mapper;

	@Override
	public int insert(Goods record) {
		
		return mapper.insert(record);
	}

	@Override
	public int update(Goods record) {
		
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public Goods select(Integer id) {
		
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Goods> getByType(Integer type) {
		
		return mapper.getByType(type);
	}

	@Override
	public int delete(Integer id) {
		
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Goods> getByTypePrice(Integer type) {
		
		return mapper.getByTypePrice(type);
	}

}
