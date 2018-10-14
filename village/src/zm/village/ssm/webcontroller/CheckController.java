package zm.village.ssm.webcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Check")
public class CheckController{
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)
    public void check(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String result = "error";
        String clientCheckcode = request.getParameter("validateCode");//接收客户端浏览器提交上来的验证码
        String serverCheckcode = (String) request.getSession().getAttribute("checkcode");//从服务器端的session中取出验证码
        if (clientCheckcode.equals(serverCheckcode.toLowerCase())) {//将客户端验证码和服务器端验证比较，如果相等，则表示验证通过
        	System.out.println("验证码验证通过！");
        	result = "ok";
        	response.getWriter().print(result);
        }
        else
        {
            System.out.println("验证码验证失败！");
            response.getWriter().print(result);
        }
    }

}