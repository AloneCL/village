package zm.village.mapper;

import zm.village.dao.Evaluate;

public interface EvaInfMapper {
    int deleteByPrimaryKey(Integer evaId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer evaId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKeyWithBLOBs(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
}