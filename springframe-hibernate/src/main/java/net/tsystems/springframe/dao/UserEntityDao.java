package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.UserEntity;

import java.util.List;

public interface UserEntityDao {
    UserEntity getUserByUsername(String username);
    List<UserEntity> getAllUsers();
}
