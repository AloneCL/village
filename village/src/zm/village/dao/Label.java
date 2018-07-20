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
	private Evaluate evaluate;
	
	//对应的标签字典,rel_label_type
	private LabelDir labelDir;
	
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
	@Deprecated
	public LabelDir getLabelDir() {
		return labelDir;
	}
	
	/**
	 * @return 获取字典对应的名称
	 */
	public String getLabelName() {
		return labelDir.getName();
	}

	/**
	 * @param labelDir 设置对应的字典
	 */
	public void setLabelDir(LabelDir labelDir) {
		this.labelDir = labelDir;
	}

	/**
	 * @return 与之关联的评价对象
	 */
	public Evaluate getEvaluate() {
		return evaluate;
	}

	/**
	 * @param evaluate 与之关联的评价对象
	 */
	public void setEvaluate(Evaluate evaluate) {
		this.evaluate = evaluate;
	}
}