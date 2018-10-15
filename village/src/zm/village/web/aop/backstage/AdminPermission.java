package zm.village.web.aop.backstage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @author 李子帆
* @version 1.0
* @date 2018年10月15日 下午8:14:29
* @Description 用于标记后台管理中需要登录后才能进行操作的Controller类中的方法
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminPermission {

}
