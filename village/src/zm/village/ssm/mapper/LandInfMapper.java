package zm.village.ssm.mapper;

import zm.village.dao.Land;

public interface LandInfMapper {
	
    int deleteByPrimaryKey(Integer landId);

    int insert(Land record);

    int insertSelective(Land record);

    Land selectByPrimaryKey(Integer landId);

    int updateByPrimaryKeySelective(Land record);

    int updateByPrimaryKeyWithBLOBs(Land record);

    int updateByPrimaryKey(Land record);
}