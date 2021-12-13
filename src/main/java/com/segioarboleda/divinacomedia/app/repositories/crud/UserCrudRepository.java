/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.repositories.crud;

import com.segioarboleda.divinacomedia.app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author cterr
 */
public interface UserCrudRepository extends MongoRepository<User ,Integer>{   
    
    /**
     * Encontrar por nombre
     * @param name
     * @return
     */
    public Optional<User> findByName(String name);

    /**
     * Encontrar por nombre o email
     * @param name
     * @param email
     * @return
     */
    public List<User> findByNameOrEmail(String name, String email);

    /**
     * Encontrar por email
     * @param email
     * @return
     */
    public Optional<User> findByEmail(String email);

    /**
     * Encontrar por email y password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    /**
     * 
     * @param id
     * @param email
     * @param name
     * @param identification
     * @return
     */
    public List<User> findByIdOrEmailOrNameOrIdentification(Integer id, String email, String name, String identification);
    
    /**
     * Seleccionar el usuario
     * @return 
     */
    public Optional<User> findTopByOrderByIdDesc();

    
}
