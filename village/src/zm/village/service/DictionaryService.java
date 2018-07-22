/**
 * 
 */
package zm.village.service;

import java.util.List;

import zm.village.dao.Dictionary;

/**
* @ClassName: DictionaryService.java
* @Description: 数据字典类逻辑层接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月22日 下午7:55:06 
 */
public interface DictionaryService {
    
	/**
	 * 根据id删除记录
	 * @param dirId 数据的主键id
	 * @return 删除的记录行数
	 */
    int deleteMany(Integer[] dirId);
    
    /**
     * 插入新数据
     * @param record 增加的数据对象
     * @return
     */
    int addDictionary(Dictionary record);
    
    /**
     * 根据主键id选择记录
     * @param dirId 主键
     * @return
     */
    Dictionary getInfo(Integer dirId);
    
    /**
     * 根据作物类型查看某一类型所有数据
     * @param type 数据类型
     * @return
     */
    List<Dictionary> getByType(Integer type);
    
    /**
     * 查找所有记录
     * @return 所有数据字典中数据列表
     */
    List<Dictionary> getAll();
    
    /**
     * 根据判断主键id更新记录
     * @param record 更新的完整信息
     * @return
     */
    int update(Dictionary record);
}
