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
import org.springframework.web.bind.annotation.RequestMethod;

import zm.village.dao.Dictionary;
import zm.village.service.DictionaryService;

/**
* @ClassName: DictionarySetController.java
* @Description: 数据字典类管理控制层
* @version: v1.0.0
* @author: 陈光�?
* @date: 2018�?7�?25�? 上午9:39:43 
 */
@Controller
public class DictionarySetController implements BackstageConstant {
    

	
	@Autowired
    private DictionaryService service;
	/**
	 * 
	 * @param model 视图模型 不需显示传参
	 * @return  跳转到数据字典列�?
	 */
	@RequestMapping(value = "dictionarylist")
	public String showDictionary(Model model) {
    	List<Dictionary> dc2 = service.getAll();
    	model.addAttribute(ATTRIBUTE_DICT_LIST, dc2);
    	model.addAttribute(ATTRIBUTE_DICT_LIST_SIZE, dc2.size());
    	model.addAttribute(ATTRIBUTE_DICT_TYPE, 5);
		return "/backer/dictionary.jsp";
	}
    
	/**
	 * 
	 * @param model
	 * @param type 数据字典数据�?属的类型
	 * @return   把相应的类型的信息列表放入model中并返回列表界面
	 */
	@RequestMapping(value="getDictionaryByType")
	public String getBytype(Model model, Integer type) {
		System.out.println("执行成功�?");
		List<Dictionary> dc2 = new ArrayList<>();
		dc2 = service.getByType(type);
		model.addAttribute(ATTRIBUTE_DICT_LIST, dc2);
		model.addAttribute(ATTRIBUTE_DICT_LIST_SIZE, dc2.size());
		model.addAttribute(ATTRIBUTE_DICT_TYPE, type + 1);
		return "/backer/dictionary.jsp";
	}
	
	/**
	 * 
	 * @param model
	 * @param id  jsp传过来的要删除的数据的主键id数组
	 * @return    返回列表界面
	 */
	@RequestMapping(value="deleteDictionary",method = RequestMethod.POST)
    public String delete(Model model, Integer[] id) {
		service.deleteMany(id);
		return showDictionary(model);
    }
	
	/**
	 * 
	 * @param model
	 * @param id 要删除的数据id
	 */
	@RequestMapping(value="/delDictionary")
	public void delLabelDir(Model model, Integer id) {
		Integer[] id2 = {id};
		service.deleteMany(id2);
	}
	
	/**
	 * 
	 * @param model
	 * @param id 要编辑的数据的id
 	 * @return  跳转到数据编辑页�?
	 */
	@RequestMapping(value="editDictionary")
    public String edit(Model model, Integer id) {
        Dictionary vo = service.getInfo(id);
		model.addAttribute(ATTRIBUTE_DICT_LIST, vo);
    	return "/backer/editDictionary.jsp";
    }
	
	/**
	 * 
	 * @param model
	 * @param vo 在编辑页面修改之后的完整数据信息对象
	 * @return   返回列表界面
	 */
	@RequestMapping(value="submitEditDctionary")
	public String submitEdit(Model model, Dictionary vo) {
		service.update(vo);
		return showDictionary(model);
	}
	
	/*@RequestMapping(value="addDictionary")
	public String addDictionary(Model model,Dictionary vo) {
		System.out.println("执行了增加方�?");
		service.addDictionary(vo);
		return "addDictionary.jsp";
	}*/
	
	/**
	 * 
	 * @param model
	 * @param vo  jsp传过来的要增加的数据信息 无返回�?�，因为是在弹窗中执�? 直接刷新父页�?
	 */
	@RequestMapping(value="addDictionary")
	public void addDictionary(Model model, Dictionary vo) {
		System.out.println("执行了增加方�?");
		service.addDictionary(vo);
	}
}
