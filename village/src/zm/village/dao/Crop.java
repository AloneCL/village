package zm.village.dao;

import java.sql.Timestamp;

/**
 * @author 李子帆
 * @version 1.0
 * @date 2018年7月13日 下午4:48:16
 * @Description 土地可种植(待售)的作物类，数据库对应rel_land_inf表
 */
public class Crop implements java.io.Serializable {
	
	private static final long serialVersionUID = 284382142246199178L;
	
	private Integer id;
	//作物所属土地
	private Land land;
	//作物名称
	private CropDir crop;
	//作物类型
	private Integer type;
	//作物单位价格
	private Double price;
	//可种植的最早时间
	private Timestamp startTime;
	//可种植的最晚时间
	private Timestamp endTime;
	
	public Crop() {
	}
	
	public Crop(Land land, Integer type, Double price, Timestamp startTime, Timestamp endTime) {
		this();
		this.land = land;
		this.price = price;
		this.endTime = endTime;
		this.startTime = startTime;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Land getLand() {
		return land;
	}
	public void setLand(Land land) {
		this.land = land;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	
}
