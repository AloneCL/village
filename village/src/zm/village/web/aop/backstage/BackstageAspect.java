package zm.village.web.aop.backstage;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
	 * @see zm.village.web.aop.AdminPermissionController
	 */
	@Pointcut("execution(* zm.village.web.controller..*.*(..)) && "
			+ "(@target(zm.village.web.aop.backstage.AdminPermissionController) || "
			+ "@within(zm.village.web.aop.backstage.AdminPermission))")
	public void permissionCheckPointcut() {}
	
	@Around("permissionCheckPointcut()")
	public Object permissionCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		if(request.getSession().getAttribute(SESSION_ADMIN) != null)
			return joinPoint.proceed();
		return "/login.jsp";
	}
}