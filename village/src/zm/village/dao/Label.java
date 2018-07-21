package zm.village.dao;
/**
* @author 李子帆
* @version 1.0
* @date 2018年7月20日 下午8:16:03
* @Description 标签字典和评价关系，对应rel_label_inf表
*/
public class Label {
	
	private Integer id;
	
	//对应的评价,rel_label_eva
	private Integer evaluateId;
	
	//对应的标签字典,rel_label_type
	private Integer labelDirId;
	
	public Integer getId() {
		return id;
	}
	
	@Deprecated
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 调用getLabelName
	 * @return LabelDir字典
	 */
	public Integer getLabelDirId() {
		return labelDirId;
	}

	/**
	 * @param labelDir 设置对应的字典
	 */
	public void setLabelDirId(Integer labelDirId) {
		this.labelDirId = labelDirId;
	}

	/**
	 * @return 与之关联的评价对象
	 */
	public Integer getEvaluateId() {
		return evaluateId;
	}

	/**
	 * @param evaluate 与之关联的评价对象
	 */
	public void setEvaluate(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}
}