/**
 * 
 */
package zm.village.ssm.webcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zm.village.dao.Admin;
import zm.village.service.AdminService;

/**
 * @ClassName: AdminSetController.java
 * @Description: 管理员控制层
 * @version: v1.0.0
 * @author: 陈光磊
 * @date: 2018年7月23日 上午9:33:29
 */
@Controller
public class AdminSetController {

	@Autowired
	private AdminService service;
    
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, Model model) {
		//request.getSession().removeAttribute("manager");
		String error = request.getParameter("error");
		String code = request.getParameter("checkcode");
        if(error != null) {
		if (error.equals("2")) {
			model.addAttribute("error", "账号密码错误");
		}else if(error.equals("1")) 
			model.addAttribute("error", "验证码输入错误");
			/*}else if(error.equals("3"))
			model.addAttribute("error", "该账号已登录");*/
    }
		return "/login.jsp";
	}

	@RequestMapping(value = "/submitLogin")
	public String submitLogin(HttpServletRequest request, Model model, Admin vo) {
		String clientCheckcode = request.getParameter("validateCode");// 接收客户端浏览器提交上来的验证码
		String serverCheckcode = (String) request.getSession().getAttribute("checkcode");// 从服务器端的session中取出验证码
		System.out.println(clientCheckcode + "-----" + serverCheckcode);
		HttpSession session = request.getSession();
		/*Map<String,String> loginUser = (Map<String, String>) session.getServletContext().getAttribute("loginUser");
		if(loginUser == null)
			loginUser = new HashMap<>();
*/
       //  return "redirect:/index";

		if (clientCheckcode.toLowerCase().equals(serverCheckcode.toLowerCase())) {// 将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
			request.getSession().removeAttribute("validateCode");
			if (service.login(vo)) {
				String id = request.getSession().getId();
				//request.getSession().setAttribute("manager", vo);
				/* for(String key:loginUser.keySet()) {
		             if (vo.getUsername().equals(key)) {
		                 if(session.getId().equals(loginUser.get(key))) {
		                     System.out.println(vo.getUsername()+"在同一地点多次登录！");
		                 }else{
		                     System.out.println(vo.getUsername()+"异地登录被拒绝！");
		                     return "redirect:login.action?error=" + 3;
		                 }
		             }
		         }
				 loginUser.put(vo.getUsername(),session.getId());
		         session.getServletContext().setAttribute("loginUser", loginUser);*/
		         session.setAttribute("manager",vo);
		         System.out.println("登录成功！");
				System.out.println(id);
				return "/backer/_left.jsp";
			}else 
				return "redirect:login.action?error=" + 2;
		}else
		return "redirect:login.action?error=" + 1;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request) {
		System.out.println(1);
		Admin vo = (Admin) request.getSession().getAttribute("manager");
		if(vo!=null) {
			request.getSession().removeAttribute("manager");
			/*Map<String,String> loginUser = (Map<String, String>) request.getSession().getServletContext().getAttribute("loginUser");
		    loginUser.remove(vo.getUsername());
		    request.getSession().getServletContext().setAttribute("loginUser", loginUser);*/
		}
		request.getSession().removeAttribute("manager");
		return "redirect:login.action";
	}

	@RequestMapping(value = "/managerSet")
	public String userSet(Model model, HttpServletRequest request) {
		String error = request.getParameter("error");
		if (error != null) {
			model.addAttribute("error", "账号密码错误");
		}
		return "/backer/managerSet.jsp";
	}

	@RequestMapping(value = "/managerSubmitPass")
	public String ajaxPass(Model model, String pass, String pass1, HttpServletRequest request) {
		Admin manager = (Admin) request.getSession().getAttribute("manager");
		if (pass.equals(manager.getPassword())) {
			manager.setPassword(pass1);
			service.changeSelect(manager);
			request.getSession().setAttribute("manager", manager);
			return "redirect:login.action";
		} else {
			return "redirect:managerSet.action?error=" + "1";
		}
	}
}
