/**
 * 
 */
package zm.village.web.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import zm.village.dao.Collect;
import zm.village.service.CollectService;
import zm.village.util.tools.HttpReturn;
import zm.village.util.tools.JsonDateValueProcessor;

/**
* @ClassName: CollectController.java
* @Description: 用户收藏安卓/前端接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月28日 上午10:29:35 
 */
@Controller
@RequestMapping(value="/Collect")
public class CollectController {
    
	@Autowired
	private CollectService service;
    
	/**
	 * 根据用户id获取用户收藏信息
	 * @param response
	 * @param userId
	 */
	@RequestMapping(value="/getUserCollect",method=RequestMethod.POST)
	public void getAll(HttpServletResponse response,Integer userId) {
		List<Collect> cl = new ArrayList();
		cl = service.getByUserId(userId);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class, new JsonDateValueProcessor());
		JSONArray jsonArray;
	    jsonArray = JSONArray.fromObject(cl,jsonConfig);
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	/**
	 * 根据收藏的商品或土地信息增加一条用户收藏信息
	 * @param response
	 * @param vo
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addCollect(HttpServletResponse response,@RequestBody Collect vo) {
		System.out.println("执行了增加的方法");
		int hint;
		hint = service.addCollect(vo);
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	/**
	 * 根据点击获取的收藏主键信息删除收藏
	 * @param response
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void deleteCollect(HttpServletResponse response,@RequestBody String id) {
		int hint;
		System.out.println("执行删除方法");
		 JSONArray jsonArray=JSONArray.fromObject(id);
		    System.out.println(id);
		    List<Integer> id1 = (List) JSONArray.toCollection(jsonArray);
	 	    int i = 0;
	 	    Integer[] id2 = new Integer[id1.size()];
		    for (Integer integer : id1) {
		       id2[i] = integer;
		       i++;
			   System.out.println(integer);	
			}
		    hint =service.deleteMany(id2);
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
}
