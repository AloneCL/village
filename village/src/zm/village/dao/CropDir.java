package zm.village.dao;
/**
* @author 李子帆
* @version 1.0
* @date 2018年7月13日 下午5:33:48
* @Description 作物字典类，对应dir_crop_inf表
*/
public class CropDir implements java.io.Serializable {

	private static final long serialVersionUID = -568746960463257557L;
	
	//dir_crop_id
	private Integer id;
	
	//作物名称，对应dir_crop_name
	private String name;
	
	@Override
	public String toString() {
		return "[CropDir id = " + id + " , name = " + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
