package zm.village.service;

import java.util.List;

import zm.village.dao.User;

/**
* @ClassName: UserService.java
* @Description: 用户管理服务层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月13日 下午5:33:09 
 */
public interface UserService {
    //获取所有用户信息
	List<User> getAll();
	
	//根据用户Id查询用户信息
	User getById(int id);
	
	//判断用户登录信息是否正确
    boolean login(User vo);
    
    //更新用户信息
    int updateSelect(User vo);
    
    //根据用户删除单个用户信息
    int deleteById(int[] id);
    
}
