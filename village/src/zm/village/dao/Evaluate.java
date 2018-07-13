package zm.village.dao;

import java.sql.Timestamp;

import zm.village.util.tools.SystemTimeUtil;

/**
* @author 李子帆
* @version 1.0
* @date 2018年7月13日 下午5:46:23
* @Description 评论类，对应eva_inf表
*/
public class Evaluate implements java.io.Serializable {

	private static final long serialVersionUID = 1558953088626824682L;

	//eva_id
	private Integer id;
	//卖家(农民)信息，对应eva_seller_id
	private User seller;
	//买家信息，对应eva_buyer_id
	private User buyer;
	//买家昵称，对应eva_buyer_name
	private String buyerName;
	//评论内容，对应eva_content
	private String content;
	//评论生成时间，对应eva_time
	private Timestamp createTime;
	//买家给予的好评度，对应eva_starlevel
	private Integer star;
	//买家上传的图片(可选)，对应eva_img1_url
	private String imgUrl1;
	//对应eva_img2_url
	private String imgUrl2;
	//对应eva_img3_url
	private String imgUrl3;
	
	public Evaluate() {
	}
	
	public Evaluate(User seller, User buyer, String content, Integer star) {
		this();
		this.seller = seller;
		this.buyer = buyer;
		this.createTime = SystemTimeUtil.getTime();
		this.buyerName = buyer.getName();
		this.content = content;
		this.star = star;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getSeller() {
		return seller;
	}
	
	public void setSeller(User seller) {
		this.seller = seller;
	}
	
	public User getBuyer() {
		return buyer;
	}
	
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
	public String getBuyerName() {
		return buyerName;
	}
	
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getStar() {
		return star;
	}
	
	public void setStar(Integer star) {
		this.star = star;
	}
	
	public String getImgUrl1() {
		return imgUrl1;
	}
	
	public void setImgUrl1(String imgUrl1) {
		this.imgUrl1 = imgUrl1;
	}
	
	public String getImgUrl2() {
		return imgUrl2;
	}
	
	public void setImgUrl2(String imgUrl2) {
		this.imgUrl2 = imgUrl2;
	}
	
	public String getImgUrl3() {
		return imgUrl3;
	}
	
	public void setImgUrl3(String imgUrl3) {
		this.imgUrl3 = imgUrl3;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
