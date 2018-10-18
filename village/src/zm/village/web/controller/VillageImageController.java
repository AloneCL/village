package zm.village.web.controller;

import net.sf.json.JSONObject;
import zm.village.dao.VillageImage;
import zm.village.service.VillageImageService;
import zm.village.util.tools.HttpReturn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/VillageImage")
public class VillageImageController {
	
	@Autowired
	private  VillageImageService service;
	
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public void add(HttpServletResponse response) throws IOException{
        
		VillageImage image = service.getInfo();
		@SuppressWarnings("static-access")
		JSONObject jsonObject = new JSONObject().fromObject(image);

		HttpReturn.reponseBody(response, jsonObject);
	}
	
}
