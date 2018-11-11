package zm.village.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 用户实体类
 * @version 1.0
 */

public final class User implements java.io.Serializable {

	private static final long serialVersionUID = -395141608464880627L;

	public static final String ADDRESS_SPERATOR = "&&&";

	public static final int TYPE_SELLER = 0;
	public static final int TYPE_BUYER = 1;

	// 用户ID，对应user_id
	private Integer id;

	// 手机号码，对应user_tel
	private String telephone;

	// 密码，对应user_pass
	private String password;

	// 用户头像在服务器上的存储路径，对应user_img
	private String imagePath;

	// 用户昵称，对应user_name
	private String name;

	//用户地址_省,user_province
	private String province;
	
	//用户地址_市,user_city
	private String city;
	
	//用户地址_区,user_district
	private String district;
	
	// 用户所在详细地址，对应user_address
	private String address;

	// 注册时间，对应user_regtime
	private Timestamp regTime;

	// 用户类型，0代表农民，1代表买家，对应user_type
	private Integer userType;

	// 用户真实姓名(供农民身份验证使用),对应user_real_name
	private String realName;

	// 用户身份证号(供农民身份验证使用),对应user_id_card_number
	private String idCardNumber;

	// 用户星级，对应user_starlevel
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

	/**
	 * 获取数据库ID
	 * 
	 * @return Integer类型
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 不要调用
	 */
	@Deprecated
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取用户手机号码(帐号)
	 * 
	 * @sql user_tel
	 * @return String类型电话号码
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 设置用户手机号码(帐号)
	 * 
	 * @sql user_tel
	 * @param telephone
	 *            手机号码字符串
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 获取用户密码
	 * 
	 * @sql user_pass
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置用户密码
	 * 
	 * @sql user_pass
	 * @param password
	 *            用户密码字符串
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取用户头像存储URL
	 * 
	 * @sql user_img
	 * @return URL字符串
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * 设置用户头像存储路径
	 * 
	 * @sql user_img
	 * @param imagePath
	 *            存储路径URL字符串
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/**
	 * 获取用户昵称
	 * 
	 * @sql user_name
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置用户昵称
	 * 
	 * @sql user_name
	 * @param name
	 *            用户昵称
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/**
	 * 获得用户省份 
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 修改用户地址省份 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 获得用户地址城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 修改用户土地地址城市 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获得用户地址市区
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * 修改用户土地地址市区
	 * @param district
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	

	/**
	 * 获取用户所在地集合
	 * 
	 * @sql user_address
	 * @return 用户所在地集合
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置用户所在地
	 * 
	 * @sql user_address
	 * @param 用户所在地
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取注册时间
	 * 
	 * @sql user_regtime
	 * @return java.sql.Timestamp 类型
	 */
	public String getRegTime() {
		if(regTime==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(regTime);
	}

	/**
	 * 设置注册时间
	 * 
	 * @sql user_regtime
	 * @param regTime
	 */
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	/**
	 * 获取用户类型
	 * 
	 * @sql user_type
	 * @return Integer类型，0表示农民，1表示买家
	 */
	public Integer getUserType() {
		return userType;
	}

	/**
	 * 设置用户类型
	 * 
	 * @sql user_type
	 * @param userType
	 *            User.TYPE_SELLER(农民) User.TYPE_BUYER(买家)
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	/**
	 * 获取评价星级
	 * 
	 * @sql user_starlevel
	 * @return Double类型 范围0.0~5.0
	 */
	public Double getStarLevel() {
		return starLevel;
	}

	/**
	 * 设置评价星级
	 * 
	 * @sql user_starlevel
	 * @param starLevel
	 *            Double类型 范围0.0~5.0
	 */
	public void setStarLevel(Double starLevel) {
		this.starLevel = starLevel;
	}

	/**
	 * 获取用户真实姓名，一般用于农民身份验证
	 * 
	 * @sql user_real_name
	 * @return String
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 设置真实姓名
	 * 
	 * @sql user_real_name
	 * @param realName
	 *            真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 获取身份证号码
	 * 
	 * @sql user_id_card_number
	 * @return 身份证号码字符串
	 */
	public String getIdCardNumber() {
		return idCardNumber;
	}

	/**
	 * 设置身份证号码
	 * 
	 * @sql user_id_card_number
	 * @param idCardNumber
	 *            身份证号码字符串
	 */
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String toString() {
		return "User[id=" + id + ",telephone=" + telephone + ",password=" + password + ",imagePath=" + imagePath
				+ ",name=" + name + ",regTime=" + regTime
				+ ",userType=" + userType + ",realName=" + realName + ",idCardNumber=" + idCardNumber + ",starLevel="
				+ starLevel + ",province="+ province +",city="+ city +",district="+ district +",address="+ address+ "]";
	}
}
