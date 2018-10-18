package zm.village.web.mapper;

import zm.village.dao.VillageImage;
import org.springframework.stereotype.Repository;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 轮播图mybatis数据库映射Dao层
 * @version 1.0
 */
@Repository
public interface VillageImageMapper {

	VillageImage select();
	
	int updateByPrimaryKeySelective(VillageImage record);

}