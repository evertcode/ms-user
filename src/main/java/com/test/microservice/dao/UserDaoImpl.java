package com.test.microservice.dao;

import com.test.microservice.bean.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * UserDaoImpl.
 * <p/>
 * @author herbert.hernandez - (1.0.0)
 * @version 1.0.0 created on 19/10/2016, 11:33:16 AM
 * <a href="mailto:hebert.hernandez7@gmail.com">Hebert Hern&aacute;ndez
 * Mart&iacute;nez</a>
 */
@Repository
public class UserDaoImpl implements UserDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("dataSourceTest")
    public void setDataSourceCpv1(final DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final String INSERT = "insert into user (username, password) values (:username, :password)";
    private static final String SELECT_USER_BY_ID = "select a.* from user a where iduser=:id";
    private static final String SELECT_ALL_USERS = "select a.* from user a ";
    private static final RowMapper<User> USER = new RowMapper<User>() {

        @Override
        public User mapRow(final ResultSet rs, final int i)
                throws SQLException {
            final User user = new User();

            user.setId(rs.getLong("iduser"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));

            return user;
        }
    };

    @Override
    public void save(final User user) throws Exception {
        final Map<String, Object> parameters = new HashMap<>();
        try {
            parameters.put("username", user.getUsername());
            parameters.put("password", user.getPassword());

            this.jdbcTemplate.update(INSERT, parameters);

        } catch (final Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public User getUser(final long user) throws Exception {
        final Map<String, Object> parameters = new HashMap<>();
        try {
            parameters.put("id", user);
            return this.jdbcTemplate.queryForObject(SELECT_USER_BY_ID, parameters, USER);
        } catch (final Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<User> getUsers() throws Exception {
        try {
            return this.jdbcTemplate.query(SELECT_ALL_USERS, USER);
        } catch (final Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

}
