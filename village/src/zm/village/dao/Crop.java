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
	
	//rel_land_id
	private Integer id;
	//作物所属土地，对应rel_land_type
	private Land land;
	//作物名称，对应rel_land_crop_type
	private CropDir crop;
	//作物单位价格，对应rel_land_crop_price
	private Double price;
	//可种植的最早时间，对应rel_land_crop_starttime
	private Timestamp startTime;
	//可种植的最晚时间，对应rel_land_crop_endtime
	private Timestamp endTime;
	 
	public Crop() {
	}
	
	public Crop(Land land, CropDir crop, Double price, Timestamp startTime, Timestamp endTime) {
		this();
		this.land = land;
		this.price = price;
		this.endTime = endTime;
		this.startTime = startTime;
		this.setCrop(crop);
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

	public CropDir getCrop() {
		return crop;
	}

	public void setCrop(CropDir crop) {
		this.crop = crop;
	}
	
	
}
