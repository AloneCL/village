package zm.village.ssm.mapper;

import zm.village.dao.Admin;

/**
* @ClassName: AdminMapper.java
* @Description: 管理员数据库映射mapper接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 上午10:47:00 
 */
public interface AdminMapper {
	
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
    Admin selectByUsername(String name);
}