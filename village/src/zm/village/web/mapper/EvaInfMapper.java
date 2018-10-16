package zm.village.web.mapper;

import java.util.List;

import zm.village.dao.Evaluate;

public interface EvaInfMapper {
	
	/**
	 * 查询所有的评价信息，不包含评价内容
	 * @return List集合
	 */
    List<Evaluate> selectAll();
    
    /**
     * 查询所有的评价信息，包含评价内容
     * @return List集合
     */
    List<Evaluate> selectAllWithDetail();
    
    /**
     * 根据用户ID获取他给出的所有评价，不包括评价内容
     * @param id 用户ID
     * @return 所有评价的List集合
     */
    List<Evaluate> selectByUserId(Integer id);
    
    /**
     * 根据用户ID获取他给出的所有评价
     * @param id 用户ID
     * @return 所有评价的List集合
     */
    List<Evaluate> selectByUserIdWithDetail(Integer id);
    
    /**
	 * 通过主键删除评价信息
	 * @param evaId 主键ID
	 * @return 实际删除条数
	 */
    int deleteByPrimaryKey(Integer evaId);
    
    /**
     * 插入评价信息
     * @param record 评价信息对象
     * @return 插入的条数
     */
    int insertSelective(Evaluate record);

    /**
     * 通过主键ID查找评价信息
     * @param evaId 主键ID
     * @return 评价对象
     */
    Evaluate selectByPrimaryKey(Integer evaId);

    /**
     * 更新评价信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Evaluate record);

}