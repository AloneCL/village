package zm.village.ssm.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import zm.village.service.UserService;

/**
 * @author 伍伴
 * @Date 2018年7月22日
 * @Description 用户类后端页面控制层
 * @version 1.0
 */
@Controller
public class UserSetController {
   
	@Autowired 
	private UserService service;
	
}
