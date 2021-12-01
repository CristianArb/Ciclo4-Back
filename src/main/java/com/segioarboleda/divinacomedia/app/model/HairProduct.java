/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.model;

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
    private String reference;

    private String brand;

    private String category;

    private String name;

    private String description;

    private boolean availability = true;

    private double price;

    private int quantity;

    private String photography;

}

