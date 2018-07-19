package zm.village.ssm.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import zm.village.service.UserService;

/**
* @ClassName: UserSetController.java
* @Description: 用户类前端页面控制层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月19日 上午9:41:48 
 */

@Controller
public class UserSetController {
   
	@Autowired 
	private UserService service;
	
}
