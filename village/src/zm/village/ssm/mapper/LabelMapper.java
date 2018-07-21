package zm.village.ssm.mapper;

import zm.village.dao.Label;

/**
* @ClassName: LabelMapper.java
* @Description: 标签类数据库接口映射
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午11:47:13 
 */
public interface LabelMapper {
    int deleteByPrimaryKey(Integer labelId);

    int insert(Label record);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}