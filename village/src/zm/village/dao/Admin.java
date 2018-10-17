package zm.village.dao;
/**
* @author 李子帆
* @version 1.0
* @date 2018年7月20日 下午7:33:56
* @Description 管理员用户,对应 admin_inf表
*/
public final class Admin implements java.io.Serializable {

	private static final long serialVersionUID = -6410910151668383168L;

	private Integer id;
	
	private String username;
	
	private String password;
	
	private String phone;
	
	private String rparea;
	
	private Integer type;

	public Integer getId() {
		return id;
	}
	
	@Deprecated
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return 管理员用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username 管理员用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return 管理员密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 管理员密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return 管理员用户类型(超管、审核员)
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type 管理员用户类型(超管、审核员)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * @return 审核员电话号码
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param  审核员电话号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return  负责的审核区域
	 */
	public String getRparea() {
		return rparea;
	}

	/**
	 * @param  设置负责的审核区域地质
	 */
	public void setRparea(String rparea) {
		this.rparea = rparea;
	}

}
