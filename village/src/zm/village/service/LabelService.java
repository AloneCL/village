/**
 * 
 */
package zm.village.service;

import java.util.List;

import zm.village.dao.Label;

/**
* @ClassName: LabelService.java
* @Description: 标签类逻辑层接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月22日 下午4:02:10 
 */
public interface LabelService {
    /**
     * @return 所有评论标签信息列表
     */
    List<Label> getAll();
   
    /**
     * @param  评论id
     * @return  这一评价的所有标签
     */
    List<Label> getByEvaId(Integer id);
   
    /**
     * @param id 主键id
     * @return  具体信息
     */
    Label getInfo(Integer id);
   
    /**
     * 
     * @param vo 新增的具体Label对象
     * @return  1表示成功 0表示失败
     */
	int addLabel(Label vo);
   
	/**
     * 
     * @param id 要删除的对象的id列表
     * @return  删除的行数
     */
	int deleteMany(Integer[] id);
}
