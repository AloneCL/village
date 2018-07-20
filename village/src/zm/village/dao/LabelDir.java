package zm.village.dao;
/**
* @author 李子帆
* @version 1.0
* @date 2018年7月20日 下午8:14:47
* @Description 评价标签数据字典
*/
public class LabelDir implements java.io.Serializable {

	private static final long serialVersionUID = -5174693753642829555L;

	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}
	
	@Deprecated
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
