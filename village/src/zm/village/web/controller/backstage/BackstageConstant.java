package zm.village.web.controller.backstage;
/**
* @author 李子帆
* @version 1.0
* @date 2018年10月14日 下午9:16:19
* @Description 后台管理控制器常量
*/
public interface BackstageConstant {
	
	/**
	 * 返回给客户端的错误提示信息属性名
	 */
    String REQUEST_ERROR_INFO = "error";
    
	/**
	 *  客户端提交的验证码对应的Attribute属性名
	 */
	String REQUEST_VALIDATECODE = "validateCode";
	
	/**
	 *  服务端存储在Session中的正确验证码属性名
	 */
	String SESSION_VALIDATECODE = "checkcode";	
	/**
	 *  管理员登录成功后存储管理员用户对象的Session属性名
	 */
	String SESSION_ADMIN = "manager";	
	
	/**
	 * 验证码错误导致的登录失败错误码
	 */
	String ERRCODE_WRONG_VALIDATECODE = "1";
	/**
	 * 管理员帐号密码错误导致的登录失败错误码
	 */
	String ERRCODE_WRONG_PASS = "2";
	
	
	/**
	 * 数据字典List集合
	 */
	String ATTRIBUTE_DICT_LIST = "dictionary";
	
	/**
	 * 数据字典List集合长度
	 */
	String ATTRIBUTE_DICT_LIST_SIZE = "dataNum";
	
	/**
	 * 数据字典类型
	 */
	String ATTRIBUTE_DICT_TYPE = "type";
	
	/**
	 * 用户收藏管理的List集合
	 * @see zm.village.ssm.webcontroller.backstage.CollectSetController
	 */
	String ATTRIBUTE_COLLECT_LIST = "collect";
	
	/**
	 * 用户收藏管理的List集合长度
	 * @see zm.village.ssm.webcontroller.backstage.CollectSetController
	 */
	String ATTRIBUTE_COLLECT_LIST_SIZE = "dataNum";
	
	/**
	 * 评价标签字典管理 List集合
	 * @see zm.village.ssm.webcontroller.backstage.LabelDirSetControlle
	 */
	String ATTRIBUTE_LABEL_LIST = "labelDir";
	
	/**
	 * 评价标签字典管理 List集合长度
	 */
	String ATTRIBUTE_LABEL_LIST_SIZE = "dataNum";
	
	/**
	 * 评价信息List集合
	 */
	String ATTRIBUTE_EVALUATE_LIST = "evaluateList";
	
	/**
	 * 评价信息List集合长度
	 */
	String ATTRIBUTE_EVALUATE_LIST_SIZE = "dataNum";
}
