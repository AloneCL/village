/**
 * 
 */
package zm.village.service;

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
}
