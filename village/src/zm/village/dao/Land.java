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
	private boolean split;
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
			Integer status, boolean split) {
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
	public Integer getUserId() {
		return userId;
	}
	public void setOwnerUser(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getUnusedSize() {
		return unusedSize;
	}

	public void setUnusedSize(Double unusedSize) {
		this.unusedSize = unusedSize;
	}

	public boolean isSplit() {
		return split;
	}

	public void setSplit(boolean split) {
		this.split = split;
	}

	@Override
	public String toString() {
		return "Land [id=" + id + ", ownerUser=" + userId + ", name=" + name + ", type=" + type + ", size=" + size
				+ ", unusedSize=" + unusedSize + ", introduce=" + introduce + ", split=" + split + ", status=" + status
				+ "]";
	}

	public String getCertificateURL() {
		return certificateURL;
	}

	public void setCertificateURL(String certificateURL) {
		this.certificateURL = certificateURL;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getMinLease() {
		return minLease;
	}

	public void setMinLease(String minLease) {
		this.minLease = minLease;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(Double basicPrice) {
		this.basicPrice = basicPrice;
	}
}
