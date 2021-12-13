/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.repositories;

import com.segioarboleda.divinacomedia.app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.segioarboleda.divinacomedia.app.repositories.crud.UserCrudRepository;

/**
 *
 * @author cterr
 */
@Repository
public class UserRepository {

    /**
     * Inyectar dependencias
     */
    @Autowired
    private UserCrudRepository repository;

    /**
     * Obtener registro
     * @return
     */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    /**
     * Obtener registro por Id
     * @param id
     * @return
     */
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }

    /**
     * Obtener registro por nombre
     * @param name
     * @return
     */
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }

    /**
     * Obtener registro por email
     * @param email
     * @return
     */
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }

    /**
     * Obtener registro por nombre o email
     * @param name
     * @param email
     * @return
     */
    public List<User> getUserByNameOrEmail(String name, String email){
        return repository.findByNameOrEmail(name, email);
    }

    /**
     * Obtener registro por email y password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> getUserByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }

    /**
     * Guardar registro
     * @param user
     * @return
     */
    public User save(User user){
        return repository.save(user);
    }
    
    
    /**
     * Eliminar un registro
     * @param id 
     */
    public void delete(Integer id){
        repository.deleteById(id);
    }
    
    
    /**
     * 
     * @param id
     * @param email
     * @param name
     * @param identification
     * @return
     */
    public List<User> getUserByIdOrEmailOrNameOrIdentification(Integer id, String email, String name, String identification){
        return repository.findByIdOrEmailOrNameOrIdentification(id,email,name,identification);
    }
    
    public Optional<User> lastUserId(){
        return repository.findTopByOrderByIdDesc();
    }

}