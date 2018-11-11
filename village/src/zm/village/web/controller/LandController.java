package zm.village.web.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
import zm.village.dao.Land;
import zm.village.service.DictionaryService;
import zm.village.service.LandService;
import zm.village.util.tools.HttpReturn;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 安卓前端土地控制层
 * @version 1.0
 */

@Controller
@RequestMapping("/Land")
public class LandController {

	@Autowired
	private LandService service;
	
	@Autowired
	private DictionaryService dicService;

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public void getAll(HttpServletResponse response, int start, int end) throws IOException {

		List<Land> lands = service.selectAll();
		List<Land> vo = new LinkedList<Land>();
		if (start < lands.size()) {
			if (end > lands.size()) {
				for (int i = start; i < lands.size(); i++) {
					vo.add(lands.get(i));
				}
			}
			else {
				for (int i = start; i < end; i++) {
					vo.add(lands.get(i));
				}
			}
		}
		@SuppressWarnings("static-access")
		JSONArray jsonArray = new JSONArray().fromObject(vo);

		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value = "/getByuserId", method = RequestMethod.POST)
	public void getByuserId(HttpServletResponse response, int userId, int start, int end) throws IOException {

		List<Land> lands = service.getByuserId(userId);
		List<Land> vo = new LinkedList<Land>();
		if (start < lands.size()) {
			if (end > lands.size()) {
				for (int i = start; i < lands.size(); i++) {
					vo.add(lands.get(i));
				}
			}
			else {
				for (int i = start; i < end; i++) {
					vo.add(lands.get(i));
				}
			}
		}
		@SuppressWarnings("static-access")
		JSONArray jsonArray = new JSONArray().fromObject(vo);

		HttpReturn.reponseBody(response, jsonArray);
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public void get(HttpServletResponse response, @RequestBody Land vo) throws IOException {

		@SuppressWarnings("static-access")
		JSONObject jsonObject = new JSONObject().fromObject(service.select(vo));
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value = "/getPlant", method = RequestMethod.POST)
	public void getPlant(HttpServletResponse response, @RequestBody Land vo) throws IOException {

		vo = service.select(vo);
		JSONArray jsonArray = new JSONArray().fromObject(dicService.getByType(vo.getType()));
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value = "/addLand", method = RequestMethod.POST)
	public void add(HttpServletResponse response, @RequestBody Land vo) throws IOException {

		service.insert(vo);
		HttpReturn.reponseBody(response, "添加成功");
		
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addImage(HttpServletResponse response, @RequestParam(name="userId", required = true) Integer userId,
			@RequestParam(name="name", required = true) String name,@RequestParam(name="type", required = true) Integer type,
			@RequestParam(name="province", required = false) String province,@RequestParam(name="city", required = false) String city,
			@RequestParam(name="district", required = false) String district,@RequestParam(name="address", required = false) String address,
			@RequestParam(name="size", required = false) Double size,@RequestParam(name="unusedSize", required = false) Double unusedSize,
			@RequestParam(name="basicPrice", required = false) Double basicPrice,@RequestParam(name="introduce", required = false) String introduce,
			@RequestParam(name="split", required = false) Integer split,@RequestParam(name="minLease", required = false) String minLease,
			@RequestParam(name="status", required = true) Integer status,@RequestParam(name="startTime", required = false) Timestamp startTime,
			@RequestParam(name="endTime", required = false) Timestamp endTime,@RequestParam(name="size", required = false) Double latitude,
			@RequestParam(name="size", required = false) Double longitude,@RequestParam(name="imgURL", required = false) MultipartFile[] file1,
			@RequestParam(name="certificateURL", required = false) 
	        MultipartFile[] file2) throws IOException {

		Land vo = new Land();
		vo.setUserId(userId);
		vo.setName(name);
		vo.setType(type);
		vo.setStatus(status);
		vo.setProvince(province);
		vo.setCity(city);
		vo.setDistrict(district);
		vo.setAddress(address);
		vo.setSize(size);
		vo.setUnusedSize(unusedSize);
		vo.setBasicPrice(basicPrice);
		vo.setIntroduce(introduce);
		vo.setMinLease(minLease);
		vo.setStartTime(startTime);
		vo.setEndTime(endTime);
		vo.setSplit(split);
		vo.setLatitude(latitude);
		vo.setLongitude(longitude);
		if(file1 != null && file1.length > 0){
			String	upaloadUrl	= System.getProperty( "evan.webappvillage" ) + "..\\img\\";
			String	img_url = upaloadUrl;
			File  dir  = new File(upaloadUrl);                                                 
			Format	format	= new SimpleDateFormat( "yyyyMMdd" );
			String	data	= "";
			int	intFlag = 0;
			String	image	= "";
			String	time	= "";
			String  img_url1 ="";
			if ( !dir.exists() )                                                           
				dir.mkdirs();
			for (int i = 0; i < file1.length; i++ ){
				
			MultipartFile file = file1[i];
			data	= format.format( new Date() );
			intFlag	= (int) (Math.random() * 1000000);
			image	= String.valueOf( intFlag );
			time	= String.valueOf( new Date().getTime() );       
			upaloadUrl=img_url;
			upaloadUrl	= upaloadUrl + data;
			File tagetFile = new File( upaloadUrl );                        
			if ( !tagetFile.isDirectory() )
					tagetFile.mkdirs();
			upaloadUrl = upaloadUrl + "\\" + time + image + ".jpg";
			File tagetFile2 = new File( upaloadUrl );                       
			if ( !tagetFile2.exists() ) {                                   
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
			img_url1 +="../img/"+data+"/"+time + image + ".jpg";
			 if(file1.length>1 && i<file1.length-1)
				 img_url1 += "&";
			}
			vo.setImgURL(img_url1);
		}
		if(file2 != null && file2.length > 0){
			String	upaloadUrl	= System.getProperty( "evan.webappvillage" ) + "..\\img\\";
			String	img_url = upaloadUrl;
			String  img_url1 ="";
			File  dir  = new File(upaloadUrl);                                                  
			Format	format	= new SimpleDateFormat( "yyyyMMdd" );
			String	data	= "";
			int	intFlag = 0;
			String	image	= "";
			String	time	= "";
			if ( !dir.exists() )                                                           
				dir.mkdirs();
			for (int i = 0; i < file2.length; i++ ){
				
			MultipartFile file = file2[i];
			data	= format.format( new Date() );
			intFlag	= (int) (Math.random() * 1000000);
			image	= String.valueOf( intFlag );
			time	= String.valueOf( new Date().getTime() );       
			upaloadUrl=img_url;
			upaloadUrl	= upaloadUrl + data;
			File tagetFile = new File( upaloadUrl );                       
			if ( !tagetFile.isDirectory() )
					tagetFile.mkdirs();
			upaloadUrl = upaloadUrl + "\\" + time + image + ".jpg";
			File tagetFile2 = new File( upaloadUrl );                       
			if ( !tagetFile2.exists() ) {                                 
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
			img_url1 +="../img/"+data+"/"+time + image + ".jpg";
			 if(file2.length>1 && i<file2.length-1)
				 img_url1 += "&";
			}
			vo.setCertificateURL(img_url1);
		}
		service.insert(vo);
		HttpReturn.reponseBody(response, "添加成功");
		
	}

	@RequestMapping(value = "/updateImage", method = RequestMethod.POST)
	public void updateImage(HttpServletRequest request,HttpServletResponse response,@RequestParam(name="imgURL", required = false) 
	MultipartFile[] file1,@RequestParam(name="certificateURL", required = false) MultipartFile[] file2) throws IOException {

		String Id = request.getParameter("id");
		int id = Integer.parseInt(Id);
		Land vo = service.getById(id);
		if(file1 != null && file1.length > 0){
			String	upaloadUrl	= System.getProperty( "evan.webappvillage" ) + "..\\img\\";
			String	img_url = upaloadUrl;
			File  dir  = new File(upaloadUrl);                                                 
			Format	format	= new SimpleDateFormat( "yyyyMMdd" );
			String	data	= "";
			int	intFlag = 0;
			String	image	= "";
			String	time	= "";
			String  img_url1 ="";
			if ( !dir.exists() )                                                           
				dir.mkdirs();
			for (int i = 0; i < file1.length; i++ ){
				
			MultipartFile file = file1[i];
			data	= format.format( new Date() );
			intFlag	= (int) (Math.random() * 1000000);
			image	= String.valueOf( intFlag );
			time	= String.valueOf( new Date().getTime() );       
			upaloadUrl=img_url;
			upaloadUrl	= upaloadUrl + data;
			File tagetFile = new File( upaloadUrl );                        
			if ( !tagetFile.isDirectory() )
					tagetFile.mkdirs();
			upaloadUrl = upaloadUrl + "\\" + time + image + ".jpg";
			File tagetFile2 = new File( upaloadUrl );                       
			if ( !tagetFile2.exists() ) {                                   
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
			img_url1 +="../img/"+data+"/"+time + image + ".jpg";
			 if(file1.length>1 && i<file1.length-1)
				 img_url1 += "&";
			}
			vo.setImgURL(img_url1);
		}
		if(file2 != null && file2.length > 0){
			String	upaloadUrl	= System.getProperty( "evan.webappvillage" ) + "..\\img\\";
			String	img_url = upaloadUrl;
			String  img_url1 ="";
			File  dir  = new File(upaloadUrl);                                                  
			Format	format	= new SimpleDateFormat( "yyyyMMdd" );
			String	data	= "";
			int	intFlag = 0;
			String	image	= "";
			String	time	= "";
			if ( !dir.exists() )                                                           
				dir.mkdirs();
			for (int i = 0; i < file2.length; i++ ){
				
			MultipartFile file = file2[i];
			data	= format.format( new Date() );
			intFlag	= (int) (Math.random() * 1000000);
			image	= String.valueOf( intFlag );
			time	= String.valueOf( new Date().getTime() );       
			upaloadUrl=img_url;
			upaloadUrl	= upaloadUrl + data;
			File tagetFile = new File( upaloadUrl );                       
			if ( !tagetFile.isDirectory() )
					tagetFile.mkdirs();
			upaloadUrl = upaloadUrl + "\\" + time + image + ".jpg";
			File tagetFile2 = new File( upaloadUrl );                       
			if ( !tagetFile2.exists() ) {                                 
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
			img_url1 +="../img/"+data+"/"+time + image + ".jpg";
			 if(file2.length>1 && i<file2.length-1)
				 img_url1 += "&";
			}
			vo.setCertificateURL(img_url1);
		}
		service.update(vo);
		HttpReturn.reponseBody(response, "修改成功");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody Land vo) throws IOException {

		service.update(vo);
		HttpReturn.reponseBody(response, "修改成功");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(HttpServletResponse response, @RequestBody Land vo) throws IOException {

		service.delete(vo);
		HttpReturn.reponseBody(response, "删除成功");
	}
}
