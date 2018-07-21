package zm.village.dao;

import java.sql.Timestamp;

import zm.village.util.tools.SystemTimeUtil;

/**
* @author 李子帆
* @version 1.0
* @date 2018年7月13日 下午5:46:23
* @Description 评论类,对应eva_inf表
*/
public final class Evaluate implements java.io.Serializable {

	private static final long serialVersionUID = 1558953088626824682L;
	
	public static final String URL_SPERATOR = "&&&";

	//eva_id
	private Integer id;
	//卖家(农民)信息，对应eva_seller_id
	private Integer sellerId;
	//买家信息，对应eva_buyer_id
	private Integer buyerId;
	//买家昵称，对应eva_buyer_name
	private String buyerName;
	//评论内容，对应eva_content
	private String content;
	//评论生成时间，对应eva_time
	private Timestamp createTime;
	//买家给予的好评度，对应eva_starlevel
	private Integer star;
	//买家上传的图片URL集合(可选)，对应eva_img
	private String imgURL;
	//农民对评价的回复，对应eva_response
	private String response;
	
	public Evaluate() {
	}
	
	public Evaluate(Integer sellerId, Integer buyerId, String content, Integer star) {
		this();
		this.createTime = SystemTimeUtil.getTime();
		this.content = content;
		this.star = star;
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
	 * 获取农民的User对象
	 * @sql eva_seller_id
	 * @return User对象
	 */
	public Integer getSellerId() {
		return sellerId;
	}
	
	/**
	 * 设置农民User对象
	 * @sql eva_seller_id
	 * @param seller User对象
	 */
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	
	/**
	 * 获取买家User对象
	 * @sql eva_buyer_id
	 * @return 买家User对象
	 */
	public Integer getBuyerId() {
		return buyerId;
	}
	
	/**
	 * 设置评论对应的买家对象
	 * @sql eva_buyer_id
	 * @param buyer User对象
	 */
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	
	/**
	 * 获取买家的昵称
	 * @sql eva_buyer_name
	 * @param buyerId User对象
	 */
	public String getBuyerName() {
		return buyerName;
	}
	
	/**
	 * @sql eva_buyer_name
	 * @param buyerName
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	/**
	 * 获取评论内容
	 * @sql eva_content
	 * @return 评论内容字符串
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置评论内容
	 * @sql eva_content
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取该评论的星级
	 * @sql eva_starlevel
	 * @return Integer类型 范围1~5
	 */
	public Integer getStar() {
		return star;
	}
	
	/**
	 * 设置该评论的星级
	 * @sql eva_starlevel
	 * @param star Integer类型 范围1~5
	 */
	public void setStar(Integer star) {
		this.star = star;
	}
	
	/**
	 * 获取评论图片的所有URL集合
	 * 不要调用该方法，应调用getImgURLArray获取所有图片的String数组
	 * @sql eva_img
	 * @return URL集合
	 */
	@Deprecated
	public String getImgURL() {
		return imgURL;
	}
	
	/**
	 * 获取评论图片的所有URL字符串数组
	 * @sql eva_img
	 * @return String类型数组
	 */
	public String[] getImgURLArray() {
		return imgURL.split(URL_SPERATOR);
	}
	
	/**
	 * 设置评论图片的所有URL集合
	 * 不要调用该方法，应调用addImgURL
	 * @sql eva_img
	 * @return URL集合
	 */
	@Deprecated
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	/**
	 * 添加图片URL
	 * @sql eva_img
	 * @param imgURL 图片URL路径
	 */
	public void addImgURL(String imgURL) {
		if(this.imgURL == null)
			this.imgURL = imgURL;
		else
			this.imgURL += URL_SPERATOR + imgURL;
	}
	
	/**
	 * 获取评论创建的时间
	 * @sql eva_time
	 * @return java.sql.Timestamp对象
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * 设置评论创建时间
	 * @sql eva_time
	 * @param createTime java.sql.Timestamp对象
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取农民回复评论的字符串
	 * @sql eva_response
	 * @return String类型字符串
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * 设置农民回复
	 * @sql eva_response
	 * @param response 农民回复内容
	 */
	public void setResponse(String response) {
		this.response = response;
	}
}
