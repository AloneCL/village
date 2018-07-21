package zm.village.ssm.mapper;

import zm.village.dao.OrderSon;

public interface OrdersonInfMapper {
    int deleteByPrimaryKey(Integer ordersonId);

    int insert(OrderSon record);

    int insertSelective(OrderSon record);

    OrderSon selectByPrimaryKey(Integer ordersonId);

    int updateByPrimaryKeySelective(OrderSon record);

    int updateByPrimaryKey(OrderSon record);
}