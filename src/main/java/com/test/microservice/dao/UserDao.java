package com.test.microservice.dao;

import com.test.microservice.bean.User;
import java.util.List;

/**
 * UserDao.
 *
 * @author herbert.hernandez - (1.0.0)
 * @version 1.0.0 created on 19/10/2016, 11:31:49 AM
 * <a href="mailto:herbert.hernandez@encontrack.com">Hebert Hern&aacute;ndez
 * Mart&iacute;nez</a>
 */
public interface UserDao {

    void save(final User user) throws Exception;

    User getUser(final long user) throws Exception;

    List<User> getUsers() throws Exception;
}
