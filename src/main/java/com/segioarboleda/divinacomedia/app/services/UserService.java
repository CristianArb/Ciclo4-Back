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
     * @return
     */
    public List<User> getAll(){
        return repository.getAll();
    }

    /**
     * Guardar registro
     * @param user
     * @return
     */
    public User save(User user){
        if(user.getId()==null){
            List<User> existUsers=repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if(existUsers.isEmpty()){
                return repository.save(user);
            }
            else{
                return user;
            }
        }
        else{
            Optional<User> existUser=repository.getUserById(user.getId());
            if(existUser.isEmpty()){
                return repository.save(user);
            }
            else{
                return user;
            }
        }
    }

    /**
     * Obtener registro por email
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }

    /**
     * Obtener registro por email y password
     * @param email
     * @param password
     * @return
     */
    public User getUserByEmailAndPassword(String email, String password){
        Optional<User> user=repository.getUserByEmailAndPassword(email, password);
        if(user.isPresent()){
            return  user.get();
        }
        else{
            return new User(null, email, password, "NO DEFINIDO");
        }
    }
}