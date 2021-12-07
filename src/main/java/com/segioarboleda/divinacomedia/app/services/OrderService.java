/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.services;

import com.segioarboleda.divinacomedia.app.model.Order;
import com.segioarboleda.divinacomedia.app.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cterr
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    

     /**
     * Obtener todos los registros
     * @return
     */
    public List<Order> getAll(){
        return repository.getAll();
    }

    
    /**
     * 
     * @param order
     * @return
     */
    public Order save(Order order){
        if(order.getId()==null){
            return order;
        }else{
            Optional<Order> existsProduct = repository.getOrderById(order.getId());
            if(existsProduct.isEmpty()){
                return repository.save(order);
            }else {
                return order;
            }
        }
    }

    public Order update(Order order){
        Optional<Order> existsProduct = repository.getOrderById(order.getId());
        if(existsProduct.isPresent()){
           
            
            if (order.getId()!=null){
                existsProduct.get().setId(order.getId());
            }
            if (order.getRegisterDay()!=null){
                existsProduct.get().setRegisterDay(order.getRegisterDay());
            }
            if (order.getStatus()!=null){
                existsProduct.get().setStatus(order.getStatus());
            }    
            if (order.getSalesMan()!=null){
                existsProduct.get().setSalesMan(order.getSalesMan());
            }
            if (order.getProducts()!=null){
                existsProduct.get().setProducts(order.getProducts());
            }
            if (order.getQuantities()!=null){
                existsProduct.get().setQuantities(order.getQuantities());
            }
            
            return repository.save(existsProduct.get());
            
        }else {
            return order;
        }
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public boolean delete(Integer id){
        Boolean aBoolean = repository.getOrderById(id).map(order -> {
            repository.delete(order.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
