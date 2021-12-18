/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.repositories.crud;

import com.segioarboleda.divinacomedia.app.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author cterr
 */
public interface OrderCrudRepositiry extends MongoRepository<Order, Integer> {

    /**
     * Retorna ordenes de pedido que concida con la zona como parametro
     *
     * @param zone
     * @return
     */
    //@Query("{'salesMan.zone':?0}")
    List<Order> findBySalesMan_Zone(String zone);

    /**
     *
     * @param id
     * @return
     */
    //@Query("{/*'salesMan.id':?0*/}")
    List<Order> findBySalesMan_Id(Integer id);
    
    /**
     * 
     * @param date1
     * @param date2
     * @param id
     * @return 
     */
    List<Order> findByRegisterDayBetweenAndSalesMan_Id(Date date1, Date date2, Integer id);
    
    /**
     * 
     * @param date
     * @param id
     * @return 
     */
    List<Order> findByRegisterDayAndSalesMan_Id(Date date, Integer id);
    
    /**
     * 
     * @param state
     * @param id
     * @return 
     */
    //
    List<Order> findByStatusAndSalesMan_Id(String state, Integer id);
     
    /**
     * Para seleccionar la orden con el id maximo
     * @return 
     */
    Optional<Order> findTopByOrderByIdDesc();
    
}
