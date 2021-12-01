/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.services;


import com.segioarboleda.divinacomedia.app.model.HairProduct;
import com.segioarboleda.divinacomedia.app.repositories.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cterr
 */
@Service
public class HairProductService {
    
    /**
     * 
     */
    @Autowired
    private HairProductRepository repository;
    

     /**
     * Obtener todos los registros
     * @return
     */
    public List<HairProduct> getAll(){
        return repository.getAll();
    }

    
    /**
     * 
     * @param product
     * @return
     */
    public HairProduct save(HairProduct product){
        if(product.getReference()==null){
            return product;
        }else{
            Optional<HairProduct> existsProduct = repository.getByReference(product.getReference());
            if(existsProduct.isEmpty()){
                return repository.save(product);
            }else {
                return product;
            }
        }
    }

    
    public HairProduct update(HairProduct hairproduct){
        Optional<HairProduct> existsProduct = repository.getByReference(hairproduct.getReference());
        if(existsProduct.isPresent()){
            if (hairproduct.getReference()!=null){
                existsProduct.get().setReference(hairproduct.getReference());
            }
            if (hairproduct.getBrand()!=null){
                existsProduct.get().setBrand(hairproduct.getBrand());
            }
            if (hairproduct.getCategory()!=null){
                existsProduct.get().setCategory(hairproduct.getCategory());
            }    
            if (hairproduct.getName()!=null){
                existsProduct.get().setName(hairproduct.getName());
            }
            if (hairproduct.getDescription()!=null){
                existsProduct.get().setDescription(hairproduct.getDescription());
            }
            
            /**
            if (hairproduct.getAvailability()!=null){
                existsProduct.get().setAvailability(hairproduct.Availability());
            }
            */
            if (hairproduct.getPrice()!=0){
                existsProduct.get().setPrice(hairproduct.getPrice());
            }
            if (hairproduct.getQuantity()!=0){
                existsProduct.get().setQuantity(hairproduct.getQuantity());
            }
            if (hairproduct.getPhotography()!=null){
                existsProduct.get().setPhotography(hairproduct.getPhotography());
            }
        
            return repository.save(existsProduct.get());
            
        }else {
            return hairproduct;
        }
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public boolean delete(String id){
        Boolean aBoolean = repository.getByReference(id).map(hairproduct -> {
            repository.delete(hairproduct.getReference());
            return true;
        }).orElse(false);
        return aBoolean;
    }

}