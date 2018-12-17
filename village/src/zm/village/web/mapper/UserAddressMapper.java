package zm.village.web.mapper;

import java.util.List;
import zm.village.dao.UserAddress;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserAddress record);
    
    List<UserAddress> getByUser(Integer userId);

    UserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAddress record);
}