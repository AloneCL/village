/**
 * 
 */
package zm.village.service;

import java.util.List;

import zm.village.dao.LabelDir;

/**
* @ClassName: LabelDirService.java
* @Description: 标签数据字典类逻辑层接口
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月22日 下午5:02:10 
 */
public interface LabelDirService {
	/**
	 * 
	 * @param vo 增加的数据信息
	 * @return 执行结果
	 */
	int addLabelDir(LabelDir vo);
	 /**
	  * 
	  * @return 所有数据字典列表
	  */
     List<LabelDir> getAll();
     /**
      * 
      * @param id 主键id
      * @return  相应的数据信息
      */
     LabelDir getInfo(Integer id);
     /**
      * 
      * @param vo  更新之后的数据类对象
      * @return   更新结果
      */
     int update(LabelDir vo);
     
     /**
      * 
      * @param id  要删除的主键id
      * @return   删除的数据数量
      */
     int deleteMany(Integer[] id);
}
