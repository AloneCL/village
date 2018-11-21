package zm.village.service;

import java.util.List;

import zm.village.dao.Goods;

public interface GoodsService {

	int insert(Goods record);
	
	int update(Goods record);
	
	Goods select(Integer id);
	
	List<Goods> getByType(Integer type);
	
	int delete(Integer id);
}
