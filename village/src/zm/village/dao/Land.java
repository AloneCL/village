package zm.village.dao;

/**
 * @author 李子帆
 * @version 1.0
 * @date 2018年7月13日
 * @Description 土地类
 */
public class Land implements java.io.Serializable {
	
	private static final long serialVersionUID = -575600090172124355L;
	
	//土地在数据库ID
	private Integer id;
	//土地所有者
	private User ownerUser;
	//土地名称
	private String name;
	//土地类型
	private Integer type;
	//土地大小
	private Double size;
	//土地简介
	private String introduce;
	//该土地的状态，是否可种植
	private Integer status;
	
	public Land() {
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
}
