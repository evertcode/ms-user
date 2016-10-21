package com.test.microservice.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Response.
 * <p/>
 * @author herbert.hernandez - (1.0.0)
 * @version 1.0.0 created on 19/10/2016, 12:47:02 PM
 * <a href="mailto:hebert.hernandez7@gmail.com">Hebert Hern&aacute;ndez
 * Mart&iacute;nez</a>
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 5275838638441605839L;

    private List<?> data;
    private int status;
    private String message;

    /**
     * @return the data
     */
    public List<?> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(final List<?> data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(final int status) {
        this.status = status;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(final String message) {
        this.message = message;
    }

}
