/**
 * 
 */
package zm.village.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zm.village.dao.Collect;
import zm.village.service.CollectService;
import zm.village.ssm.mapper.CollectMapper;

/**
* @ClassName: CollectServiceImpl.java
* @Description: 该类的功能描述
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月22日 下午5:44:23 
 */

@Service
public class CollectServiceImpl implements CollectService {
    
	@Autowired
	private CollectMapper mapper;
	/* (non-Javadoc)
	 * @see zm.village.service.CollectService#deleteMany(java.lang.Integer[])
	 */
	@Override
	public int deleteMany(Integer[] Id) {
		for(int labelId : Id) {
     		mapper.deleteByPrimaryKey(labelId);
     	}
		return Id.length;
	
	}

	/* (non-Javadoc)
	 * @see zm.village.service.CollectService#addCollect(zm.village.dao.Collect)
	 */
	@Override
	public int addCollect(Collect record) {
		return mapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.CollectService#getInfo(java.lang.Integer)
	 */
	@Override
	public Collect getInfo(Integer collectId) {
		return mapper.selectByPrimaryKey(collectId);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.CollectService#getAll()
	 */
	@Override
	public List<Collect> getAll() {
		return mapper.selectAll();
	}

	/* (non-Javadoc)
	 * @see zm.village.service.CollectService#update(zm.village.dao.Collect)
	 */
	@Override
	public int update(Collect record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.CollectService#getByUserId(java.lang.Integer)
	 */
	@Override
	public List<Collect> getByUserId(Integer userId) {
		return mapper.selectByUserId(userId);
	}

}
