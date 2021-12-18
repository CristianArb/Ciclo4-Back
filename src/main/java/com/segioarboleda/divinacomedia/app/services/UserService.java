/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.services;

import com.segioarboleda.divinacomedia.app.model.User;
import com.segioarboleda.divinacomedia.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cterr
 */
@Service
public class UserService {

    /**
     *
     */
    @Autowired
    private UserRepository repository;

    /**
     * Obtener todos los registros
     *
     * @return
     */
    public List<User> getAll() {
        return repository.getAll();
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user) {

        Optional<User> lastId = repository.lastUserId();

        if (user.getIdentification() == null || user.getName() == null
                //|| user.getbirthtDay() == null || user.getMonthBirthtDay() == null  
                || user.getAddress() == null || user.getCellPhone() == null
                || user.getEmail() == null || user.getPassword() == null
                || user.getZone() == null || user.getType() == null) {
            return user;
        } else {

            if (user.getId() == null) {

                if (lastId.isEmpty()) {
                    user.setId(1);

                } else {
                    user.setId(lastId.get().getId() + 1);

                }
            }
            
            List<User> existsUsers = repository.getUserByIdOrEmailOrNameOrIdentification(
                    user.getId(), user.getEmail(), user.getName(),
                    user.getIdentification());
            if (existsUsers.isEmpty()) {
                return repository.save(user);
            } else {
                return new User();
            }

        }

    }

    /**
     * Obtener registro por email
     *
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }

    /**
     * Obtener registro por email y password
     *
     * @param email
     * @param password
     * @return
     */
    public User getUserByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            return new User();
        }
    }

    /**
     *
     * @param user
     * @return
     */
    public User update(User user) {
        Optional<User> existsUser = repository.getUserById(user.getId());
        if (existsUser.isPresent()) {
            if (user.getIdentification() != null) {
                existsUser.get().setIdentification(user.getIdentification());
            }
            if (user.getName() != null) {
                existsUser.get().setName(user.getName());
            }
            if (user.getBirthtDay() != null) {
                existsUser.get().setBirthtDay(user.getBirthtDay());
            }
            if (user.getMonthBirthtDay() != null) {
                existsUser.get().setMonthBirthtDay(user.getMonthBirthtDay());
            }
            if (user.getAddress() != null) {
                existsUser.get().setAddress(user.getAddress());
            }
            if (user.getCellPhone() != null) {
                existsUser.get().setCellPhone(user.getCellPhone());
            }
            if (user.getEmail() != null) {
                existsUser.get().setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                existsUser.get().setPassword(user.getPassword());
            }
            if (user.getZone() != null) {
                existsUser.get().setZone(user.getZone());
            }
            if (user.getType() != null) {
                existsUser.get().setType(user.getType());
            }
            return repository.save(existsUser.get());
        } else {
            return user;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
        Boolean aBoolean = repository.getUserById(id).map(user -> {
            repository.delete(user.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     *
     * @param id
     * @return
     */
    public User getUser(Integer id) {
        return repository.getUserById(id).orElse(new User());
    }
    
    public List<User> getUserByBirthtDay(String monthBirhtDay){
        return repository.getUserByMonthBirthtDay(monthBirhtDay);
    }

}
