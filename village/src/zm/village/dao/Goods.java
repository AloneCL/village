package zm.village.dao;
/**
* @author 李子帆
* @version 1.0
* @date 2018年7月20日 下午7:37:30
* @Description 农产品类，对应goods_inf表
*/
public final class Goods implements java.io.Serializable {

	private static final long serialVersionUID = -1718215257492370339L;
	
	public static final String ADDRESS_SPERATOR = "&&&";
	
	//goods_id
	private Integer id;
	
	//农产品名称，goods_name
	private String name;
	
	//农产品价格，goods_price
	private Double price;
	
	//农产品是否包邮及包邮策略(最低斤数)，goods_post
	private Integer post;
	
	//农产品简要介绍，goods_introduce
	private String introduce;
	
	//农产品图片URL，goods_img
	private String imgURL;
	
	//农产品所属的农民(卖家), goods_user
	private User user;

	public Integer getId() {
		return id;
	}
	
	@Deprecated
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return 农产品名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 农产品名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 农产品价格
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price 农产品价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return 农产品是否包邮及包邮策略(最低斤数)
	 */
	public Integer getPost() {
		return post;
	}

	/**
	 * @param post 农产品是否包邮及包邮策略(最低斤数)
	 */
	public void setPost(Integer post) {
		this.post = post;
	}

	/**
	 * @return 农产品介绍
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * @param introduce 农产品介绍
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * 建议调用getImgURLArray()
	 * @return 上传的农产品图片URL集合
	 */
	@Deprecated
	public String getImgURL() {
		return imgURL;
	}
	
	public String[] getImgURLArray() {
		return imgURL.split(ADDRESS_SPERATOR);
	}

	/**
	 * @param imgURL 农产品图片URL集合
	 */
	@Deprecated
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	/**
	 * @param imgURL 添加的商品图片
	 */
	public void addImgURL(String imgURL) {
		if(this.imgURL == null || this.imgURL.equals("")) {
			this.imgURL = imgURL;
		} else {
			this.imgURL += ADDRESS_SPERATOR + imgURL;
		}
	}
	
	/**
	 * @param imgURL 需要移除的商品图片URL
	 */
	public void removeImgURL(String remove) {
		String[] urlArray = getImgURLArray();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < urlArray.length; i++) {
			if(urlArray[i].equals(remove)) {
				continue;
			}
			if(i == urlArray.length - 1) {
				sb.append(urlArray[i]);
				continue;
			}
			sb.append(urlArray[i] + ADDRESS_SPERATOR);
		}
		this.imgURL = sb.toString();
	}

	/**
	 * @return 商品所属的农民
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param user 商品所属的农民
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
