package zm.village.ssm.mapper;

import zm.village.dao.RelLabelInf;

public interface RelLabelInfMapper {
    int deleteByPrimaryKey(Integer relLabelId);

    int insert(RelLabelInf record);

    int insertSelective(RelLabelInf record);

    RelLabelInf selectByPrimaryKey(Integer relLabelId);

    int updateByPrimaryKeySelective(RelLabelInf record);

    int updateByPrimaryKey(RelLabelInf record);
}