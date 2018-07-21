package zm.village.ssm.mapper;

import zm.village.dao.Breed;

public interface RelBreedInfMapper {
    int deleteByPrimaryKey(Integer relBreedId);

    int insert(Breed record);

    int insertSelective(Breed record);

    Breed selectByPrimaryKey(Integer relBreedId);

    int updateByPrimaryKeySelective(Breed record);

    int updateByPrimaryKey(Breed record);
}