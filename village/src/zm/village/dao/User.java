package zm.village.dao;

import java.sql.Timestamp;

/**
* @author 李子帆
* @version 1.0
* @date 2018年7月13日 下午2:55:33
* @Description 用户实体类 
*/
public final class User implements java.io.Serializable {
	
	private static final long serialVersionUID = -395141608464880627L;
	
	public static final String ADDRESS_SPERATOR = "&&&";
	
	public static final int TYPE_SELLER = 0;
	public static final int TYPE_BUYER = 1;
	
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
	
	//用户收货地址集合,对应user_post_address
	private String postAddress;
	
	//注册时间，对应user_regtime
	private Timestamp regTime;
	
	//用户类型，0代表农民，1代表买家，对应user_type
	private Integer userType;
	
	//用户真实姓名(供农民身份验证使用),对应user_real_name
	private String realName;
	
	//用户身份证号(供农民身份验证使用),对应user_id_card_number
	private String idCardNumber;
	
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
	
	/**
	 * 获取数据库ID
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
	 * @sql user_tel
	 * @return String类型电话号码
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * 设置用户手机号码(帐号)
	 * @sql user_tel
	 * @param telephone 手机号码字符串
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * 获取用户密码
	 * @sql user_pass
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置用户密码
	 * @sql user_pass
	 * @param password 用户密码字符串
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取用户头像存储URL
	 * @sql user_img
	 * @return URL字符串
	 */
	public String getImagePath() {
		return imagePath;
	}
	
	/**
	 * 设置用户头像存储路径
	 * @sql user_img
	 * @param imagePath 存储路径URL字符串
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	/**
	 * 获取用户昵称
	 * @sql user_name
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置用户昵称
	 * @sql user_name
	 * @param name 用户昵称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取用户所在地集合
	 * @sql user_address
	 * @return 用户所在地集合
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置用户所在地
	 * @sql user_address
	 * @param 用户所在地
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 获取注册时间
	 * @sql user_regtime
	 * @return java.sql.Timestamp 类型
	 */
	public Timestamp getRegTime() {
		return regTime;
	}
	
	/**
	 * 设置注册时间
	 * @sql user_regtime
	 * @param regTime
	 */
	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	
	/**
	 * 获取用户类型
	 * @sql user_type
	 * @return Integer类型，0表示农民，1表示买家
	 */
	public Integer getUserType() {
		return userType;
	}
	
	/**
	 * 设置用户类型
	 * @sql user_type
	 * @param userType User.TYPE_SELLER(农民) User.TYPE_BUYER(买家)
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	/**
	 * 获取评价星级
	 * @sql user_starlevel
	 * @return Double类型 范围0.0~5.0
	 */
	public Double getStarLevel() {
		return starLevel;
	}
	
	/**
	 * 设置评价星级 
	 * @sql user_starlevel
	 * @param starLevel Double类型 范围0.0~5.0
	 */
	public void setStarLevel(Double starLevel) {
		this.starLevel = starLevel;
	}

	/**
	 * 获取用户真实姓名，一般用于农民身份验证
	 * @sql user_real_name
	 * @return String
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 设置真实姓名
	 * @sql user_real_name
	 * @param realName 真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 获取身份证号码
	 * @sql user_id_card_number
	 * @return 身份证号码字符串
	 */
	public String getIdCardNumber() {
		return idCardNumber;
	}

	/**
	 * 设置身份证号码
	 * @sql user_id_card_number
	 * @param idCardNumber 身份证号码字符串
	 */
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	/**
	 * 获取完整的收件地址集合
	 * @sql user_post_address
	 * @return String类型收货地址集合
	 */
	@Deprecated
	public String getPostAddress() {
		return postAddress;
	}

	/**
	 * 设置完整的收件地址集合，此方法一般用于MyBatis反射调用
	 * @sql user_post_address
	 * @param postAddress String类型收货地址集合
	 */
	@Deprecated
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	
	/**
	 * 添加收件地址，如果已经有设置的记录不会覆盖
	 * @sql user_post_address
	 * @param postAddress String类型收货地址
	 */
	public void addPostAddress(String newPostAddress) {
		if(this.postAddress == null || this.postAddress.equals("")) {
			this.postAddress = newPostAddress;
		} else {
			this.postAddress += ADDRESS_SPERATOR + newPostAddress;
		}
	}
	
	/**
	 * 获取该用户所有的收件地址数组，如果已经有设置的记录不会覆盖
	 * @sql user_post_address
	 * @return 包含该用户设置的收件地址数组
	 */
	public String[] getPostAddressArray() {
		return postAddress.split(ADDRESS_SPERATOR);
	}
	
	/**
	 * 移除收货地址
	 * @sql user_post_address
	 * @param 需要移除的收货地址
	 */
	public void removePostAddress(String remove) {
		String[] addressArray = getPostAddressArray();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < addressArray.length; i++) {
			if(addressArray[i].equals(remove)) {
				continue;
			}
			if(i == addressArray.length - 1) {
				sb.append(addressArray[i]);
				continue;
			}
			sb.append(addressArray[i] + ADDRESS_SPERATOR);
		}
		this.postAddress = sb.toString();
	}
}
