package zm.village.ssm.mapper;

import zm.village.dao.OrderInf;

public interface OrderInfMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderInf record);

    int insertSelective(OrderInf record);

    OrderInf selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderInf record);

    int updateByPrimaryKey(OrderInf record);
}