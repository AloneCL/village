package zm.village.ssm.mapper;

import zm.village.dao.CollectInf;

public interface CollectInfMapper {
    int deleteByPrimaryKey(Integer collectId);

    int insert(CollectInf record);

    int insertSelective(CollectInf record);

    CollectInf selectByPrimaryKey(Integer collectId);

    int updateByPrimaryKeySelective(CollectInf record);

    int updateByPrimaryKey(CollectInf record);
}