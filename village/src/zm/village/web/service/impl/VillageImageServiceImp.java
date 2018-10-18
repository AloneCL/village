package zm.village.web.service.impl;

import zm.village.dao.VillageImage;
import zm.village.service.VillageImageService;
import zm.village.web.mapper.VillageImageMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 轮播图功能服务实现层
 * @version 1.0
 */
@Service
public class VillageImageServiceImp implements VillageImageService {
	private final VillageImageMapper mapper;

	@Autowired
	public VillageImageServiceImp(VillageImageMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public VillageImage getInfo() {
		VillageImage himage = mapper.select();
		return himage;

	}

	@Override
	public int update(VillageImage vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}
    
	


}
