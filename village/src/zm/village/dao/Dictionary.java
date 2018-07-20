package zm.village.dao;
/**
* @author 李子帆
* @version 1.0
* @date 2018年7月13日 下午5:33:48
* @Description 数据字典，对应dir_inf表
*/
public final class Dictionary implements java.io.Serializable {

	private static final long serialVersionUID = -568746960463257557L;
	
	//dir_crop_id
	private Integer id;
	//类型，是作物、蔬菜还是家禽，对应dir_type
	private Integer type;
	//名称，对应dir_name
	private String name;
	//名词简介，参考百度百科
	private String introduce;
	//默认图片URL，对应dir_img
	private String imgURL;
	
	@Override
	public String toString() {
		return "[CropDir id = " + id + " , name = " + name + "]";
	}
	
	/**
	 * 获取数据库ID
	 * @return Integer类型
	 */
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
	 * 获取数据字典名称
	 * @sql dir_name
	 * @return String类型
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置数据字典名称
	 * @sql dir_name
	 * @param name String类型名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取这个数据字典所属的类型
	 * @sql dir_type
	 * @return Integer类型
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置这个字典所属的类型
	 * @sql dir_type
	 * @param type Integer类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取简介
	 * @sql dir_introduce
	 * @return String类型简介
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * 设置简介
	 * @sql dir_introduce
	 * @param introduce String类型简介
	 */
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * 获取图片资源URL
	 * @sql dir_img
	 * @return 图片URL路径字符串
	 */
	public String getImgURL() {
		return imgURL;
	}

	/**
	 * 设置图片资源URL
	 * @sql dir_img
	 * @param imgURL 图片URL路径字符串
	 */
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	
} 
