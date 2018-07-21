package zm.village.ssm.mapper;

import zm.village.dao.RelLandInf;

public interface RelLandInfMapper {
    int deleteByPrimaryKey(Integer relLandId);

    int insert(RelLandInf record);

    int insertSelective(RelLandInf record);

    RelLandInf selectByPrimaryKey(Integer relLandId);

    int updateByPrimaryKeySelective(RelLandInf record);

    int updateByPrimaryKey(RelLandInf record);
}