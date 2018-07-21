package zm.village.ssm.mapper;

import zm.village.dao.RelBreedInf;

public interface RelBreedInfMapper {
    int deleteByPrimaryKey(Integer relBreedId);

    int insert(RelBreedInf record);

    int insertSelective(RelBreedInf record);

    RelBreedInf selectByPrimaryKey(Integer relBreedId);

    int updateByPrimaryKeySelective(RelBreedInf record);

    int updateByPrimaryKey(RelBreedInf record);
}