package zm.village.web.mapper;

import java.util.List;

import zm.village.dao.LabelDir;

/**
* @ClassName: LabelDirMapper.java
* @Description: 标签数据字典类数据库映射接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午11:39:15 
 */
public interface LabelDirMapper {
	
	/**
	 * 查找所有的数据
	 * @return
	 */
	List<LabelDir> selectAll();
	
 	
	/**
	 * 根据主键删除数据字典中数据
	 * @param relLabelId 主键id
	 * @return
	 */
    int deleteByPrimaryKey(Integer relLabelId);
    
    /**
     * 插入新数据
     * @param record
     * @return
     */
    int insertSelective(LabelDir record);
    
    /**
     * 根据相应主键id选择到具体数据
     * @param relLabelId  主键id
     * @return
     */
    LabelDir selectByPrimaryKey(Integer relLabelId);
    
    /**
     * 根据主键id修改具体数据信息
     * @param record LabelDir更新信息
     * @return
     */
    int updateByPrimaryKeySelective(LabelDir record);
}