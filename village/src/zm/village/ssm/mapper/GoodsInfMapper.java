package zm.village.ssm.mapper;

import zm.village.dao.GoodsInf;

public interface GoodsInfMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(GoodsInf record);

    int insertSelective(GoodsInf record);

    GoodsInf selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(GoodsInf record);

    int updateByPrimaryKeyWithBLOBs(GoodsInf record);

    int updateByPrimaryKey(GoodsInf record);
}