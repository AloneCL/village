package zm.village.ssm.mapper;

import zm.village.dao.Label;

public interface RelLabelInfMapper {
    int deleteByPrimaryKey(Integer relLabelId);

    int insert(Label record);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Integer relLabelId);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}