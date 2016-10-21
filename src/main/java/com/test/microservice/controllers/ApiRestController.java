package com.test.microservice.controllers;

import com.test.microservice.bean.Response;
import com.test.microservice.bean.User;
import com.test.microservice.services.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ApiRestController.
 * <p/>
 * @author herbert.hernandez - (1.0.0)
 * @version 1.0.0 created on 19/10/2016, 11:53:10 AM
 * <a href="mailto:hebert.hernandez7@gmail.com">Hebert Hern&aacute;ndez
 * Mart&iacute;nez</a>
 */
@RestController
@RequestMapping(value = "/api/v1/microservice/user")
public class ApiRestController {

    @Autowired
    private transient UserService userService;

    @RequestMapping(method = {RequestMethod.POST},
            produces = "application/json")
    public @ResponseBody
    ResponseEntity<Response> save(
            final HttpServletRequest request, @RequestBody(
                    required = true) final User user) {
        final Response res = new Response();
        try {
            this.userService.save(user);
            res.setMessage("User created");
            res.setStatus(HttpStatus.CREATED.value());
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (final Exception ex) {
            ex.printStackTrace();
            res.setMessage(ex.getMessage());
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}",
            method = {RequestMethod.GET},
            produces = "application/json")
    public @ResponseBody
    ResponseEntity<Response> getUser(
            final HttpServletRequest request, @PathVariable final long id) {
        final Response res = new Response();
        try {
            final List<User> list = new ArrayList<>();
            list.add(this.userService.getUser(id));
            res.setData(list);
            res.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (final Exception ex) {
            ex.printStackTrace();
            res.setMessage(ex.getMessage());
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = {RequestMethod.GET},
            produces = "application/json")
    public @ResponseBody
    ResponseEntity<Response> getUsers(
            final HttpServletRequest request) {
        final Response res = new Response();
        try {
            res.setData(this.userService.getUsers());
            res.setStatus(HttpStatus.OK.value());
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (final Exception ex) {
            ex.printStackTrace();
            res.setMessage(ex.getMessage());
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
