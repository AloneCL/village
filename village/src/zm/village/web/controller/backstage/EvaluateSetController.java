package zm.village.web.controller.backstage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zm.village.dao.Evaluate;
import zm.village.service.EvaluateService;
import zm.village.web.aop.backstage.AdminPermissionController;

/**
* @author 李子帆
* @version 1.0
* @date 2018年10月16日 下午4:40:32
* @Description 类说明
*/
@Controller
@AdminPermissionController
public class EvaluateSetController implements BackstageConstant {

	@Autowired private EvaluateService service;
	
	@RequestMapping("showEvaluate")
	public String showEvaluate(Model model) {
		List<Evaluate> list = service.getAll();
		model.addAttribute(ATTRIBUTE_EVALUATE_LIST, list);
		model.addAttribute(ATTRIBUTE_EVALUATE_LIST_SIZE, list.size());
		return "/backer/evaluate.jsp";
	}
}
