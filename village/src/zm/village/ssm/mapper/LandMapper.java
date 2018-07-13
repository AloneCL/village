package zm.village.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zm.village.dao.Land;

/**
* @ClassName: LandMapper.java
* @Description: 土地类mybatis映射Dao层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月13日 下午5:49:32 
 */
@Repository
public interface LandMapper {
    
	//获取所有土地信息
	List<Land> selectAll();
	//根据主键Id获取相应土地
	Land selectByPrimaryKey(Integer id);
	//更新选择的土地信息
	int updateByPrimaryKey(Land vo);
	//删除土地
	int deleteByprimaryKey(int id);
}
