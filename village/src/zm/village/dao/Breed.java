package zm.village.dao;
/**
* @author 李子帆
* @version 1.0
* @date 2018年7月20日 下午7:23:01
* @Description 养殖类属性，对应rel_breed_inf表
*/
public final class Breed implements java.io.Serializable {

	private static final long serialVersionUID = 8671483193728648211L;

	//rel_breed_id
	private Integer id;
	
	//养殖类名称在字典表的映射,对应rel_breed_type
	private Dictionary type;
	
	//养殖类所属的土地对象，对应rel_breed_id
	private Land land;
	
	//单位价格，对应rel_breed_price
	private Double price;
	
	//养殖产品单只最小保证重量，对应rel_breed_min_weight
	private Double minWeight;
	
	//养殖产品单只最大保证重量，对应rel_breed_max_weight
	private Double maxWeight;

	public Integer getId() {
		return id;
	}

	@Deprecated
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return 该养殖品种在字典表的映射
	 */
	public Dictionary getType() {
		return type;
	}

	/**
	 * @param type 该养殖品种在字典表的映射
	 */
	public void setType(Dictionary type) {
		this.type = type;
	}

	/**
	 * @return 该养殖品种对应的土地对象
	 */
	public Land getLand() {
		return land;
	}
	
	/**
	 * @param land 该养殖品种对应的土地对象
	 */
	public void setLand(Land land) {
		this.land = land;
	}

	/**
	 * @return 单位(单只)价格
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price 单位(单只)价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return 养殖产品单只最小保证重量
	 */
	public Double getMinWeight() {
		return minWeight;
	}

	/**
	 * @param minWeight 养殖产品单只最小保证重量
	 */
	public void setMinWeight(Double minWeight) {
		this.minWeight = minWeight;
	}

	/**
	 * @return 养殖产品单只最大保证重量
	 */
	public Double getMaxWeight() {
		return maxWeight;
	}

	/**
	 * @param minWeight 养殖产品单只最大保证重量
	 */
	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}
}
