package zm.village.ssm.mapper;

import zm.village.dao.LabelInf;

public interface LabelInfMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(LabelInf record);

    int insertSelective(LabelInf record);

    LabelInf selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(LabelInf record);

    int updateByPrimaryKey(LabelInf record);
}