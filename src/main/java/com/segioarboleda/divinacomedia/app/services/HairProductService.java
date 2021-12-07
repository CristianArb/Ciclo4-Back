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
        if(product.getId()==null){
            return product;
        }else{
            Optional<HairProduct> existeProduct = repository.getProductById(product.getId());
            if(existeProduct.isEmpty()){
                return repository.save(product);
            }else {
                return product;
            }
        }
    }

    
    public HairProduct update(HairProduct product){
        Optional<HairProduct> existsProduct = repository.getProductById(product.getId());
        if(existsProduct.isPresent()){
            
            
            
            if (product.getId()!=null){
                existsProduct.get().setId(product.getId());
            }
            if (product.getBrand()!=null){
                existsProduct.get().setBrand(product.getBrand());
            }
            if (product.getCategory()!=null){
                existsProduct.get().setCategory(product.getCategory());
            }    
            if (product.getName()!=null){
                existsProduct.get().setName(product.getName());
            }
            if (product.getDescription()!=null){
                existsProduct.get().setDescription(product.getDescription());
            }
            existsProduct.get().setAvailability(product.getAvailability());
            
            if (product.getPrice()!=0){
                existsProduct.get().setPrice(product.getPrice());
            }
            if (product.getQuantity()!=0){
                existsProduct.get().setQuantity(product.getQuantity());
            }
            if (product.getPhotography()!=null){
                existsProduct.get().setPhotography(product.getPhotography());
            }
        
            return repository.save(existsProduct.get());
            
        }
        else {
            return product;
        }
    }
    
    /**
     * 
     * @param id
     * @return
     */
    public boolean delete(String id){
        Boolean aBoolean = repository.getProductById(id).map(hairproduct -> {
            repository.delete(hairproduct.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }

}