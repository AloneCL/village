package zm.village.dao;

import java.sql.Timestamp;

/**
* @author 李子帆
* @version 1.0
* @date 2018年7月13日 下午2:55:33
* @Description 用户实体类
*/
public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = -395141608464880627L;
	
	public static final int TYPE_SELLER = 0;
	public static final int TYPE_BUYER = 1;
	public static final int TYPE_ADMIN = 2;
	
	//用户ID，对应user_id
	private Integer id;
	//手机号码，对应user_tel
	private String telephone;
	//密码，对应user_pass
	private String password;
	//用户头像在服务器上的存储路径，对应user_img
	private String imagePath;
	//用户昵称，对应user_name
	private String name;
	//用户所在地，对应user_address
	private String address;
	//注册时间，对应user_regtime
	private Timestamp regTime;
	//用户类型，0代表农民，1代表买家，2代表管理员，对应user_type
	private Integer userType;
	//用户星级，对应user_starlevel
	private Double starLevel;
	
	public User() {
	}
	
	public User(String telephone, String password, String name, String address, int userType) {
		this.telephone = telephone;
		this.password = password;
		this.name = name;
		this.address = address;
		this.starLevel = 3.0;
		this.userType = userType;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getRegTime() {
		return regTime;
	}
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Double getStarLevel() {
		return starLevel;
	}
	public void setStarLevel(Double starLevel) {
		this.starLevel = starLevel;
	}
}
