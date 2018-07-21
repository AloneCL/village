package zm.village.ssm.mapper;

import zm.village.dao.LabelDir;

public interface LabelInfMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(LabelDir record);

    int insertSelective(LabelDir record);

    LabelDir selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(LabelDir record);

    int updateByPrimaryKey(LabelDir record);
}