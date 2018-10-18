package zm.village.web.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zm.village.dao.Crop;
import zm.village.dao.Land;
import zm.village.service.RelLandService;
import zm.village.util.tools.HttpReturn;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 安卓前端土地可种植作物控制层
 * @version 1.0
 */

@Controller
@RequestMapping("/RelLand")
public class RelLandController {

	@Autowired
	private RelLandService service;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public void getAll(HttpServletResponse response, int start, int end) throws IOException {

		List<Crop> crops = service.selectAll();
		List<Crop> vo = new LinkedList<Crop>();
		if (start < crops.size()) {
			if (end > crops.size()) {
				for (int i = start; i < crops.size(); i++) {
					vo.add(crops.get(i));
				}
			}
			else {
				for (int i = start; i < end; i++) {
					vo.add(crops.get(i));
				}
			}
		}
		@SuppressWarnings("static-access")
		JSONArray jsonArray= new JSONArray().fromObject(vo);
		
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void get(HttpServletResponse response, @RequestBody Crop vo) throws IOException {

		@SuppressWarnings("static-access")
		JSONObject jsonObject = new JSONObject().fromObject(service.select(vo));
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value = "/getCropLand", method = RequestMethod.POST)
	public void getCropLand(HttpServletResponse response, Integer landId, int start
			, int end) throws IOException {

		List<Crop> crops = service.getByLand(landId);
		List<Crop> vo = new LinkedList<Crop>();
		if (start < crops.size()) {
			if (end > crops.size()) {
				for (int i = start; i < crops.size(); i++) {
					vo.add(crops.get(i));
				}
			}
			else {
				for (int i = start; i < end; i++) {
					vo.add(crops.get(i));
				}
			}
		}
		@SuppressWarnings("static-access")
		JSONArray jsonArray = new JSONArray().fromObject(service.getByLand(landId));
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, @RequestBody Crop vo) throws IOException {

		service.insert(vo);
		HttpReturn.reponseBody(response, "添加成功");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody Crop vo) throws IOException {

		service.update(vo);
		HttpReturn.reponseBody(response, "修改成功");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(HttpServletResponse response, @RequestBody Crop vo) throws IOException {

		service.delete(vo);
		HttpReturn.reponseBody(response, "删除成功");
	}
}
