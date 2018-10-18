package zm.village.service;

import zm.village.dao.VillageImage;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 轮播图管理服务层
 * @version 1.0
 */
public interface VillageImageService {

	/**
     * 获得轮播图路径
     * 
     */
	VillageImage getInfo();
	
	/**
     * @param 轮播图类
     * @return 更新的行数
     */
	int update(VillageImage vo);
	
}
