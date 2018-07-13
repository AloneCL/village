package zm.village.dao;

import java.sql.Timestamp;

import zm.village.util.tools.SystemTimeUtil;

/**
 * @author 李子帆
 * @version 1.0
 * @date 2018年7月13日 下午4:14:10
 * @Description 订单类
 */
public class Order implements java.io.Serializable {

	private static final long serialVersionUID = -6806008044919906557L;
	
	//订单状态常量
	//新创建订单
	public static final int STATUS_NEW = 0;
	//正在种植(农民接单后改为该状态)
	public static final int STATUS_PLANT = 1;
	//订单已完成
	public static final int STATUS_FINISH = 2;

	//order_id
	private Integer id;
	//订单号码，对应order_uuid
	private String uuid;
	//订单创建时间，对应order_time
	private Timestamp createTime;
	//订单完成时间，对应order_finishtime
	private Timestamp finishTime;
	//订单种植面积，对应order_plant_size
	private Double plantSize;
	//订单中包含的作物种类数量，对应order_crop_num
	private Integer cropNum;
	//订单中已完成的作物种类数量，对应order_finishcrop_num
	private Integer finishCropNum;
	//订单状态，对应order_status
	private Integer status;
	//订单收货地址，对应order_address
	private String address;
	//订单成交总额，对应order_price
	private Double price; 
	//订单备注，对应order_remark
	private String remark;
	//买家，对应order_buyuser_id
	private User buyer;
	//卖家(农民)，对应order_selluser_id
	private User seller;
	//所属土地，对应order_land_id
	private Land land;
	//卖家(农民)昵称，对应order_selluser_name
	private String sellerName;
	//卖家(农民)电话，对应order_selluser_tel
	private String sellerTel;

	public Order() {
		this.createTime = SystemTimeUtil.getTime();
		this.finishCropNum = 0;
		// TODO 订单号码生成
	}

	public Order(User buyer, User seller, Land land, Double plantSize,Integer cropNum, String address, 
			Double price, String remark) {
		this();
		this.status = STATUS_NEW;
		this.buyer = buyer;
		this.seller = seller;
		this.land = land;
		this.plantSize = plantSize;
		this.cropNum = cropNum;
		this.address = address;
		this.price = price;
		this.remark = remark;
		this.sellerName = seller.getName();
		this.sellerTel = seller.getTelephone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getCropNum() {
		return cropNum;
	}

	public void setCropNum(Integer cropNum) {
		this.cropNum = cropNum;
	}

	public Integer getFinishCropNum() {
		return finishCropNum;
	}

	public void setFinishCropNum(Integer finishCropNum) {
		this.finishCropNum = finishCropNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerTel() {
		return sellerTel;
	}

	public void setSellerTel(String sellerTel) {
		this.sellerTel = sellerTel;
	}

	public Double getPlantSize() {
		return plantSize;
	}

	public void setPlantSize(Double plantSize) {
		this.plantSize = plantSize;
	}
}
