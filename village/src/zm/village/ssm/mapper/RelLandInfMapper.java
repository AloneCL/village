package zm.village.ssm.mapper;

import zm.village.dao.Crop;

public interface RelLandInfMapper {
    int deleteByPrimaryKey(Integer relLandId);

    int insert(Crop record);

    int insertSelective(Crop record);

    Crop selectByPrimaryKey(Integer relLandId);

    int updateByPrimaryKeySelective(Crop record);

    int updateByPrimaryKey(Crop record);
}