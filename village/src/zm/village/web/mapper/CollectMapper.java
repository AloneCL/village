package zm.village.web.mapper;

import java.util.List;

import zm.village.dao.Collect;

/**
* @ClassName: CollectMapper.java
* @Description: 用户收藏数据库映射mapper接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午11:12:21 
 */
public interface CollectMapper {
	
	/**
	 * 根据收藏id删除收藏关系
	 * @param collectId
	 * @return
	 */
    int deleteByPrimaryKey(Integer collectId);
    
    /**
     * 增加收藏
     * @param record 
     * @return
     */
    int insert(Collect record);
    int insertSelective(Collect record);
    
    /**
     * 根据id选择具体收藏
     * @param collectId
     * @return
     */
    Collect selectByPrimaryKey(Integer collectId);
    
    /**
     * 查看所有用户收藏信息
     * @return
     */
    List<Collect> selectAll();
    
    /**
     * 根据用户id查找用户收藏
     * @param userid
     * @return
     */
    List<Collect> selectByUserId(Integer userid);
    
    /**
     * 修改收藏信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Collect record);
    int updateByPrimaryKey(Collect record);
}