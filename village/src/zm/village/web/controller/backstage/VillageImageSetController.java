package zm.village.web.controller.backstage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zm.village.dao.VillageImage;
import zm.village.service.VillageImageService;

/**
 * @author 伍伴
 * @Date 2018年7月22日
 * @Description 轮播图类后端页面控制层
 * @version 1.0
 */
@Controller
public class VillageImageSetController {
	private final VillageImageService  service;

	@Autowired
	public VillageImageSetController(VillageImageService villageImageService) {
		this.service = villageImageService;
	}
	
	@RequestMapping(value = "/setVillageImage")
	public String diary(Model model){

		model.addAttribute("villageImages", service.getInfo());
		return "/backer/villageImage.jsp";
	}

	

	@RequestMapping("/modifyVillageImage")
	public String modify(Model model, VillageImage vo){
		
		service.update(vo);
		return diary(model);
	}

}
