package zm.village.web.controller.backstage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zm.village.dao.Admin;
import zm.village.service.AdminService;
import zm.village.web.aop.backstage.AdminPermission;

/**
 * @ClassName: AdminSetController.java
 * @Description: 管理员控制层
 * @version: v1.0.0
 * @author: 陈光磊
 * @date: 2018年7月23日 上午9:33:29
 */
@Controller
public class AdminSetController implements BackstageConstant {	
	
	@Autowired
	private AdminService service;
	
	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request) {
		String error = request.getParameter(REQUEST_ERROR_INFO);

        if(error != null) {
			if (error.equals(ERRCODE_WRONG_PASS))
				model.addAttribute(REQUEST_ERROR_INFO, "账号密码错误");
			else if(error.equals(ERRCODE_WRONG_VALIDATECODE)) 
				model.addAttribute(REQUEST_ERROR_INFO, "验证码输入错误");
        }
        
		return "/login.jsp";
	}
	
	/**
	 * 提交登录
	 */
	@RequestMapping(value = "/submitLogin")
	public String submitLogin(Model model, HttpServletRequest request, HttpSession session, Admin vo) {
		// 接收客户端浏览器提交上来的验证码
		String clientCheckcode = request.getParameter(REQUEST_VALIDATECODE);	
		// 从服务器端的session中取出验证码
		String serverCheckcode = (String) session.getAttribute(SESSION_VALIDATECODE);
		
		// 将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
		if (clientCheckcode.toLowerCase().equals(serverCheckcode.toLowerCase())) {
			session.removeAttribute(REQUEST_VALIDATECODE);
			if (service.login(vo)) {
		        session.setAttribute(SESSION_ADMIN, vo);
				return "redirect:backstage.action";
			} else 
				return "redirect:login.action?error=" + ERRCODE_WRONG_PASS;
		}
		
		return "redirect:login.action?error=" + ERRCODE_WRONG_VALIDATECODE;
	}
	
	/**
	 * 后台管理主页面，需要Session中持有管理员对象
	 * @return 如果之前已经登录成功，那么服务端跳转到_left.jsp
	 */
	@AdminPermission
	@RequestMapping(value = "/backstage")
	public String backstagePage(Model model, HttpSession session) {
		return "/backer/_left.jsp";
	}
	
	/**
	 * 管理员从后台管理界面注销
	 */
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {	
		Admin vo = (Admin) session.getAttribute(SESSION_ADMIN);
		
		if(vo != null) {
			session.removeAttribute(SESSION_ADMIN);
		}
		session.removeAttribute(SESSION_ADMIN);
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
	 * 修改管理员密码
	 */
	@RequestMapping(value = "/managerSubmitPass")
	public String ajaxPass(Model model, String pass, String pass1, HttpSession session) {	
		Admin manager = (Admin) session.getAttribute(SESSION_ADMIN);
		
		if (pass.equals(manager.getPassword())) {
			
			manager.setPassword(pass1);
			service.changeSelect(manager);
			session.setAttribute(SESSION_ADMIN, manager);
			
			return "redirect:login.action";
		} else {
			return "redirect:managerSet.action?error=" + ERRCODE_WRONG_VALIDATECODE;
		}
	}
}
