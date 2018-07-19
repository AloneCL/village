package zm.village.util.tools;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @ClassName: HttpReturn.java
* @Description: 封装工具类 把数据转换为json格式放在response中返回
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月19日 上午10:09:07 
 */
public class HttpReturn {

	public static void reponseBody(HttpServletResponse response,JSONArray jsonarray) {
		byte[] dataByte = null;
		
		//Servlet通过使用ServletResponse接口的使用获得了对一个这种类型的对象的说明 利用这个输出流可以将数据返回到客户端�??
	    ServletOutputStream output = null;
		try {
			//用于得到输出二进制数据的ServletOuputStream的对象
			output = response.getOutputStream();
			dataByte = jsonarray.toString().getBytes("UTF-8");
		    output.write(dataByte);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

	public static void reponseBody(HttpServletResponse response, String string) {
		byte[] dataByte = null;
	    ServletOutputStream output = null;
		try {
			output = response.getOutputStream();
			dataByte = string.getBytes("UTF-8");
		    output.write(dataByte);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void reponseBody(HttpServletResponse response, JSONObject jsonObject) {
		byte[] dataByte = null;
	    ServletOutputStream output = null;
		try {
			output = response.getOutputStream();
			dataByte = jsonObject.toString().getBytes("UTF-8");
		    output.write(dataByte);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
