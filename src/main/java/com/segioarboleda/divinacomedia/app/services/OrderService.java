/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.services;

import com.segioarboleda.divinacomedia.app.model.Order;
import com.segioarboleda.divinacomedia.app.repositories.OrderRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
;
import java.util.GregorianCalendar;
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
     *
     * @return
     */
    public List<Order> getAll() {
        return repository.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Order> getOrder(int id) {
        return repository.getOrderById(id);
    }

    /**
     *
     * @param order
     * @return
     */
    public Order save(Order order) {

        Optional<Order> lastId = repository.lastOrderId();

        if (order.getStatus() == null || order.getSalesMan() == null
                || order.getProducts() == null || order.getQuantities() == null
                || order.getRegisterDay() == null) {

            return  new Order();

        } else {

            if (order.getId() == null) {

                if (lastId.isEmpty()) {
                    order.setId(1);

                } else {
                    order.setId(lastId.get().getId() + 1);

                }
            }
            Optional<Order> existsOrders = repository.getOrderById(order.getId());
            if (existsOrders.isEmpty()) {
                return repository.save(order);
            } else {
                return new Order();
            }

        }

    }

    public Order update(Order order) {
        Optional<Order> existsProduct = repository.getOrderById(order.getId());
        if (existsProduct.isPresent()) {

            if (order.getRegisterDay() != null) {
                existsProduct.get().setRegisterDay(order.getRegisterDay());
            }
            if (order.getStatus() != null) {
                existsProduct.get().setStatus(order.getStatus());
            }
            if (order.getSalesMan() != null) {
                existsProduct.get().setSalesMan(order.getSalesMan());
            }
            if (order.getProducts() != null) {
                existsProduct.get().setProducts(order.getProducts());
            }
            if (order.getQuantities() != null) {
                existsProduct.get().setQuantities(order.getQuantities());
            }

            return repository.save(existsProduct.get());

        } else {
            return order;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(Integer id) {
        Boolean aBoolean = repository.getOrderById(id).map(order -> {
            repository.delete(order.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     *
     * @param id
     * @return
     */
    public List<Order> getOrdersBySalesManId(Integer id) {
        return repository.getAllOrderBySalesManId(id);
    }

    /**
     *
     * @param zone
     * @return
     */
    public List<Order> getOrdersBySalesManZone(String zone) {
        return repository.getAllOrderBySalesManZone(zone);
    }

    /**
     *
     * @param state
     * @param id
     * @return
     */
    public List<Order> getOrdersBySalesManStatus(String state, Integer id) {
        return repository.getAllOrderBySalesManStatus(state, id);
    }

    /**
     *
     * @param date
     * @param id
     * @return
     */
    public List<Order> getOrdersBySalesManRegisterDay(String date, Integer id) {

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.parse(date,f);
        
        LocalDate tomorrow = today.plusDays(1);
        LocalDate yesterday =today.minusDays(1);
        
        Date dy = Date.from(yesterday.atStartOfDay().
                atZone(ZoneId.systemDefault())
                .toInstant());
        
        Date dt = Date.from(tomorrow.atStartOfDay().
                atZone(ZoneId.systemDefault())
                .toInstant());
        
        return repository.getAllOrderBySalesManRegisterDayBetweenAndSalesMan_Id(dy, dt, id);

                
                
    }
}
