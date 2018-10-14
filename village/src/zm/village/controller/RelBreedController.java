package zm.village.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zm.village.dao.Breed;
import zm.village.service.RelBreedService;
import zm.village.util.tools.HttpReturn;

/**
 * @author 伍伴
 * @Date 2018�?7�?21�?
 * @Description 安卓前端养殖类控制层
 * @version 1.0
 */


@Controller
@RequestMapping("/RelBreed")
public class RelBreedController {

	@Autowired
	private RelBreedService service;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public void getAll(HttpServletResponse response) throws IOException {

	
		@SuppressWarnings("static-access")
		JSONArray jsonArray= new JSONArray().fromObject(service.selectAll());
		
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void get(HttpServletResponse response, @RequestBody Breed vo) throws IOException {

		@SuppressWarnings("static-access")
		JSONObject jsonObject = new JSONObject().fromObject(service.select(vo));
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value = "/getBreeLand", method = RequestMethod.POST)
	public void getBreeLand(HttpServletResponse response, Integer landId) throws IOException {

		@SuppressWarnings("static-access")
		JSONArray jsonArray = new JSONArray().fromObject(service.getByLandId(landId));
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, @RequestBody Breed vo) throws IOException {

		service.insert(vo);
		HttpReturn.reponseBody(response, "添加成功");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody Breed vo) throws IOException {

		service.update(vo);
		HttpReturn.reponseBody(response, "修改成功");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(HttpServletResponse response, @RequestBody Breed vo) throws IOException {

		service.delete(vo);
		HttpReturn.reponseBody(response, "删除成功");
	}
}
