/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.repositories.crud;

import com.segioarboleda.divinacomedia.app.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author cterr
 */
public interface OrderCrudRepositiry extends MongoRepository<Order,Integer>{
    
    /**
     * Retorna ordenes de pedido que concida con la zona como parametro
     */
    //public List<order> findbyZone(final String country);
    

}
