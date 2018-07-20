package zm.village.dao;
import java.sql.Timestamp;

/**
* @author 李子帆
* @version 1.0
* @date 2018年7月20日 下午7:57:01
* @Description 用户收藏夹，对应collect_inf
*/
public final class Collect implements java.io.Serializable {

	private static final long serialVersionUID = -2224018908428472714L;
	
	public static final int LAND = 0;
	public static final int GOODS = 1;
	
	//collect_id
	private Integer id;
	
	//该收藏信息所属的用户对象，collect_user
	private User user;
	
	//收藏时间，collect_time
	private Timestamp time;
	
	//收藏类型，是土地还是农产品，collect_type
	private Integer type;
	
	//收藏的土地，collect_land
	private Land land;
	
	//收藏的商品，collect_goods
	private Goods goods;

	public Integer getId() {
		return id;
	}
	
	@Deprecated
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return 该收藏信息所属的用户对象
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user 该收藏信息所属的用户对象
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return 收藏时间
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * @param time 收藏时间
	 */
	public void setTime(Timestamp time) {
		this.time = time;
	}

	/**
	 * @return 收藏类型，0表示土地，1表示商品
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type 收藏类型，0表示土地，1表示商品
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return 收藏的土地，若收藏的是商品则返回Null
	 */
	public Land getLand() {
		return land;
	}

	/**
	 * @param land 收藏的土地
	 */
	public void setLand(Land land) {
		this.land = land;
	}

	/**
	 * @return 收藏的商品
	 */
	public Goods getGoods() {
		return goods;
	}

	/**
	 * @param goods 收藏的商品
	 */
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}
