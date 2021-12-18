/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.repositories;

import com.segioarboleda.divinacomedia.app.model.HairProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.segioarboleda.divinacomedia.app.repositories.crud.HairProductCrudRepository;

/**
 *
 * @author cterr
 */
@Repository
public class HairProductRepository {

    /**
     * Inyectar dependencias
     */
    @Autowired
    private HairProductCrudRepository repository;
    
    
    /**
     * Obtener registro
     * @return
     */
    public List<HairProduct> getAll(){
        return (List<HairProduct>) repository.findAll();
    }
    
     /**
     * Obtener registro por Id
     * @param reference
     * @return
     */
    public Optional<HairProduct> getProductById(String reference){
        return repository.findById(reference);
    }
   
    
    /**
     * 
     * @param reference
     * @return 
     *
    public Optional<HairProduct> getByReference(String reference) {
        return repository.findByReference(reference);
    }*/
    
     /**
     * Guardar registro
     * @param hairproduct
     * @return
     */
    public HairProduct save(HairProduct hairproduct){
        return repository.save(hairproduct);
    }

    /**
     * Guardar registro
     * @param reference
     */
    public void delete(String reference){
        repository.deleteById(reference);
    } 
    
    public List<HairProduct> getProductsByPrice(double price){
        return repository.findByPrice(price);    
    }
    
    public List<HairProduct> getProductsByDescription(String description){
        return repository.findByDescription(description);
    }
    
}