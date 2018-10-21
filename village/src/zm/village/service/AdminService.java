/**
 * 
 */
package zm.village.service;

import java.util.List;

import zm.village.dao.Admin;

/**
* @ClassName: AdminService.java
* @Description: 后台管理员逻辑层接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月21日 下午8:02:47 
 */
public interface AdminService {
    
	/**
	 * 
	 * @param 要选取的管理员的类型
	 * @return 返回管理员列表
	 */
	List<Admin> getByType(Integer type);
	
	/**
	 *  根据id获取相应管理员或审核员的信息
	 * @param id
	 * @return 
	 */
	Admin getById(Integer id);
	
	/**
	 * 管理员登录
	 * @param vo
	 * @return
	 */
	boolean login(Admin vo);
	
	/**
	 * 修改信息
	 * @param vo
	 * @return
	 */
	int changeSelect(Admin vo);
	
	/**
	 *  删除信息  
	 * @param id 
	 * @return
	 */
	int deleteMany(Integer[] id);
	
	/**
	 * 增加信息
	 * @param vo
	 * @return
	 */
	int addAdmin(Admin vo);
}
