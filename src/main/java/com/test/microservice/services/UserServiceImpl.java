package com.test.microservice.services;

import com.test.microservice.bean.User;
import com.test.microservice.dao.UserDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl.
 * <p/>
 * @author herbert.hernandez - (1.0.0)
 * @version 1.0.0 created on 19/10/2016, 11:52:24 AM
 * <a href="mailto:hebert.hernandez7@gmail.com">Hebert Hern&aacute;ndez
 * Mart&iacute;nez</a>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private transient UserDao userDao;

    @Override
    public void save(User user) throws Exception {
        try {
            this.userDao.save(user);
        } catch (final Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public User getUser(long user) throws Exception {
        try {
            return this.userDao.getUser(user);
        } catch (final Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<User> getUsers() throws Exception {
        try {
            return this.userDao.getUsers();
        } catch (final Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

}
