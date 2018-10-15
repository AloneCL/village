package zm.village.web.controller.backstage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zm.village.dao.Crop;
import zm.village.service.RelLandService;

/**
 * @author 伍伴
 * @Date 2018年7月22日
 * @Description 土地可种植作物后台页面控制层
 * @version 1.0
 */
@Controller
public class RelLandSetController {

	@Autowired
	private RelLandService service;

	@RequestMapping(value = "/setRelLand")
	public String diary(Model model) {

		model.addAttribute("crops", service.selectAll());
		return "/backer/crop.jsp";
	}

	@RequestMapping(value = "/editRelLand")
	public String edit(Model model, Integer id) {

		model.addAttribute("crop", service.getById(id));
		return "/backer/cropSet.jsp";
	}

	@RequestMapping("/submitEditRelLand")
	public String submitEdit(Model model, Crop vo) {

		return "/backer/addCrop.jsp";
	}

	@RequestMapping(value = "/addRelLand")
	public String add(Model model, Crop vo) {

		System.out.println(vo);
		//service.insert(vo);
		return diary(model);
	}

	@RequestMapping("/modifyRelLand")
	public String modify(Model model, Crop vo) {

		System.out.println(vo);
		//service.update(vo);
		return edit(model, vo.getId());
	}
	
	@RequestMapping("/deleteRelLand")
	public String deleteDiary(Model model, Integer id){
		
		System.out.println(id);
		//service.delete(id);
		return diary(model);
	}

	@RequestMapping("/deleteManyRelLand")
	public String deleteManyRelLand(Model model, Integer[] id) {
		if (id != null) {
			for (Integer i : id) {
				System.out.println(i);
			}
			//service.deleteMany(id);
		}
		return diary(model);
	}
}
