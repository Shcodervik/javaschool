
package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.UserEntitySO;

import java.util.List;

public interface UserService {
    boolean addUser(UserEntitySO user);

    boolean updateUser(UserEntitySO user);

    boolean deleteUser(UserEntitySO user);

    UserEntitySO getUserById(int id);

    UserEntitySO getUserByUsername(String username);

    List<UserEntitySO> getAllUsers();

    public boolean validateUser(UserEntitySO user);
}
