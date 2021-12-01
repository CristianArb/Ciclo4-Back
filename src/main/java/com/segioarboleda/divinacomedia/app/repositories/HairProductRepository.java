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
     * Obtener registro por Id
     * @param id
     * @return
     */
    public Optional<HairProduct> getProductById(String id){
        return repository.findById(id);
    }
    
    /**
     * 
     * @param reference
     * @return 
     */
    public Optional<HairProduct> getByReference(String reference) {
        return repository.findById(reference);
    }

    /**
     * Obtener registro
     * @return
     */
    public List<HairProduct> getAll(){
        return (List<HairProduct>) repository.findAll();
    }
    
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
     * @param id
     */
    public void delete(String id){
        repository.deleteById(id);
    }
    
 
    
    
}