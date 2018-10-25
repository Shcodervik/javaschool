package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.UserEntityDao;
import net.tsystems.springframe.database.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userEntityDao")
public class UserEntityDaoImpl extends AbstractDaoImpl<Integer, UserEntity> implements UserEntityDao {
    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("Username", username));
        UserEntity userByUsername = (UserEntity)crit.uniqueResult();
        return userByUsername;
    }

    @Override
    public UserEntity getUserById(int idUser) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idUser", idUser));
        UserEntity user = (UserEntity)crit.uniqueResult();
        return user;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        Criteria criteria = getCriteria();
        List<UserEntity> users = (List<UserEntity>)criteria.list();

        return users;
    }
}
