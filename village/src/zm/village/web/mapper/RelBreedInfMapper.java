package zm.village.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import zm.village.dao.Breed;

/**
 * @author 伍伴
 * @Date 2018年7月21日
 * @Description 养殖类mybatis数据库映射Dao层
 * @version 1.0
 */

@Repository
public interface RelBreedInfMapper {
    /**
     * @param 养殖ID
     * @return 删除的行数
     */
    int deleteByPrimaryKey(Integer relBreedId);

    /**
     * @param 养殖信息
     * @return 插入的主键
     */
    int insertSelective(Breed record);

    /**
     * @param 养殖ID
     * @return 养殖信息
     */
    Breed selectByPrimaryKey(Integer relBreedId);
    
    /**
     * @param 土地ID
     * @return 该土地所对应的养殖信息
     */
    List<Breed> selectByLand(Integer landId);

    /**
     * @param 养殖信息
     * @return 更新的行数
     */
    int updateByPrimaryKeySelective(Breed record);
    
    /**
     * @return 养殖信息列表
     */
    List<Breed> selectAll();

}