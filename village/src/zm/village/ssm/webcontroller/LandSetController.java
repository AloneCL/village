package zm.village.ssm.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import zm.village.service.LandService;

/**
* @ClassName: LandSetController.java
* @Description: 土地前端接口类
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月19日 上午9:15:36 
 */

@Controller
public class LandSetController {
    
	@Autowired
	private LandService landeService;
	
}
