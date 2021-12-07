/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.repositories;

import com.segioarboleda.divinacomedia.app.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.segioarboleda.divinacomedia.app.repositories.crud.OrderCrudRepositiry;

/**
 *
 * @author cterr
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepositiry repository;
    
    
     /**
     * Obtener registro por Id
     * @param id
     * @return
     */
    public Optional<Order> getOrderById(Integer id){
        return repository.findById(id);
    }
    

    /**
     * Obtener registro
     * @return
     */
    public List<Order> getAll(){
        return (List<Order>) repository.findAll();
    }
    
     /**
     * Guardar registro
     * @param order
     * @return
     */
    public Order save(Order order){
        return repository.save(order);
    }

    /**
     * Guardar registro
     * @param id
     */
    public void delete(Integer id){
        repository.deleteById(id);
    } 
    
}
