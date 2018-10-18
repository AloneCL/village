package zm.village.web.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import zm.village.dao.Crop;


/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 土地可种植作物mybatis数据库映射Dao层
 * @version 1.0
 */
@Repository
public interface RelLandInfMapper {
    /**
     * @param 土地可种植作物ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(Integer relLandId);

    /**
     * @param 土地可种植作物信息
     * @return 插入的主键
     */
    int insertSelective(Crop record);

    /**
     * @param 土地可种植作物ID
     * @return 作物信息
     */
    Crop selectByPrimaryKey(Integer relLandId);
    
    /**
     * @param 土地ID
     * @return 作物信息数组
     */
    List<Crop> selectByLand(Integer landId);

    /**
     * @param 土地可种植作物信息ID
     * @return 更新的行数
     */
    int updateByPrimaryKeySelective(Crop record);
    
    /**
     * @return 土地可种植作物信息列表
     */
    List<Crop> selectAll();

}