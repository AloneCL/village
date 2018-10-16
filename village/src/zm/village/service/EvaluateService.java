package zm.village.service;

import java.util.List;

import zm.village.dao.Evaluate;
import zm.village.dao.User;

/**
* @author 李子帆
* @version 1.0
* @date 2018年10月16日 下午3:11:06
* @Description 评论服务层接口
*/
public interface EvaluateService {

	/**
	 * 添加评价
	 * @param evaluate 评价对象
	 */
	int addOne(Evaluate evaluate);
	
	/**
	 * 添加多个评价
	 * @param evaluates 包含多个评价的数组
	 * @return 添加条数
	 */
	default int addMany(Evaluate[] evaluates) {
		int result = 0;
		for(Evaluate evaluate : evaluates) {
			result += addOne(evaluate);
		}
		return result;
	}
	
	/**
	 * 添加多个评价
	 * @param evaluates 包含多个评价的List集合
	 * @return 添加条数
	 */
	default int addMany(List<Evaluate> evaluates) {
		int result = 0;
		for(Evaluate evaluate : evaluates) {
			result += addOne(evaluate);
		}
		return result;
	}
	
	/**
	 * 根据主键ID删除一个评价
	 * @param id 主键ID
	 * @return 实际删除条数
	 */
	int deleteOne(Integer id);
	
	/**
	 * 根据主键ID数组删除多个评价
	 * @param id Integer数组
	 * @return 实际删除数量
	 */
	default int deleteMany(Integer[] ids) {
		int result = 0;
		for(Integer id : ids) {
			result += deleteOne(id);
		}
		return result;
	}
	
	/**
	 * 根据主键ID的List集合删除多个评价
	 * @param id Integer集合
	 * @return 实际删除数量
	 */
	default int deleteMany(List<Integer> ids) {
		int result = 0;
		for(Integer id : ids) {
			result += deleteOne(id);
		}
		return result;
	}
	
	/**
	 * 根据主键ID获取单个评价信息
	 * @param id 
	 * @return 评价对象
	 */
	Evaluate getById(Integer id);
	
	/**
	 * 查询所有的评价信息，不包含评价内容
	 * @return 包含所有评价信息的List
	 */
	List<Evaluate> getAll();
	
	/**
	 * 查询所有的评价信息，包含评价内容
	 * @return 包含所有评价信息的List
	 */
	List<Evaluate> getAllWithDetail();
	
	/**
	 * 根据卖家/买家获取他所有的评价信息，不包含评价内容
	 * @param userId 用户表主键ID
	 * @return 所有的评价信息
	 */
	List<Evaluate> getByUserId(Integer userId);
	
	default List<Evaluate> getByUser(User user) {
		return getByUserId(user.getId());
	}
	
	/**
	 * 根据卖家/买家获取他所有的评价信息
	 * @param userId 用户表主键ID
	 * @return 所有的评价信息
	 */
	List<Evaluate> getByUserIdWithDetail(Integer userId);
	
	default List<Evaluate> getByUserWithDetail(User user) {
		return getByUserIdWithDetail(user.getId());
	}

	/**
	 * 修改评价信息
	 * @param evaluate 评价对象
	 * @return 修改条数
	 */
	int updateOne(Evaluate evaluate);
	
	/**
	 * 修改多个评价信息
	 * @param evaluate 评价对象数组
	 * @return 修改条数
	 */
	default int updateMany(Evaluate[] evaluates) {
		int result = 0;
		for(Evaluate evaluate : evaluates) {
			result += updateOne(evaluate);
		}
		return result;
	}
	
	/**
	 * 修改多个评价信息
	 * @param evaluate 评价对象List集合
	 * @return 修改条数
	 */
	default int updateMany(List<Evaluate> evaluates) {
		int result = 0;
		for(Evaluate evaluate : evaluates) {
			result += updateOne(evaluate);
		}
		return result;
	}
}
