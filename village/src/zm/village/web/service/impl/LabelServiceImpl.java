/**
 * 
 */
package zm.village.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zm.village.dao.Label;
import zm.village.service.LabelService;
import zm.village.web.mapper.LabelMapper;

/**
* @ClassName: LabelServiceImpl.java
* @Description: 标签类逻辑层具体实现
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月22日 下午4:17:11 
 */
@Service
public class LabelServiceImpl implements LabelService {
    
	@Autowired
	private LabelMapper mapper;
	
	/* (non-Javadoc)
	 * @see zm.village.service.LabelService#getAll()
	 */
	@Override
	public List<Label> getAll() {
		return mapper.selectAll();
	}

	/* (non-Javadoc)
	 * @see zm.village.service.LabelService#getByEvaId(java.lang.Integer)
	 */
	@Override
	public List<Label> getByEvaId(Integer id) {
		return mapper.selectByEvaId(id);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.LabelService#getInfo(java.lang.Integer)
	 */
	@Override
	public Label getInfo(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.LabelService#addLabel(zm.village.dao.Label)
	 */
	@Override
	public int addLabel(Label vo) {
		return mapper.insertSelective(vo);
	}

	/* (non-Javadoc)
	 * @see zm.village.service.LabelService#deleteMany(java.lang.Integer[])
	 */
	@Override
	public int deleteMany(Integer[] id) {
     	for(int labelId : id) {
     		mapper.deleteByPrimaryKey(labelId);
     	}
		return id.length;
	}

}
