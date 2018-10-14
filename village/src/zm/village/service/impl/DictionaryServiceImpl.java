/**
 * 
 */
package zm.village.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zm.village.dao.Dictionary;
import zm.village.service.DictionaryService;
import zm.village.mapper.DictionaryMapper;

/**
* @ClassName: DictionaryServiceImpl.java
* @Description: 数据字典类逻辑层实现
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月22日 下午7:59:07 
 */

@Service
public class DictionaryServiceImpl implements DictionaryService {
    
	@Autowired
	private DictionaryMapper mapper;
	/* (non-Javadoc)
	 * @see zm.village.service.DictionaryService#deleteMany(java.lang.Integer)
	 */
	@Override
	public int deleteMany(Integer[] dirId) {
	    for (Integer integer : dirId) {
			mapper.deleteByPrimaryKey(integer);
		}
		return dirId.length;
	}

	/* (non-Javadoc)
	 * @see zm.village.service.DictionaryService#addDictionary(zm.village.dao.Dictionary)
	 */
	@Override
	public int addDictionary(Dictionary record) {
		return mapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.DictionaryService#getInfo(java.lang.Integer)
	 */
	@Override
	public Dictionary getInfo(Integer dirId) {
		return mapper.selectByPrimaryKey(dirId);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.DictionaryService#getByType(java.lang.Integer)
	 */
	@Override
	public List<Dictionary> getByType(Integer type) {
		return mapper.selectByType(type);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.DictionaryService#getAll()
	 */
	@Override
	public List<Dictionary> getAll() {
		return mapper.selectAll();
	}

	/* (non-Javadoc)
	 * @see zm.village.service.DictionaryService#update(zm.village.dao.Dictionary)
	 */
	@Override
	public int update(Dictionary record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

}
