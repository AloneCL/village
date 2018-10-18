package zm.village.web.controller.backstage;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	/**
	 * 展示所有的评价信息
	 */
	@RequestMapping("showEvaluate")
	public String showEvaluate(Model model) {
		List<Evaluate> list = service.getAll();
		if(list == null)
			list = Collections.emptyList();
		
		model.addAttribute(ATTRIBUTE_EVALUATE_LIST, list);
		model.addAttribute(ATTRIBUTE_EVALUATE_LIST_SIZE, list.size());
		return "/backer/evaluate.jsp";
	}
	
	/**
	 * 检索评价信息
	 * @param request 包含起始时间、结束时间或用户ID或评价星级
	 */
	@RequestMapping("searchEvaluate")
	public String searchEvaluate(Model model, HttpServletRequest request) {
		
		String startTime = request.getParameter(ATTRIBUTE_EVALUATE_START_TIME);
		if(startTime.equals(""))
			startTime = null;
		
		String endTime = request.getParameter(ATTRIBUTE_EVALUATE_END_TIME);
		if(endTime.equals(""))
			endTime = null;
		
		String userIdStr = request.getParameter(ATTRIBUTE_EVALUATE_USER_ID);
		String starStr = request.getParameter(ATTRIBUTE_EVALUATE_STAR);
		
		boolean flag = false;	
		Integer userId = null, star = null;
		
		try {
			userId = userIdStr.equals("") ? null : Integer.valueOf(userIdStr);
			star = starStr.equals("") ? null : Integer.valueOf(starStr);
		} catch(NumberFormatException e) {
			flag = true;
			model.addAttribute(ATTRIBUTE_EVALUATE_NOTICE, "数据格式有误");
		}
		
		List<Evaluate> list;
		if(flag) {
			list = service.getAll();
		} else {
			list = service.getWithRoles(startTime, endTime, userId, star);
		}
		
		if(list == null)
			list = Collections.emptyList();
		
		model.addAttribute(ATTRIBUTE_EVALUATE_LIST, list);
		model.addAttribute(ATTRIBUTE_EVALUATE_LIST_SIZE, list.size());
		return "/backer/evaluate.jsp";
	}
	
}
