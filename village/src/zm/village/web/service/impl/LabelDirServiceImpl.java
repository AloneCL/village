/**
 * 
 */
package zm.village.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zm.village.dao.LabelDir;
import zm.village.service.LabelDirService;
import zm.village.web.mapper.LabelDirMapper;

/**
 * @ClassName: LabelDirServiceImpl.java
 * @Description: 标签数据字典类逻辑层实现
 * @version: v1.0.0
 * @author: 陈光磊
 * @date: 2018年7月22日 下午5:15:36
 */
@Service
public class LabelDirServiceImpl implements LabelDirService {

	@Autowired
	private LabelDirMapper mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.LabelDirService#getAll()
	 */
	@Override
	public List<LabelDir> getAll() {
		return mapper.selectAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.LabelDirService#getInfo(java.lang.Integer)
	 */
	@Override
	public LabelDir getInfo(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.LabelDirService#update(zm.village.dao.LabelDir)
	 */
	@Override
	public int update(LabelDir vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.LabelDirService#deleteMany(java.lang.Integer[])
	 */
	@Override
	public int deleteMany(Integer[] id) {
		for (int labelId : id) {
			mapper.deleteByPrimaryKey(labelId);
		}
		return id.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zm.village.service.LabelDirService#addLabelDir(zm.village.dao.LabelDir)
	 */
	@Override
	public int addLabelDir(LabelDir vo) {
		return mapper.insertSelective(vo);
	}

}
