package zm.village.web.controller.backstage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zm.village.dao.Breed;
import zm.village.service.RelBreedService;

/**
 * @author 伍伴
 * @Date 2018年7月22日
 * @Description 养殖类后端页面控制层
 * @version 1.0
 */
@Controller
public class RelBreedSetController {

	@Autowired
	private RelBreedService service;

	@RequestMapping(value = "/setBreed")
	public String diary(Model model) {

		model.addAttribute("breeds", service.selectAll());
		return "/backer/breed.jsp";
	}

	@RequestMapping(value = "/editBreed")
	public String edit(Model model, Integer id) {

		model.addAttribute("breed", service.getById(id));
		return "/backer/breedSet.jsp";
	}

	@RequestMapping("/submitEditBreed")
	public String submitEdit(Model model, Breed vo) {

		return "/backer/addBreed.jsp";
	}

	@RequestMapping(value = "/addBreed")
	public String add(Model model, Breed vo) {

		System.out.println(vo);
		//service.insert(vo);
		return diary(model);
	}

	@RequestMapping("/modifyBreed")
	public String modify(Model model, Breed vo) {

		System.out.println(vo);
		//service.update(vo);
		return edit(model, vo.getId());
	}
	
	@RequestMapping("/deleteBreed")
	public String deleteDiary(Model model, Integer id){
		
		System.out.println(id);
		//service.delete(id);
		return diary(model);
	}

	@RequestMapping("/deleteManyBreed")
	public String deleteManyBreed(Model model, Integer[] id) {
		if (id != null) {
			for (Integer i : id) {
				System.out.println(i);
			}
			//service.deleteMany(id);
		}
		return diary(model);
	}
}
