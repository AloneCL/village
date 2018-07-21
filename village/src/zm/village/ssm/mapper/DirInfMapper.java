package zm.village.ssm.mapper;

import zm.village.dao.Dictionary;

public interface DirInfMapper {
    int deleteByPrimaryKey(Integer dirId);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer dirId);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKeyWithBLOBs(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}