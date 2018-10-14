package zm.village.mapper;

import java.util.List;

import zm.village.dao.Dictionary;

/**
* @ClassName: DictionaryMapper.java
* @Description: 数据字典类数据库映射接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午11:46:46 
 */
public interface DictionaryMapper {
	
	/**
	 * 根据id删除记录
	 * @param dirId 数据的主键id
	 * @return
	 */
    int deleteByPrimaryKey(Integer dirId);
    
    /**
     * 插入新数据
     * @param record
     * @return
     */
    int insertSelective(Dictionary record);
    
    /**
     * 根据主键id选择记录
     * @param dirId
     * @return
     */
    Dictionary selectByPrimaryKey(Integer dirId);
    
    /**
     * 根据作物类型查看某一类型所有数据
     * @param type 数据类型
     * @return
     */
    List<Dictionary> selectByType(Integer type);
    
    /**
     * 查找所有记录
     * @return
     */
    List<Dictionary> selectAll();
    /**
     * 根据判断主键id更新记录
     * @param record 
     * @return
     */
    int updateByPrimaryKeySelective(Dictionary record);
}