package zm.village.ssm.mapper;

import java.util.List;

import zm.village.dao.User;

/**
* @ClassName: UserMapper.java
* @Description: 用户mybatis数据库映射Dao层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月13日 下午5:58:27 
 */
public interface UserMapper {
	 
	 //获取所有用户信息集
     List<User> selectAll();
     //插入新用户
     int insert(User vo);
     //根据用户账号获取用户信息
     User selectByUsername(String name);
     //根据主键id获取信息
     User selectByPrimaryKey(Integer id);
     //修改用户信息根据主键Id
     int updateByPrimaryKey(User vo);
     //根据主键删除用户
     int deleteByprimaryKey(Integer id);
     
}
