package zm.village.web.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import zm.village.dao.Admin;

/**
* @ClassName: AdminMapper.java
* @Description: 管理员数据库映射mapper接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午10:47:00 
 */

@Repository
public interface AdminMapper {
	
	/**
	 * 
	 * @param type 管理员类型（超管、审核员）
	 * @return  返回选取类型的所有列表
	 */
	List<Admin> selectByType(Integer type);
	/**
	 * 根据主键id选择相应的管理员
	 * @param id  管理员id
	 * @return
	 */
	Admin selectByPrimaryKey(Integer id);
	/**
	 * 新增管理员
	 * @param record
	 * @return 
	 */
    int insertSelective(Admin record);
    /**
     * 修改管理员信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Admin record);
    
    /**
     * 根据管理员账号获取相应信息
     * @param name 
     * @return
     */
    Admin selectByUsername(Map<String,String> map);
    
    /**
     * 删除信息
     * @param id
     * @return 
     */
    int deleteByPrimaryKey(Integer id);
}