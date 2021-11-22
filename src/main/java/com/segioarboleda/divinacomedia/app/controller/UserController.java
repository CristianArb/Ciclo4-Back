/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.controller;

import com.segioarboleda.divinacomedia.app.model.User;
import com.segioarboleda.divinacomedia.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author cterr
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
public class UserController {
    
    @Autowired
    private UserService service;
    
  /**
     * Metodo GET
     * @return
     */
    @GetMapping("/all") //GET
    public List<User> getUsers(){
        return service.getAll();
    }

    /**
     * Metodo POST
     * @param user
     * @return
     */
    @PostMapping("/new") //POST
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    /**
     * Metodo GET entrada Email
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }

    /**
     * Metodo GET entrada Email y Password
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
}
