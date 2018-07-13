package zm.village.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zm.village.dao.Order;

@Repository
public interface OrderMapper {
    
	//获取订单列表
	List<Order> selectAll();
	//根据主键id获取订单信息
	Order selectByPrimaryKey(Integer id);
	//根据订单编号获取订单信息
	Order selectByUUId(String uuid);
	//插入订单
	int insert(Order vo);
	//更新订单信息
	int updateByPrimaryKey(Order vo);
	//根据用户电话号码查询用户所有订单记录
	List<Order> selectByTel(String tel);
	//根据主键id删除订单
	int deleteByprimaryKey(Integer id);
}
