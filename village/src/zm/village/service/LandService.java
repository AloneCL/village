package zm.village.service;

import java.util.List;

import zm.village.dao.Land;

/**
* @ClassName: LandService.java
* @Description: 土地类服务层
* @version: v1.0.0
* @author: 陈光磊
* @date: 2018年7月13日 下午4:52:49 
 */
public interface  LandService {
    
	//获取所有土地信息
    List<Land> getAll();
    //根据Id获取土地详细信息
    Land getById(int id);
    //更新土地信息
    Land update(Land land);
    //插入一个土地信息
    Land insert(Land land);
}
