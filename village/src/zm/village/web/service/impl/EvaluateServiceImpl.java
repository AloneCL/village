package zm.village.web.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.istack.internal.Nullable;

import zm.village.dao.Evaluate;
import zm.village.service.EvaluateService;
import zm.village.util.tools.SystemTimeUtil;
import zm.village.web.mapper.EvaInfMapper;


/**
* @author 李子帆
* @version 1.0
* @date 2018年10月16日 下午3:37:20
* @Description 评价服务层实现类
*/
@Service
public class EvaluateServiceImpl implements EvaluateService {
	
	@Autowired private EvaInfMapper mapper;

	@Override
	public int addOne(Evaluate evaluate) {
		return mapper.insertSelective(evaluate);
	}

	@Override
	public int deleteOne(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Evaluate getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Evaluate> getAll() {
		return mapper.selectAll();
	}

	@Override
	public List<Evaluate> getByUserId(Integer userId) {
		return mapper.selectByUserId(userId);
	}
	
	@Override
	public List<Evaluate> getByUserIdWithDetail(Integer userId) {
		return mapper.selectByUserIdWithDetail(userId);
	}

	@Override
	public int updateOne(Evaluate evaluate) {
		return mapper.updateByPrimaryKeySelective(evaluate);
	}

	@Override
	public List<Evaluate> getAllWithDetail() {
		return mapper.selectAllWithDetail();
	}

	@Override
	public List<Evaluate> getWithRoles(@Nullable String startTime, @Nullable String endTime, 
			@Nullable Integer userId, @Nullable Integer star) {
		if(startTime == null && endTime == null && userId == null && star == null)
			return getAll();
		
		try {
			Timestamp start = null, end = null;
			boolean s = startTime.equals(""), e = endTime.equals("");
			if(!(s && e)) {
				start = s ? SystemTimeUtil.getYMDTime(startTime) : SystemTimeUtil.getYMDTime("2000-01-01");
				end = e ? SystemTimeUtil.getYMDTime(endTime) : SystemTimeUtil.getTime();
			}
			
			return mapper.selectByRole(start, end, userId, star);
		} catch (ParseException e) {
			return null;
		}
	}
}
