package zm.village.controller.backstage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zm.village.dao.User;
import zm.village.service.UserService;

/**
 * @author 伍伴
 * @Date 2018�?7�?22�?
 * @Description 用户类后端页面控制层
 * @version 1.0
 */
@Controller
public class UserSetController {
   
	@Autowired 
	private UserService service;
	
	
	@RequestMapping(value = "/setUser")
	public String diary(Model model){

		model.addAttribute("users", service.selectAll());
		return "/backer/user.jsp";
	}

	@RequestMapping(value = "/editUser")
	public String edit(Model model, Integer id){
		model.addAttribute("user", service.getById(id));
		return "/backer/userSet.jsp";
	}
	
	@RequestMapping(value = "/showUser")
	public String show(Model model, Integer id){
		model.addAttribute("user", service.getById(id));
		return "/backer/userShow.jsp";
	}
	
	@RequestMapping("/submitEditUser")
	public String submitEdit(Model model, User vo){
		
		return "/backer/addUser.jsp";
	}
	
	@RequestMapping(value = "/addUser")
	public String add(Model model, User vo){
		
		if(service.getByUserTel(vo)==null){
			if(vo.getImagePath()==null)
				vo.setImagePath("../img/default/default.jpg");
			service.insert(vo);
		}
		return diary(model);
	}

	@RequestMapping("/modifyUser")
	public String modify(Model model, User vo){
		
       if(service.getByUserTel(vo)!=null){
    	    vo.setTelephone(null);
			service.update(vo);
		}
       else{
    	   service.update(vo);
       }
		return edit(model,vo.getId());
	}

	@RequestMapping("/deleteUser")
	public String deleteDiary(Model model, Integer id){
		
		service.delete(id);
		return diary(model);
	}
	
	@RequestMapping("/deleteManyUser")
	public String deleteManyUser(Model model, Integer[] id){
		if (id != null) {
			service.deleteMany(id);
		}
		return diary(model);
	}
	
}
