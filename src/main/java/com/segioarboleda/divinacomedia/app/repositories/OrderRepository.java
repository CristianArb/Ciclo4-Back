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
import java.util.Date;

/**
 *
 * @author cterr
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepositiry repository;
    
    
    /**
     * Obtener registro
     * @return
     */
    public List<Order> getAll(){
        return (List<Order>) repository.findAll();
    }
    
     /**
     * Obtener registro por Id
     * @param id
     * @return
     */
    public Optional<Order> getOrderById(Integer id){
        return repository.findById(id);
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
    
    /**
     *
     * @param id
     * @return
     */
    public List<Order> getAllOrderBySalesManId(Integer id){
        return repository.findBySalesMan_Id(id);
    }

    /**
     * 
     * @param zone
     * @return
     */
    public List<Order> getAllOrderBySalesManZone(String zone){
        return repository.findBySalesMan_Zone(zone);
    }
    
    /**
     * 
     * @param state
     * @param id
     * @return 
     */
    public List<Order> getAllOrderBySalesManStatus(String state, Integer id){
        return repository.findByStatusAndSalesMan_Id(state,  id);
    }
    
    /**
     * 
     * @param date
     * @param id
     * @return
     */
    public List<Order> getAllOrderBySalesManRegisterDay(Date date, Integer id){
        return repository.findByRegisterDayAndSalesMan_Id(date,id);
    }
    
    
    /**
     * 
     * @param date1
     * @param id
     * @return
     */
    public List<Order> getAllOrderBySalesManRegisterDayBetweenAndSalesMan_Id(Date date1, Date date2, Integer id){
        return repository.findByRegisterDayBetweenAndSalesMan_Id(date1,date2,id);
    }
    

    
    
    /**
     * 
     * @return 
     */
    public Optional<Order> lastOrderId(){
        return repository.findTopByOrderByIdDesc();
    }
    
}
