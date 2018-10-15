package zm.village.web.controller.backstage;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import zm.village.dao.Land;
import zm.village.service.LandService;
import zm.village.service.UserService;

/**
* @ClassName: LandSetController.java
* @Description: 土地后端页面控制层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月19日 上午9:15:36 
 */

@Controller
public class LandSetController {
    
	@Autowired
	private LandService service;
	@Autowired
	private UserService userservice;

	@RequestMapping( value = "/setLand" )
	public String diary( Model model )
	{
		model.addAttribute( "lands", service.selectAll() );
		return("/backer/land.jsp");
	}


	@RequestMapping( value = "/editLand" )
	public String edit( Model model, Integer id )
	{
		model.addAttribute( "land", service.getById( id ) );
		model.addAttribute( "land_user", userservice.selectAll() );
		return("/backer/landSet.jsp");
	}


	@RequestMapping( "/submitEditLand" )
	public String submitEdit( Model model, Land vo )
	{
		model.addAttribute( "land_users", userservice.selectAll() );
		return("/backer/addLand.jsp");
	}


	@RequestMapping( value = "/showLand" )
	public String show( Model model, Integer id )
	{
		model.addAttribute( "land", service.getById( id ) );
		return("/backer/landShow.jsp");
	}


	@RequestMapping( value = "/addLand" )
	public String add( Model model, Land vo )
	{
		vo.setStatus( 1 );
		service.insert(vo);
		return(diary( model ) );
	}


	@RequestMapping( "/modifyLand" )
	public String modify( Model model, Land vo )
	{
		
		service.update(vo);
		return(edit( model, vo.getId() ) );
	}


	@RequestMapping( "/deleteLand" )
	public String deleteDiary( Model model, Integer id )
	{
		
		service.delete(id);
		return(diary( model ) );
	}


	@RequestMapping( "/deleteManyLand" )
	public String deleteManyLand( Model model, Integer[] id )
	{
		if ( id != null ){
			
			service.deleteMany(id);
		}
		return(diary( model ) );
	}


	@RequestMapping( value = "/UpdateLand", method = RequestMethod.POST )
	public void userHead( HttpServletRequest request, HttpServletResponse response )
	{
		System.out.println( "收到图片!" );
		MultipartHttpServletRequest	Murequest	= (MultipartHttpServletRequest) request;
		Map<String, MultipartFile>	files = Murequest.getFileMap();       /* 得到文件map对象 */
		String	upaloadUrl	= System.getProperty( "evan.webappvillage" ) + "..\\img\\";
		File  dir  = new File( upaloadUrl );
		System.out.println( upaloadUrl );
		String	img_url = upaloadUrl;                                                   /* 图片路径 */
		Format	format	= new SimpleDateFormat( "yyyyMMdd" );
		String	data	= "";
		int	intFlag = 0;
		String	image	= "";
		String	time	= "";
		if ( !dir.exists() )                                                            /* 目录不存在则创建 */
			dir.mkdirs();
		for ( MultipartFile file : files.values() )
		{
			/* String fileName = file.getOriginalFilename(); */
			data		= format.format( new Date() );
			intFlag		= (int) (Math.random() * 1000000);
			image		= String.valueOf( intFlag );
			time		= String.valueOf( new Date().getTime() );       /* 时间�? */
			upaloadUrl	= img_url;
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
		}
		System.out.println( upaloadUrl );
	}
}
