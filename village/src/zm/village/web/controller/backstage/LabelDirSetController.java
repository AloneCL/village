/**
 * 
 */
package zm.village.web.controller.backstage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zm.village.dao.Collect;
import zm.village.dao.LabelDir;
import zm.village.service.LabelDirService;

/**
* @ClassName: CollectSetController.java
* @Description: 标签字典类后台管理控制层
* @version: v1.0.0
* @author: 陈光�?
* @date: 2018�?7�?24�? 下午3:01:03 
 */
@Controller
public class LabelDirSetController implements BackstageConstant {
    
	@Autowired
	private LabelDirService service;
	
	@RequestMapping(value="/showLabelDir")
    public String showLabelDir(Model model) {
    	List<LabelDir> ld = new ArrayList<>();
        ld = service.getAll();
    	model.addAttribute(ATTRIBUTE_LABEL_LIST, ld);
    	model.addAttribute(ATTRIBUTE_LABEL_LIST_SIZE, ld.size());
		return "/backer/labelDir.jsp";
    }
	
	@RequestMapping(value="/deleteLabelDir")
	public String deleteLabelDir(Model model,Integer[] id) {
		service.deleteMany(id);
		return showLabelDir(model);
	}
	
	@RequestMapping(value="/delLabelDir")
	public void delLabelDir(Model model,Integer id) {
		Integer[] id2 = {id};
		service.deleteMany(id2);
	}
	
	@RequestMapping(value="/addLabelDir")
	public void addLabelDir(Model model,LabelDir vo) {
		service.addLabelDir(vo);
	}
	
/*	@RequestMapping(value="/editLabelDir")
	public String editLabelDir(Model model,Integer id) {
		LabelDir cl = service.getInfo(id);
		model.addAttribute("labelDir", cl);
		return "/backer/editLabelDir.jsp";
	}*/
	
	@RequestMapping(value="/submitEditLabelDir")
	public String submitEditLabelDir(Model model,LabelDir vo) {
		service.update(vo);
		return showLabelDir(model);
	}
}
