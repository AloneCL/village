package zm.village.dao;

/**
 * @author 李子帆
 * @version 1.0
 * @date 2018年7月13日
 * @Description 土地类 
 */
public class Land implements java.io.Serializable {
	
	private static final long serialVersionUID = -575600090172124355L;
	
	//土地在数据库ID，对应land_id
	private Integer id;
	//土地所有者，对应land_user_id
	private User ownerUser;
	//土地名称，对应land_name
	private String name;
	//土地类型，对应land_type
	private Integer type;
	//土地大小，对应land_size
	private Double size;
	//土地未使用大小，对应land_unused_size
	private Double unusedSize;
	//土地简介，对应land_introduce
	private String introduce;
	//是否整块出售,true代表只可整块出售，对应land_split
	private boolean split;
	//该土地的状态，是否可种植，对应land_status
	private Integer status;
	
	public Land() {
	}
	
	public Land(User ownerUser, String name, Integer type, Double size, String introduce, 
			Integer status, boolean split) {
		this.ownerUser = ownerUser;
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
	public User getOwnerUser() {
		return ownerUser;
	}
	public void setOwnerUser(User ownerUser) {
		this.ownerUser = ownerUser;
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
}
