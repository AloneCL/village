package zm.village.ssm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zm.village.dao.Order;
import zm.village.service.OrderService;
import zm.village.ssm.mapper.OrderMapper;

/**
* @ClassName: OrderServiceImpl.java
* @Description: 订单服务实现层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月19日 上午9:26:05 
 */

@Service
public class OrderServiceImpl implements OrderService {
    
	@Autowired
	private OrderMapper mapper;
	
	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getByUUId(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order insert(Order vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
