package zm.village.ssm.mapper;

import zm.village.dao.UserInf;

public interface UserInfMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    UserInf selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInf record);

    int updateByPrimaryKey(UserInf record);
}