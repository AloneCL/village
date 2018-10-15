package zm.village.dao;

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
	//土地地址,land_address
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
	
	public Land() {
	}
	
	public Land(Integer userId, String name, Integer type, Double size, String introduce, 
			Integer status, Integer split) {
		this.userId = userId;
		this.name = name;
		this.type = type;
		this.size = size;
		this.introduce = introduce;
		this.status = status;
		this.unusedSize = 0.0;
		this.split = split;
	}

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
	 * @return 土地地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 修改土地地址
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
	  
	@Override
	public String toString() {
		return "Land [id=" + id + ", userId=" + userId + ", name=" + name + ", type=" + type
				+",address="+ address +", size=" + size + ", unusedSize=" + unusedSize 
				+ ",basicPrice="+basicPrice+ ", introduce=" + introduce +",minLease="+minLease 
				+", split=" + split + ",imgURL="+ imgURL + ",certificateURL="+certificateURL +
				", status=" + status + "]";
	}
}
