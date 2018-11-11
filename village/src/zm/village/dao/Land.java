package zm.village.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 土地类
 * @version 1.0
 */

public final class Land implements java.io.Serializable {
	
	private static final long serialVersionUID = -575600090172124355L;
	
	//土地在数据库ID，对应land_id
	private Integer id;
	//土地所有者，对应land_user_id
	private Integer userId;
	//土地名称，对应land_name
	private String name;
	//土地类型，对应land_type
	private Integer type;
	//土地地址_省,land_province
	private String province;
	//土地地址_市,land_city
	private String city;
	//土地地址_区,land_district
	private String district;
	//土地详细地址,land_address
	private String address;
	//土地大小，对应land_size
	private Double size;
	//土地未使用大小，对应land_unused_size
	private Double unusedSize;
	//土地基本价格，land_basic_price
	private Double basicPrice;
	//土地简介，对应land_introduce
	private String introduce;
	//是否整块出售,true代表只可整块出售，对应land_split
	private Integer split;
	//土地最小租赁面积, land_min_lease
	private String minLease;
	//土地图片URL集合,land_picture
	private String imgURL;
	//土地证书图片URL，land_certificateURL
	private String certificateURL;
	//该土地的状态，是否可种植，对应land_status
	private Integer status;
	//最早时间，对应land_starttime
	private Timestamp startTime;
	//最晚时间，对应land_endtime
	private Timestamp endTime;
	//土地纬度，对应land_latitude
	private Double latitude;
	//土地经度，对应land_longitude
	private Double longitude;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 租土地的人
	 * @return 用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param 用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return 土地名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 修改土地名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return 土地类型
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 修改土地类型
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获得土地地址省份 
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 修改土地土地地址省份 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 获得土地地址城市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 修改土地土地地址城市 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获得土地地址市区
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * 修改土地土地地址市区
	 * @param district
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * 获得土地详细地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 修改土地土地详细地址
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return 土地大小
	 */
	public Double getSize() {
		return size;
	}

	/**
	 * 修改土地大小
	 * @param size
	 */
	public void setSize(Double size) {
		this.size = size;
	}

	/**
	 * @return 未使用的土地大小
	 */
	public Double getUnusedSize() {
		return unusedSize;
	}

	/**
	 * 修改未使用土地大小
	 * @param unusedSize 
	 */
	public void setUnusedSize(Double unusedSize) {
		this.unusedSize = unusedSize;
	}

	/**
	 * @return 土地基础价格
	 */
	public Double getBasicPrice() {
		return basicPrice;
	}

	/**
	 * 修改土地基础价格
	 * @param basicPrice
	 */
	public void setBasicPrice(Double basicPrice) {
		this.basicPrice = basicPrice;
	}

	/**
	 * @return 土地介绍
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * 修改土地介绍
	 * @param introduce
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * @return 是否整块出售
	 */
	public Integer getSplit() {
	
	 return split;
	}
	

	/**
	 * 修改是否整块出售
	 * @param split
	 */
	public void setSplit(Integer split) {
		this.split = split;
	}

	/**
	 * @return 最小租赁面积
	 */
	public String getMinLease() {
		return minLease;
	}

	/**
	 * 修改最小租赁面积
	 * @param minLease
	 */
	public void setMinLease(String minLease) {
		this.minLease = minLease;
	}

	/**
	 * @return 土地图片URL集合
	 */
	public String getImgURL() {
		return imgURL;
	}

	/**
	 * 修改土地URL集合
	 * @param imgURL
	 */
	public void setImgURL(String imgURL) {
	
		this.imgURL = imgURL;
	}

	/**
	 * @return 土地证书URL集合
	 */
	public String getCertificateURL() {
		return certificateURL;
	}

	/**
	 * 修改土地证书URL集合
	 * @param certificateURL
	 */
	public void setCertificateURL(String certificateURL) {
		this.certificateURL = certificateURL;
	}

	/**
	 * @return 土地状态，是否可种植
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 修改土地是否可种植
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取土地最早时间
	 * @return java.sql.Timestamp时间对象
	 */
	public String getStartTime() {
		if(startTime==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(startTime);
	}
	
	/**
	 * 设置土地最早时间
	 * @param startTime java.sql.Timestamp时间对象
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 获取土地最晚时间
	 * @return java.sql.Timestamp时间对象
	 */
	public String getEndTime() {
		if(endTime==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(endTime);
	}
	
	/**
	 * 设置土地最晚耕种时间
	 * @param startTime java.sql.Timestamp时间对象
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 获取土地纬度
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * 设置土地纬度
	 * @param Double latitude
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 获取土地经度
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * 设置土地经度
	 * @param Double longitude
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Land [id=" + id + ", userId=" + userId + ", name=" + name + ", type=" + type
				+",province="+ province +",city="+ city +",district="+ district +",address="+ address +
				", size=" + size + ", unusedSize=" + unusedSize + ",basicPrice="+basicPrice+ ", introduce=" 
				+ introduce +",minLease="+minLease +", split=" + split + ",imgURL="+ imgURL + 
				",certificateURL="+certificateURL +", status=" + status + ",startTime="+startTime +
				",endTime="+endTime+",latitude="+latitude+",longitude="+longitude+"]";
	}
}
