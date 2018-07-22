/**
 * 
 */
package zm.village.service;

import java.util.List;

import zm.village.dao.Collect;

/**
* @ClassName: CollectService.java
* @Description: 用户收藏类逻辑层接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月22日 下午5:37:01 
 */
public interface CollectService {
     
	/**
	 * 根据收藏id删除收藏关系
	 * @param collectId 收藏的主键id
	 * @return 删除信息条数
	 */
    int deleteMany(Integer[] Id);
    
    /**
     * 增加收藏
     * @param record  
     * @return
     */
    int addCollect(Collect record);
    
    /**
     * 根据id选择具体收藏
     * @param collectId  主键
     * @return
     */
    Collect getInfo(Integer collectId);
    
    /**
     * 查看所有用户收藏信息
     * @return  返回所有信息列表
     */
    List<Collect> getAll();
    
    /**
     * 
     * @return
     */
    List<Collect> getByUserId(Integer userId);
    
    /**
     * 修改收藏信息
     * @param record  修改的完整信息
     * @return 执行结果
     */
    int update(Collect record);
}
