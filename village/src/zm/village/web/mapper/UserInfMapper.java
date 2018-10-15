package zm.village.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zm.village.dao.User;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 用户mybatis数据库映射Dao层
 * @version 1.0
 */

@Repository
public interface UserInfMapper {
	
	
    /**
     * @param 用户ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(Integer userId);

    /**
     * @param 用户信息ID
     * @return 新插入行的主键
     */
    int insertSelective(User record);

    /**
     * @param 用户ID
     * @return 用户信息
     */
    User selectByPrimaryKey(Integer userId);
    
    
    /**
     * @return 用户信息列表
     */
    List<User> selectAll();

    /**
     * @param 用户信息ID
     * @return 更新的行数
     */
    int updateByPrimaryKeySelective(User record);
    
    /**
     * @param 用户账号和密码
     * @return 用户信息
     */
    User login(User record);
    
    /**
     * @param 用户手机号码
     * @return 用户信息
     */
    User getByUserTel(String telephone);
    
    /**
     * @param 用户信息手机号码
     * @return 更新行数
     */
    int updateByUserTel(User record);

}