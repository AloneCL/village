package zm.village.service;

import java.util.List;
import zm.village.dao.UserAddress;

public interface UserAddressService {
    
    int delete(Integer record);
    
    int insert(UserAddress record);

    UserAddress select(Integer record);
    
    List<UserAddress> getByUser(Integer record);
    
    int update(UserAddress record);
}
