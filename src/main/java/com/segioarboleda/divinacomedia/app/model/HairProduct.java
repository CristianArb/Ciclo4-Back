/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author cterr
 */
@Document(collection = "hairproducts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HairProduct {

    @Id
    @GeneratedValue
    @JsonProperty("reference")
    private String id;
    
    @JsonProperty("brand")
    private String brand;
    
    @JsonProperty("category")
    private String category;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("availability")
    private boolean availability = true;
    
    @JsonProperty("price")
    private double price;
    
    @JsonProperty("quantity")
    private int quantity;
    
    @JsonProperty("photography")
    private String photography;

    public boolean getAvailability() {
        return this.availability;
    }

}

