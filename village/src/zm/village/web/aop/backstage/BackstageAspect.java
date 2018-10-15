package zm.village.web.aop.backstage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import zm.village.dao.Admin;
import zm.village.web.controller.backstage.BackstageConstant;

/**
* @author 李子帆
* @version 1.0
* @date 2018年10月15日 下午2:06:57
* @Description 后台管理界面横切逻辑
*/
@Aspect @Component
public class BackstageAspect implements BackstageConstant {
	
	/**
	 * 需要管理员登录后才能进行操作的逻辑
	 * 需要在方法中标记Permission注解
	 * @see zm.village.web.aop.Permission
	 */
	@Pointcut("@target(zm.village.web.aop.backstage.Permission)")
	public void permissionCheckPointcut() {}
	
	@Around("permissionCheckPointcut()")
	public Object permissionCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Aspect Run");
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			
			if(arg instanceof HttpServletRequest) {
				HttpServletRequest request = (HttpServletRequest)arg;
				if(request.getSession().getAttribute(SESSION_ADMIN) != null) {
					joinPoint.proceed();
				}
				
			} else if(arg instanceof HttpSession) {
				HttpSession session = (HttpSession)arg;
				if(session.getAttribute(SESSION_ADMIN) != null) {
					joinPoint.proceed();
				}
			}
		}
		return "/login.jsp";
	}
}