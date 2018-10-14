package zm.village.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import zm.village.dao.User;
import zm.village.service.UserService;
import zm.village.util.tools.HttpReturn;
import zm.village.util.tools.JsonDateValueProcessor;


/**
 * @author 伍伴
 * @Date 2018�?7�?21�?
 * @Description 安卓前端用户控制�?
 * @version 1.0
 */

@Controller
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public void getAll(HttpServletResponse response) throws IOException {

		JsonConfig jsonConfig = new JsonConfig(); 
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONArray jsonArray= new JSONArray().fromObject(service.selectAll(),jsonConfig);
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void get(HttpServletResponse response, @RequestBody User vo) throws IOException {

	
		JsonConfig jsonConfig = new JsonConfig(); 
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONObject jsonObject = new JSONObject().fromObject(service.select(vo),jsonConfig);
		HttpReturn.reponseBody(response, jsonObject);
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletResponse response, @RequestBody User vo) throws IOException {

		if(service.getByUserTel(vo)!=null){
			HttpReturn.reponseBody(response, String.valueOf("已注�?"));
		}
		else {
			vo.setName(vo.getTelephone());
			vo.setImagePath("../img/default/default.jpg");
			vo.setRegTime(new Timestamp(new Date().getTime()));
			service.insert(vo);
			HttpReturn.reponseBody(response, String.valueOf("添加成功"));
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody User vo) throws IOException {

		service.update(vo);
		HttpReturn.reponseBody(response, "修改成功");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(HttpServletResponse response, @RequestBody User vo) throws IOException {

		service.delete(vo);
		HttpReturn.reponseBody(response, "删除成功");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletResponse response, @RequestBody User vo) throws IOException {

		if(service.login(vo)){
			User user = service.getByUserTel(vo);
			if(user.getUserType() == vo.getUserType()){
				JSONObject jsonObject = new JSONObject().fromObject(user);
				HttpReturn.reponseBody(response, jsonObject);
			}
			else {
				vo.setId(0);
				JSONObject jsonObject = new JSONObject().fromObject(vo);
				HttpReturn.reponseBody(response, jsonObject);
			}
		}
		else{
			vo.setId(0);
			JSONObject jsonObject = new JSONObject().fromObject(vo);
			HttpReturn.reponseBody(response, jsonObject);
		}
		
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public void updatePassword(HttpServletResponse response, int id, String oldpassword, String newpassword)
			throws IOException {

		User vo = service.getById(id);
		if (vo.getPassword().equals(oldpassword)) {
			vo.setPassword(newpassword);
			service.update(vo);
			HttpReturn.reponseBody(response, String.valueOf("修改成功"));
		} else
			HttpReturn.reponseBody(response, String.valueOf("原密码不符合"));
	}

	@RequestMapping(value = "/updateByUserTel", method = RequestMethod.POST)
	public void updateByUserTel(HttpServletResponse response, @RequestBody User vo) throws IOException {

		
		service.updateByUserTel(vo);

		HttpReturn.reponseBody(response, String.valueOf("通过电话号码修改成功"));
	}
	
	@RequestMapping(value = "/getByUserTel", method = RequestMethod.POST)
	public void getByUserTel(HttpServletResponse response,@RequestBody User vo) throws IOException {

		JSONObject jsonObject = new JSONObject().fromObject(service.getByUserTel(vo));
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value = "/UpdateHead", method = RequestMethod.POST)
	public void userHead(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("files") MultipartFile file) {
		String Id = request.getParameter("id");
		int id = Integer.parseInt(Id);
		String	upaloadUrl	= System.getProperty( "evan.webappvillage" ) + "..\\img\\";
		File  dir  = new File(upaloadUrl);                                                  /* 图片路径 */
		Format	format	= new SimpleDateFormat( "yyyyMMdd" );
		String	data	= "";
		int	intFlag = 0;
		String	image	= "";
		String	time	= "";
		if ( !dir.exists() )                                                            /* 目录不存在则创建 */
			dir.mkdirs();
		User user = service.getById(id);
		if(user!=null){
			data		= format.format( new Date() );
			intFlag		= (int) (Math.random() * 1000000);
			image		= String.valueOf( intFlag );
			time		= String.valueOf( new Date().getTime() );       /* 时间�? */
			upaloadUrl	= upaloadUrl + data;
			File tagetFile = new File( upaloadUrl );                        /* 创建文件对象 */
			if ( !tagetFile.isDirectory() )
				tagetFile.mkdirs();
			upaloadUrl = upaloadUrl + "\\" + time + image + ".jpg";
			File tagetFile2 = new File( upaloadUrl );                       /* 创建文件对象 */
			if ( !tagetFile2.exists() )                                     /* 文件名不存在 则新建文件，并将文件复制到新建文件中 */
			{
				try {
					tagetFile.createNewFile();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
				try {
					file.transferTo( tagetFile2 );
				} catch ( IllegalStateException e ) {
					e.printStackTrace();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
			String oldImage = user.getImagePath();
			String path = System.getProperty("evan.webappvillage");
			new File(path + oldImage).delete();
			user.setImagePath("../img/" + data + "/" + time + image + ".jpg");
			service.update(user);
			HttpReturn.reponseBody(response, "../img/" + data + "/" + time + image + ".jpg");
		}
		else{
			HttpReturn.reponseBody(response, "上传失败");
		}
	}
	
	/*@RequestMapping(value = "/UpdateHead", method = RequestMethod.POST)
	public void userHead(HttpServletRequest request, HttpServletResponse response) {

		String Id = request.getParameter("id");
		int id = Integer.parseInt(Id);
		String path = null;
		InputStream inStream = null;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		byte[] buf = new byte[1024];
		int len = 0;
		try {
			inStream = request.getInputStream();
			while ((len = inStream.read(buf)) != -1) {
				outStream.write(buf, 0, len);
			}

			User user = service.getById(id);
			if (user != null) {
				Format format = new SimpleDateFormat("yyyyMMdd");
				String data = format.format(new Date());

				int intFlag = (int) (Math.random() * 1000000);
				String image = String.valueOf(intFlag);

				String time = String.valueOf(new Date().getTime());// 时间�?
				// 获得绝地路径
				path = System.getProperty("evan.webappvillage");

				path = path + "../img/" + data;

				File file1 = new File(path);
				if (!file1.isDirectory())
					file1.mkdirs();
				path = path + "/" + time + image + ".jpg";
				File file2 = new File(path);
				file2.createNewFile();
 
				FileOutputStream op = new FileOutputStream(file2);
				op.write(outStream.toByteArray());
				op.flush();
				op.close();

				String oldImage = user.getImagePath();
				path = System.getProperty("evan.webappvillage");
				new File(path + oldImage).delete();
				user.setImagePath("../img/" + data + "/" + time + image + ".jpg");
				service.update(user);
				HttpReturn.reponseBody(response, "../img/" + data + "/" + time + image + ".jpg");
			}
			else{
				HttpReturn.reponseBody(response, "上传失败");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}*/
}
