package zm.village.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import zm.village.service.LandService;

/**
* @ClassName: LandController.java
* @Description: 土地安卓端控制层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月19日 上午9:43:53 
 */

@Controller
public class LandController {
    
	@Autowired
	private LandService service;
}
