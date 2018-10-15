package zm.village.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 土地可种植(待售)的作物类
 * @version 1.0
 */

public final class Crop implements java.io.Serializable {
	
	private static final long serialVersionUID = 284382142246199178L;
	
	//rel_land_id
	private Integer id;
	//作物所属土地，对应rel_land_type
	private Integer landId;
	//作物名称，对应rel_land_crop_type
	private Integer dirId;
	//作物附加价格，对应rel_land_crop_price
	private Double price;
	//可种植的最早时间，对应rel_land_crop_starttime
	private Timestamp startTime;
	//可种植的最晚时间，对应rel_land_crop_endtime
	private Timestamp endTime;
	 
	public Crop() {
	}
	
	public Crop(Integer landId, Integer dirId, Double price, Timestamp startTime, Timestamp endTime) {
		this();
		this.landId = landId;
		this.price = price;
		this.endTime = endTime;
		this.startTime = startTime;
		this.dirId = dirId;
	}
	
	
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
	 * 获取对应的土地对象
	 * @return Land土地对象
	 */
	public Integer getLandId() {
		return landId;
	}
	
	/**
	 * 设置对应的土地对象
	 * @param land Land对象
	 */
	public void setLand(Integer landId) {
		this.landId = landId;
	}
	
	/**
	 * 获取附加价格
	 * @return Double类型价格
	 */
	public Double getPrice() {
		return price;
	}
	
	/**
	 * 设置附加价格
	 * @param price Double类型价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 获取作物耕种最早时间
	 * @return java.sql.Timestamp时间对象
	 */
	public String getStartTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(startTime);
	}
	
	/**
	 * 设置作物耕种最早时间
	 * @param startTime java.sql.Timestamp时间对象
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 获取作物耕种最晚时间
	 * @return java.sql.Timestamp时间对象
	 */
	public String getEndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(endTime);
	}
	
	/**
	 * 设置作物耕种最晚耕种时间
	 * @param startTime java.sql.Timestamp时间对象
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取作物类型
	 * @return Dictionary 数据字典对象
	 */
	public Integer getDirId() {
		return dirId;
	}
	
	/**
	 * 设置作物类型
	 * @param Dictionary 数据字典对象
	 */
	public void setDirId(Integer cropId) {
		this.dirId = cropId;
	}
	
	
	public String toString(){
		return"Crop[id="+id+",landId="+landId+",dirId="+dirId
				+",price="+price+",startTime="+startTime
				+",endTime="+endTime+"]";
	}
}
