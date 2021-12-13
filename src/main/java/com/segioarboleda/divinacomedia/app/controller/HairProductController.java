/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.controller;

import com.segioarboleda.divinacomedia.app.model.HairProduct;
import com.segioarboleda.divinacomedia.app.services.HairProductService;
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
@RequestMapping("hairproducts")
@CrossOrigin(origins = "*", methods= {GET, POST, PUT, DELETE})
public class HairProductController {
    
    /**
     * Instancia con @Autowired de la clase servicio service.
     */
    @Autowired
    private HairProductService service;
    
    /**
     * Metodo GET
     * @return
     */
    @GetMapping("/all") //GET
    public List<HairProduct> getHairProducts(){
        return service.getAll();
    }
    
    /**
     * Metodo GET
     * @param id
     * @return
     */
     @GetMapping("/{id}")
    public Optional<HairProduct> getProduct(@PathVariable("id")  String id) {
        return service.getProduct(id);
    }

    /**
     * Metodo POST
     * @param hairProduct
     * @return
     */
    @PostMapping("/new") //POST
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct hairProduct){
        return service.save(hairProduct);
    }
    
    
    /**
     * Metodo PUT que actualiza un usuario
     *
     * @param hairProduct
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct  update(@RequestBody HairProduct hairProduct) {
        return service.update(hairProduct);
    }

    /**
     * Metodo DELETE que actualiza un usuario
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
