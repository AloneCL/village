package zm.village.mapper;

import java.util.List;

import zm.village.dao.Label;

/**
* @ClassName: LabelMapper.java
* @Description: 标签类数据库接口映射
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午11:47:13 
 */
public interface LabelMapper {
	/**
	 * 根据数据主键删除主键
	 * @param labelId
	 * @return
	 */
    int deleteByPrimaryKey(Integer labelId);
    
    /**
     * 插入新纪录
     * @param record
     * @return
     */
    int insertSelective(Label record);
    
    /**
     * 根据数据记录选择具体数据
     * @param labelId
     * @return
     */
    Label selectByPrimaryKey(Integer labelId);
    
    /**
     * 遍历所有数据记录
     * @return
     */
    List<Label> selectAll();
    
    /**
     * 根据评论id查询某一评论的所有标签
     * @return evaid 评论id
     * @return
     */
    List<Label> selectByEvaId(Integer evaid);
}