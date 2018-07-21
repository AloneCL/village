package zm.village.dao;

import java.sql.Timestamp;

import zm.village.util.tools.SystemTimeUtil;

/**
 * @author 李子帆
 * @version 1.0
 * @date 2018年7月13日 下午4:38:36
 * @Description 子订单类,数据库对应orderson_inf表
 */
public final class OrderSon implements java.io.Serializable {

	private static final long serialVersionUID = 1150189979015832462L;
	
	public static final String URL_SPERATOR = "&&&";
	//尚未开始种植
	public static final int STATUS_NEW = 0;
	//已开始种植
	public static final int STATUS_PLANT = 1;
	//已完成
	public static final int STATUS_FINISH = 2;

	//orderson_id
	private Integer id;
	//父订单，对应orderson_order_id
	private Integer sourceOrderId;
	//所属土地，对应orderson_land_id
	private Integer landId;
	//该子订单作物或养殖品种在数据字典中对应的ID，对应orderson_dir
	private Integer dirId;
	//种植面积，对应orderson_size
	private Double plantSize;
	//种植附加价，orderson_price
	private Double price;
	//子订单状态，对应orderson_status
	private Integer status;
	//子订单完成状况图片URL(由农民负责上传)，对应orderson_img
	private String imgURL;
	//开始时间，对应orderson_expecttime
	private Timestamp startTime;
	//预计完成时间，对应orderson_expecttime
	private Timestamp expectTime;
	//实际完成时间，对应orderson_finishtime
	private Timestamp finishTime;
	 
	public OrderSon() {
	}
	
	public OrderSon(Integer sourceId, Integer landId, Integer dirId, Double plantSize, Timestamp expectTime) {
		this();
		this.sourceOrderId = sourceId;
		this.landId = landId;
		this.dirId = dirId;
		this.plantSize = plantSize;
		this.expectTime = expectTime;
		this.startTime = SystemTimeUtil.getTime();
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
	 * 获取父订单对象
	 * @sql orderson_order_id
	 * @return Order对象
	 */
	public Integer getSourceOrderId() {
		return sourceOrderId;
	}

	/**
	 * 设置父订单对象
	 * @sql orderson_order_id
	 * @param sourceOrder Order对象
	 */
	public void setSourceOrderId(Integer sourceOrderId) {
		this.sourceOrderId = sourceOrderId;
	}

	/**
	 * 获取该子订单所属的土地
	 * @sql orderson_land_id
	 * @return Land对象
	 */
	public Integer getLandId() {
		return landId;
	}

	/**
	 * 设置该子订单所属的土地
	 * @sql orderson_land_id
	 * @param land Land对象
	 */
	public void setLandId(Integer landId) {
		this.landId = landId;
	}

	/**
	 * 获取该作物在数据字典中的信息
	 * @sql orderson_dir_id
	 * @return Dictionary对象
	 */
	public Integer getDirId() {
		return dirId;
	}

	/**
	 * 设置该作物数据字典中的信息
	 * @sql orderson_dir_id
	 * @param dict Dictionary对象
	 */
	public void setDirId(Integer dirId) {
		this.dirId = dirId;
	}

	/**
	 * 获取种植面积
	 * @sql orderson_size
	 * @return Double
	 */
	public Double getPlantSize() {
		return plantSize;
	}

	/**
	 * 设置种植面积
	 * @sql orderson_size
	 * @param plantSize
	 */
	public void setPlantSize(Double plantSize) {
		this.plantSize = plantSize;
	}

	/**
	 * 获取子订单状态
	 * @sql orderson_status
	 * @return Integer类型状态，0代表新建状态，1代表种植状态，2代表已完成
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置种植状态
	 * @param status Integer类型状态，
	 * STATUS_NEW 代表新建状态，STATUS_PLANT代表种植状态，STATUS_FINISH 代表已完成
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取农民上传的图片URL集合，建议调用getImgURLArray()
	 * @sql orderson_img
	 * @return URL集合
	 */
	@Deprecated
	public String getImgURL() {
		return imgURL;
	}
	
	/**
	 * 获取农民上传的图片URL数组
	 * @sql orderson_img
	 * @return String[] 数组
	 */
	public String[] getImgURLArray() {
		return imgURL.split(URL_SPERATOR);
	}

	/**
	 * 设置农民上传的图片URL，建议调用setImgURL()
	 * @sql orderson_img
	 * @param imgUrl
	 */
	@Deprecated
	public void setImgURL(String imgUrl) {
		this.imgURL = imgUrl;
	}
	
	/**
	 * 添加图片URL
	 * @sql orderson_img
	 * @param imgURL 图片URL路径
	 */
	public void addImgURL(String imgURL) {
		if(this.imgURL == null)
			this.imgURL = imgURL;
		else
			this.imgURL += URL_SPERATOR + imgURL;
	}

	/**
	 * 获取下单时间
	 * @sql orderson_starttime
	 * @return java.sql.Timestamp实例
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * 设置下单时间
	 * @sql orderson_starttime
	 * @param startTime java.sql.Timestamp实例
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * 获取预计完成时间
	 * @sql orderson_expecttime
	 * @return java.sql.Timestamp实例
	 */
	public Timestamp getExpectTime() {
		return expectTime;
	}

	/**
	 * 设置预计完成时间
	 * @sql orderson_expecttime
	 * @param expectTime
	 */
	public void setExpectTime(Timestamp expectTime) {
		this.expectTime = expectTime;
	}

	/**
	 * 获取完成时间
	 * @sql orderson_finishtime
	 * @return java.sql.Timestamp实例
	 */
	public Timestamp getFinishTime() {
		return finishTime;
	}

	/**
	 * 设置完成时间
	 * @sql orderson_finishtime
	 * @param finishTime java.sql.Timestamp实例
	 */
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
