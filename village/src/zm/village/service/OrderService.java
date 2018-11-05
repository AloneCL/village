package zm.village.service;

import java.util.List;

import zm.village.dao.Order;

/**
 * @ClassName: OrderService.java
 * @Description: 订单服务层
 * @version: v1.0.0
 * @author: 陈光磊
 * @date: 2018年7月13日 下午5:13:40
 */
public interface OrderService {

	// 获取所有订单
	List<Order> getAll();

	// 根据订单id获取单个订单详细信息
	Order getById(int id);

	// 根据订单编号查询订单
	Order getByUUId(String uuid);

	// 插入订单
	Order insert(Order vo);
}
