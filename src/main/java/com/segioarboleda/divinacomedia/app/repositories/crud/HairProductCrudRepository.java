/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.repositories.crud;

import com.segioarboleda.divinacomedia.app.model.HairProduct;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.mongodb.repository.Query;


/**
 *
 * @author cterr
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct,String>{
   
//@Query("{/*'hairProduct.price':?0*/}")
 public List<HairProduct> findByPrice(double price);
 
@Query("{'description':{'$regex':'?0','$options':'i'}}")
public List<HairProduct> findByDescription(String description);

}
