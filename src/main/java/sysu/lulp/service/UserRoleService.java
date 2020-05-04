package sysu.lulp.service;

import org.springframework.security.core.userdetails.User;
import sysu.lulp.pojo.UserRole;

public interface UserRoleService {

    public UserRole queryByUserId(int id);

    public void saveUserRole(UserRole userRole) throws Exception;

    public void updateUserRole(UserRole userRole);

    public void deleteUserRole(UserRole userRole);
}
