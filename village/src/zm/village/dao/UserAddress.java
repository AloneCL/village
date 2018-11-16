package zm.village.dao;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 用户对应地址实体类
 * @version 1.0
 */
public class UserAddress {

	//唯一识别,主键
	private Integer id;

	//对应的用户ID，外键
	private Integer userId;
	
	// 手机号码，对应user_name
	private String name;
	
	// 手机号码，对应user_address_tel
	private String telephone;

	// 用户地址_省,user_address_province
	private String province;

	// 用户地址_市,user_address_city
	private String city;

	// 用户地址_区,user_address_district
	private String district;

	// 用户所在详细地址，对应user_address_address
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
