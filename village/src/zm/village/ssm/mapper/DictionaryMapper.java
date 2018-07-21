package zm.village.ssm.mapper;

import zm.village.dao.Dictionary;

/**
* @ClassName: DictionaryMapper.java
* @Description: 数据字典类数据库映射接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午11:46:46 
 */
public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer dirId);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer dirId);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKeyWithBLOBs(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
}