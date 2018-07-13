package zm.village.dao;

import java.sql.Timestamp;

import zm.village.util.tools.SystemTimeUtil;

/**
 * @author 李子帆
 * @version 1.0
 * @date 2018年7月13日 下午4:38:36
 * @Description 子订单类，每种作物对应一个OrderCrop，数据库对应ordercrop_inf表
 */
public class OrderCrop implements java.io.Serializable {

	private static final long serialVersionUID = 1150189979015832462L;
	
	//尚未开始种植
	public static final int STATUS_NEW = 0;
	//已开始种植
	public static final int STATUS_PLANT = 1;
	//已完成
	public static final int STATUS_FINISH = 2;

	//ordercrop_id
	private Integer id;
	//父订单，对应ordercrop_order_id
	private Order sourceOrder;
	//所属土地，对应ordercrop_land_id
	private Land land;
	//作物，对应ordercrop_crop_id
	private Crop crop;
	//种植面积，对应ordercrop_size
	private Double plantSize;
	//子订单状态，对应ordercrop_crop_status
	private Integer status;
	//子订单完成状况图片URL(由农民负责上传)，对应ordercrop_img_url
	private String imgUrl;
	//开始时间，对应ordercrop_expecttime
	private Timestamp startTime;
	//预计完成时间，对应ordercrop_expecttime
	private Timestamp expectTime;
	//实际完成时间，对应ordercrop_finishtime
	private Timestamp finishTime;
	 
	public OrderCrop() {
	}
	
	public OrderCrop(Order source, Land land, Crop crop, Double plantSize, Timestamp expectTime) {
		this();
		this.sourceOrder = source;
		this.land = land;
		this.crop = crop;
		this.plantSize = plantSize;
		this.expectTime = expectTime;
		this.startTime = SystemTimeUtil.getTime();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getSourceOrder() {
		return sourceOrder;
	}

	public void setSourceOrder(Order sourceOrder) {
		this.sourceOrder = sourceOrder;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Double getPlantSize() {
		return plantSize;
	}

	public void setPlantSize(Double plantSize) {
		this.plantSize = plantSize;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(Timestamp expectTime) {
		this.expectTime = expectTime;
	}

	public Timestamp getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
}
