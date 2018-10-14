package zm.village.controller.backstage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zm.village.dao.Admin;
import zm.village.service.AdminService;

/**
 * @ClassName: AdminSetController.java
 * @Description: 管理员控制层
 * @version: v1.0.0
 * @author: 陈光�?
 * @date: 2018�?7�?23�? 上午9:33:29
 */
@Controller
public class AdminSetController implements BackstageConstant {	
	
	@Autowired
	private AdminService service;
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, Model model) {
		String error = request.getParameter(REQUEST_ERROR_INFO);

        if(error != null) {
			if (error.equals(ERRCODE_WRONG_PASS))
				model.addAttribute(REQUEST_ERROR_INFO, "账号密码错误");
			else if(error.equals(ERRCODE_WRONG_VALIDATECODE)) 
				model.addAttribute(REQUEST_ERROR_INFO, "验证码输入错�?");
        }
        
		return "/login.jsp";
	}
	
	/**
	 * 提交登录
	 */
	@RequestMapping(value = "/submitLogin")
	public String submitLogin(HttpServletRequest request, Model model, Admin vo) {
		// 接收客户端浏览器提交上来的验证码
		String clientCheckcode = request.getParameter(REQUEST_VALIDATECODE);	
		HttpSession session = request.getSession();
		// 从服务器端的session中取出验证码
		String serverCheckcode = (String) session.getAttribute(SESSION_VALIDATECODE);
		
		// 将客户端验证码和服务器端验证比较，如果相等，则表示验证�?�过
		if (clientCheckcode.toLowerCase().equals(serverCheckcode.toLowerCase())) {
			session.removeAttribute(REQUEST_VALIDATECODE);
			if (service.login(vo)) {
		        session.setAttribute(SESSION_ADMIN, vo);
				return "/backer/_left.jsp";
			} else 
				return "redirect:login.action?error=" + ERRCODE_WRONG_PASS;
		}
		
		return "redirect:login.action?error=" + ERRCODE_WRONG_VALIDATECODE;
	}
	
	/**
	 * 管理员从后台管理界面注销
	 */
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request) {	
		Admin vo = (Admin) request.getSession().getAttribute(SESSION_ADMIN);
		
		if(vo != null) {
			request.getSession().removeAttribute(SESSION_ADMIN);
		}
		request.getSession().removeAttribute(SESSION_ADMIN);
		return "redirect:login.action";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/managerSet")
	public String userSet(Model model, HttpServletRequest request) {
		String error = request.getParameter(REQUEST_ERROR_INFO);
		
		if (error != null) {
			model.addAttribute(REQUEST_ERROR_INFO, "账号密码错误");
		}
		
		return "/backer/managerSet.jsp";
	}

	/**
	 * 修改管理员密�?
	 */
	@RequestMapping(value = "/managerSubmitPass")
	public String ajaxPass(Model model, String pass, String pass1, HttpServletRequest request) {	
		Admin manager = (Admin) request.getSession().getAttribute(SESSION_ADMIN);
		
		if (pass.equals(manager.getPassword())) {
			
			manager.setPassword(pass1);
			service.changeSelect(manager);
			request.getSession().setAttribute(SESSION_ADMIN, manager);
			
			return "redirect:login.action";
		} else {
			return "redirect:managerSet.action?error=" + ERRCODE_WRONG_VALIDATECODE;
		}
	}
}
