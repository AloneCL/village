package zm.village.ssm.mapper;

import zm.village.dao.LandInf;

public interface LandInfMapper {
    int deleteByPrimaryKey(Integer landId);

    int insert(LandInf record);

    int insertSelective(LandInf record);

    LandInf selectByPrimaryKey(Integer landId);

    int updateByPrimaryKeySelective(LandInf record);

    int updateByPrimaryKeyWithBLOBs(LandInf record);

    int updateByPrimaryKey(LandInf record);
}