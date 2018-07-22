package zm.village.service;

import java.util.List;

import zm.village.dao.Crop;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 土地可种植作物服务层
 * @version 1.0
 */

public interface RelLandService {

	 /**
     * @param 土地可种植作物ID
     * @return 删除的行数
     */
    int delete(Crop record);

    /**
     * @param 土地可种植作物信息
     * @return 插入的主键
     */
    int insert(Crop record);

    /**
     * @param 土地可种植作物ID
     * @return 作物信息
     */
    Crop select(Crop record);

    /**
     * @param 土地可种植作物信息ID
     * @return 更新的行数
     */
    int update(Crop record);
    
    /**
     * @return 土地可种植作物信息列表
     */
    List<Crop> selectAll();
}
