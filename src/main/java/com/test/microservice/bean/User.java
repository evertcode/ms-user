package com.test.microservice.bean;

import java.io.Serializable;

/**
 * User.
 * <p/>
 * @author herbert.hernandez - (1.0.0)
 * @version 1.0.0 created on 19/10/2016, 11:24:18 AM
 * <a href="mailto:hebert.hernandez7@gmail.com">Hebert Hern&aacute;ndez
 * Mart&iacute;nez</a>
 */
public class User implements Serializable {

    private static final long serialVersionUID = -6845540577817396064L;

    private long id;
    private String username;
    private String password;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

}
