package zm.village.web.aop.backstage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.ModelAndView;

import zm.village.dao.Admin;
import zm.village.web.controller.backstage.BackstageConstant;

/**
* @author 李子帆
* @version 1.0
* @date 2018年10月15日 下午2:06:57
* @Description 后台管理界面操作用户权限认证横切逻辑
*/
@Aspect
public class BackstagePermissionAspect implements BackstageConstant {
	
	public void permissionCheckPointcut() {}
	
	@Around("permissionCheckPointcut()")
	public Object permissionCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			
			if(arg instanceof HttpServletRequest) {
				HttpServletRequest request = (HttpServletRequest)arg;
				if(request.getSession().getAttribute(SESSION_ADMIN) != null) {
					joinPoint.proceed();
				}
				return "/login.jsp";
				
			} else if(arg instanceof HttpSession) {
				HttpSession session = (HttpSession)arg;
				if(session.getAttribute(SESSION_ADMIN) != null) {
					session.getAttribute(SESSION_ADMIN);
				}
			}
		}
		
		//TODO 
		return null;
	}
}