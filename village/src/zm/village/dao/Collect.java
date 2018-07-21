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
	private Integer userId;
	
	//收藏时间，collect_time
	private Timestamp time;
	
	//收藏类型，是土地还是农产品，collect_type
	private Integer type;
	
	//收藏的土地，collect_land
	private Integer landId;
	
	//收藏的商品，collect_goods
	private Integer goodsId;

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
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param user 该收藏信息所属的用户对象
	 */
	public void setUserId(Integer user) {
		this.userId = user;
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
	public Integer getLandId() {
		return landId;
	}

	/**
	 * @param land 收藏的土地
	 */
	public void setLandId(Integer landId) {
		this.landId = landId;
	}

	/**
	 * @return 收藏的商品
	 */
	public Integer getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goods 收藏的商品
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
}
