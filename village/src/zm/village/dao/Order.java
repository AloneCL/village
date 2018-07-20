package zm.village.dao;

import java.sql.Timestamp;

import zm.village.util.tools.SystemTimeUtil;

/**
 * @author 李子帆
 * @version 1.0
 * @date 2018年7月13日 下午4:14:10
 * @Description 订单类 
 */
public final class Order implements java.io.Serializable {

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
	
	//订单完成时间，对应order_finish_time
	private Timestamp finishTime;
	
	//订单种植面积，对应order_plant_size
	private Double plantSize;
	
	//订单中包含的子订单数量，对应order_crop_num
	private Integer num;
	
	//订单中已完成的子订单数量，对应order_finishcrop_num
	private Integer finishNum;
	
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
		this.finishNum = 0;
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
		this.num = cropNum;
		this.address = address;
		this.price = price;
		this.remark = remark;
		this.sellerName = seller.getName();
		this.sellerTel = seller.getTelephone();
	}

	public Integer getId() {
		return id;
	}
	
	@Deprecated
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @sql order_uuid
	 * @return 订单编号
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * 调用setUUID()自动生成订单编号
	 * @param uuid 订单编号
	 */
	@Deprecated
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	/**
	 * @sql order_uuid
	 * 设置订单编号(时间戳)
	 */
	public void setUUID() {
		this.uuid = String.valueOf(System.currentTimeMillis());
	}
	
	/**
	 * @sql order_time
	 * @return 订单创建时间
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @sql order_time
	 * @param createTime 订单创建时间
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @sql order_finish_time
	 * @return 订单完成时间
	 */
	public Timestamp getFinishTime() {
		return finishTime;
	}

	/**
	 * @sql order_finish_time
	 * @param finishTime 订单完成时间
	 */
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * @sql order_num
	 * @return 子订单的数量
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param cropNum 子订单的数量
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * @return 已完成的子订单数量
	 */
	public Integer getFinishNum() {
		return finishNum;
	}

	/**
	 * 建议调用addFinishNum()
	 * @param finishNum 已完成子订单数量
	 */
	public void setFinishNum(Integer finishNum) {
		this.finishNum = finishNum;
	}

	/**
	 * 增加已完成的子订单
	 */
	public void addFinishNum() {
		this.finishNum++;
	}
	
	/**
	 * @return 订单状态，0表示新订单、1表示农民接单并已开始、2表示订单完成
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置订单状态
	 * @param status 调用Order静态常量设置
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return 收货地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address 收货地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return 订单总成交价
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price 订单成交价
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return 订单备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark 订单备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return 买家User对象
	 */
	public User getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer 买家User对象
	 */
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	/**
	 * @return 卖家User对象
	 */
	public User getSeller() {
		return seller;
	}

	/**
	 * @param seller 卖家User对象
	 */
	public void setSeller(User seller) {
		this.sellerName = seller.getName();
		this.sellerTel = seller.getTelephone();
		this.seller = seller;
	}

	/**
	 * @return 订单所属的土地对象
	 */
	public Land getLand() {
		return land;
	}

	/**
	 * @param land 订单所属的土地对象
	 */
	public void setLand(Land land) {
		this.land = land;
	}

	/**
	 * @return 卖家昵称
	 */
	public String getSellerName() {
		return sellerName;
	}

	/**
	 * 该属性会由setSeller自动设置
	 * @param sellerName 卖家昵称
	 */
	@Deprecated
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	/**
	 * @return 卖家昵称
	 */
	public String getSellerTel() {
		return sellerTel;
	}

	/**
	 * @param sellerTel 卖家用户名(联系电话)
	 */
	@Deprecated
	public void setSellerTel(String sellerTel) {
		this.sellerTel = sellerTel;
	}

	/**
	 * @return 种植面积
	 */
	public Double getPlantSize() {
		return plantSize;
	}

	/**
	 * @param plantSize 总订单种植面积
	 */
	public void setPlantSize(Double plantSize) {
		this.plantSize = plantSize;
	}
}
