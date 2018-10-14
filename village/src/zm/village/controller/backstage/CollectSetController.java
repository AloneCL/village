/**
 * 
 */
package zm.village.controller.backstage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zm.village.dao.Collect;
import zm.village.service.CollectService;

/**
* @ClassName: CollectSetController.java
* @Description: 用户收藏类后台管理控制层
* @version: v1.0.0
* @author: 陈光�?
* @date: 2018�?7�?24�? 下午3:01:03 
 */
@Controller
public class CollectSetController implements BackstageConstant {
    
	@Autowired
	private CollectService service;
	
	@RequestMapping(value="/showCollect")
    public String showCollect(Model model) {
    	List<Collect> collect = new ArrayList<>();
    	collect = service.getAll();
    	model.addAttribute(ATTRIBUTE_COLLECT_LIST, collect);
    	model.addAttribute(ATTRIBUTE_COLLECT_LIST_SIZE, collect.size());
		return "/backer/collect.jsp";
    }
	
	@RequestMapping(value="/deleteCollect")
	public String deleteCollect(Model model,Integer[] id) {
		service.deleteMany(id);
		return showCollect(model);
	}
	
	@RequestMapping(value="/addCollect")
	public void addCollect(Model model,Collect vo) {
		service.addCollect(vo);
	}
	
	@RequestMapping(value="/editCollect")
	public String editCollect(Model model,Integer id) {
		Collect cl = service.getInfo(id);
		model.addAttribute(ATTRIBUTE_COLLECT_LIST, cl);
		return "/backer/editCollect.jsp";
	}
	
	@RequestMapping(value="/submitEditCollect")
	public String submitEditCollect(Model model,Collect vo) {
		service.update(vo);
		return showCollect(model);
	}
}
