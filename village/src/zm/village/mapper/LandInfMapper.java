package zm.village.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zm.village.dao.Land;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 土地mybatis数据库映射Dao层
 * @version 1.0
 */

@Repository
public interface LandInfMapper {
	
    /**
     * @param 土地ID
     * @return 删除行数
     */
    int deleteByPrimaryKey(Integer landId);

    /**
     * @param 土地信息ID
     * @return 插入行的主键
     */
    int insertSelective(Land record);
    
    
    /**
     * @return 土地信息列表
     */
    List<Land> selectAll();

    /**
     * @param 土地ID
     * @return 土地信息
     */
    Land selectByPrimaryKey(Integer landId);

    /**
     * @param 土地信息ID
     * @return 更新行数
     */
    int updateByPrimaryKeySelective(Land record);

}