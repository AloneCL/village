package zm.village.ssm.mapper;

import zm.village.dao.OrdersonInf;

public interface OrdersonInfMapper {
    int deleteByPrimaryKey(Integer ordersonId);

    int insert(OrdersonInf record);

    int insertSelective(OrdersonInf record);

    OrdersonInf selectByPrimaryKey(Integer ordersonId);

    int updateByPrimaryKeySelective(OrdersonInf record);

    int updateByPrimaryKey(OrdersonInf record);
}