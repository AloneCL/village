package zm.village.dao;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 轮播图实体类
 * @version 1.0
 */
public class VillageImage {
	
	private Integer Id;

	//轮播图1
	private String image1URL;

	//轮播图2
	private String image2URL;
	
	//轮播图3
	private String image3URL;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getImage1URL() {
		return image1URL;
	}

	public void setImage1URL(String image1url) {
		image1URL = image1url;
	}

	public String getImage2URL() {
		return image2URL;
	}

	public void setImage2URL(String image2url) {
		image2URL = image2url;
	}

	public String getImage3URL() {
		return image3URL;
	}

	public void setImage3URL(String image3url) {
		image3URL = image3url;
	}

	@Override
	public String toString() {
		return "HotImage [Id=" + Id + ", image1URL=" + image1URL + ", image2URL=" + image2URL + ", image3URL="
				+ image3URL + "]";
	}

    

}