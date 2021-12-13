/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.repositories.crud;

import com.segioarboleda.divinacomedia.app.model.HairProduct;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author cterr
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct,String>{

/**
 * public Optional<HairProduct> findByReference(String reference);*/
    

}
