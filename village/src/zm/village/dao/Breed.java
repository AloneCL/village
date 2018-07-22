package zm.village.dao;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 养殖类属性
 * @version 1.0
 */

public final class Breed implements java.io.Serializable {

	private static final long serialVersionUID = 8671483193728648211L;

	//rel_breed_id
	private Integer id;
	
	//养殖类名称在字典表的映射,对应rel_breed_type
	private Integer dirId;
	
	//养殖类所属的土地对象，对应rel_breed_id
	private Integer landId;
	
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
	public Integer getType() {
		return dirId;
	}

	/**
	 * @param type 该养殖品种在字典表的映射
	 */
	public void setDirId(Integer dirId) {
		this.dirId = dirId;
	}

	/**
	 * @return 该养殖品种对应的土地对象
	 */
	public Integer getLand() {
		return landId;
	}
	
	/**
	 * @param land 该养殖品种对应的土地对象
	 */
	public void setLand(Integer landId) {
		this.landId = landId;
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
