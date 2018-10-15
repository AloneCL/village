package zm.village.web.controller.backstage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Check")
public class CheckController implements BackstageConstant {
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
    public void check(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String result = "error";
		//接收客户端浏览器提交上来的验证码
        String clientCheckcode = request.getParameter(REQUEST_VALIDATECODE);
        //从服务器端的session中取出验证码
        String serverCheckcode = (String) request.getSession().getAttribute(SESSION_VALIDATECODE);
        System.out.println(serverCheckcode);
        
        //将客户端验证码和服务器端验证比较，如果相等，则表示验证�?�过
        if (clientCheckcode.toLowerCase().equals(serverCheckcode.toLowerCase())) {
        	System.out.println("验证码验证�?�过�?");
        	result = "ok";
        	response.getWriter().print(result);
        } else {
            System.out.println("验证码验证失败！");
            response.getWriter().print(result);
        }
    }

}