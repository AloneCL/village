package zm.village.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import zm.village.service.LandService;


/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 安卓前端土地控制层
 * @version 1.0
 */
@Controller
public class LandController {
    
	@Autowired
	private LandService service;
}
