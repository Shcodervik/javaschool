package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.UserEntityDao;
import net.tsystems.springframe.dao.impl.AbstractDaoImpl;
import net.tsystems.springframe.dao.impl.UserEntityDaoImpl;
import net.tsystems.springframe.database.UserEntity;
import net.tsystems.springframe.services.mappers.UserEntityMapper;
import net.tsystems.springframe.services.objects.UserEntitySO;
import net.tsystems.springframe.services.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("userService")
public class UserServiceImpl implements UserService {


    private UserEntityDao dao;

    @Autowired
    public void setDao(UserEntityDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public boolean addUser(UserEntitySO user) {
        if (user == null) {
            return false;
        }
        UserEntity userEntity = UserEntityMapper.INSTANCE.userDtoToEntity(user);
        ((AbstractDaoImpl)dao).create(userEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateUser(UserEntitySO user) {
        if (user == null) {
            return false;
        }
        UserEntity userEntity = UserEntityMapper.INSTANCE.userDtoToEntity(user);
        ((AbstractDaoImpl)dao).update(userEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteUser(UserEntitySO user) {
        if (user == null) {
            return false;
        }

        UserEntity userEntity = UserEntityMapper.INSTANCE.userDtoToEntity(user);
        ((AbstractDaoImpl)dao).delete(userEntity);
        return true;
    }

    @Override
    @Transactional
    public UserEntitySO getUserById(int id) {
        UserEntitySO result = null;
        UserEntity userEntity = (UserEntity) ((AbstractDaoImpl)dao).getById(id);
        if (userEntity != null) {
            result = UserEntityMapper.INSTANCE.userEntityToDto(userEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public UserEntitySO getUserByUsername(String username) {
        UserEntitySO result = null;
        UserEntity userEntity = (UserEntity) dao.getUserByUsername(username);
        if (userEntity != null) {
            result = UserEntityMapper.INSTANCE.userEntityToDto(userEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public List<UserEntitySO> getAllUsers() {
        final List<UserEntitySO> result = new ArrayList<UserEntitySO>();
        List<UserEntity> usersEntity = dao.getAllUsers();
        if (CollectionUtils.isEmpty(usersEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (UserEntity data : usersEntity) {
            UserEntitySO driver = UserEntityMapper.INSTANCE.userEntityToDto(data);
            result.add(driver);
        }
        return result;
    }


    /**
     * @param user
     *            if a null object parameter is passed to method, nothing will happen
     * @return true User success validate
     */
    @Override
    public boolean validateUser(UserEntitySO user) {
        if (user == null)
        {
            return false;
        }

        boolean valid = true;

        FacesContext context = FacesContext.getCurrentInstance();

        final String PASSWORD_PATTERN = "^[a-z0-9_-]{6,18}$";

        Pattern patternPassword = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcherPassword;
        matcherPassword = patternPassword.matcher(user.getPassHash());

        if (user.getUsername().length() < 1 && user.getUsername().length() > 30)
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username must have length between 1 and 30",
                    "Name must have length between 1 and 30"));
            valid = false;
        }

        if (!matcherPassword.matches())
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password can have 6-18 symbols [A-z0-9-_]",
                    "Password can have 6-18 symbols [A-z0-9-_]"));
            valid = false;
        }

        return valid;

    }
}
