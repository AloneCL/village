package zm.village.ssm.mapper;

import zm.village.dao.EvaInf;
import zm.village.dao.EvaInfWithBLOBs;

public interface EvaInfMapper {
    int deleteByPrimaryKey(Integer evaId);

    int insert(EvaInfWithBLOBs record);

    int insertSelective(EvaInfWithBLOBs record);

    EvaInfWithBLOBs selectByPrimaryKey(Integer evaId);

    int updateByPrimaryKeySelective(EvaInfWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EvaInfWithBLOBs record);

    int updateByPrimaryKey(EvaInf record);
}