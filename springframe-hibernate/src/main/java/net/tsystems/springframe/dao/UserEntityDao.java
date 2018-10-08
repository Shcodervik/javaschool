package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.UserEntity;

import java.util.List;

public interface UserEntityDao {
    UserEntity getUserByUsername(String username);
    UserEntity getUserById(int idUser);
    List<UserEntity> getAllUsers();
}
