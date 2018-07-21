package zm.village.ssm.mapper;

import zm.village.dao.AdminInf;

public interface AdminInfMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInf record);

    int insertSelective(AdminInf record);

    AdminInf selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminInf record);

    int updateByPrimaryKey(AdminInf record);
}