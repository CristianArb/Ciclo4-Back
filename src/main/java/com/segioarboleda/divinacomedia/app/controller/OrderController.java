/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.controller;

import com.segioarboleda.divinacomedia.app.model.Order;
import com.segioarboleda.divinacomedia.app.services.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("order")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
public class OrderController {
/**
     * Instancia con @Autowired de la clase servicio service.
     */
    @Autowired
    private OrderService service;
    
    /**
     * Metodo GET
     * @return
     */
    @GetMapping("/all") //GET
    public List<Order> getOrders(){
        return service.getAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return service.getOrder(id);
    }

    /**
     * Metodo POST
     * @param order
     * @return
     */
    @PostMapping("/new") //POST
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }
    
    
    /**
     * Metodo PUT que actualiza un usuario
     *
     * @param order
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return service.update(order);
    }

    /**
     * Metodo DELETE que actualiza un usuario
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> getAllOrdersBySalesManId(Integer id){
        return service.getOrdersBySalesManId(id);
    }

     @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return service.getOrdersBySalesManZone(zona);
    }

}
