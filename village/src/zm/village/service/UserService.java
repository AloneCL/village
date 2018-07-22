package zm.village.service;

import java.util.List;

import zm.village.dao.User;


/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 用户管理服务层
 * @version 1.0
 */
public interface UserService {
    
	/**
     * @param 用户ID
     * @return 删除的行数
     */
    int delete(User record);

    /**
     * @param 用户信息ID
     * @return 新插入行的主键
     */
    int insert(User record);

    /**
     * @param 用户ID
     * @return 用户信息
     */
    User select(User record);
    
    
    /**
     * @return 用户信息列表
     */
    List<User> selectAll();

    /**
     * @param 用户信息ID
     * @return 更新的行数
     */
    int update(User record);
    
    /**
     * @param 用户账号和密码
     * @return 用户信息
     */
    boolean login(User record);
    
    /**
     * @param 用户手机号码
     * @return 用户信息
     */
    User getByUserTel(User record);
    
    /**
     * @param 用户信息手机号码
     * @return 更新行数
     */
    int updateByUserTel(User record);
    
    
}
