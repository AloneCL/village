package zm.village.ssm.mapper;

import zm.village.dao.LabelDir;

/**
* @ClassName: LabelDirMapper.java
* @Description: 标签数据字典类数据库映射接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午11:39:15 
 */
public interface LabelDirMapper {
    int deleteByPrimaryKey(Integer relLabelId);

    int insert(LabelDir record);

    int insertSelective(LabelDir record);

    LabelDir selectByPrimaryKey(Integer relLabelId);

    int updateByPrimaryKeySelective(LabelDir record);

    int updateByPrimaryKey(LabelDir record);
}