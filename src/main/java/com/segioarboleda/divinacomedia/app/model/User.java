/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.model;

import javax.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User Esta Clase implementa Serializable, es un Entity que se almacena con el
 * nombre <H2> reservation </H2> en la Base de Datos Contine los atributos y se
 * maneja un autoincremento para idReservation
 *
 * @since 2021-11-22
 * @version 1.0
 * @author Equipo 4
 */
@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String identification;

    private String name;

    //private Date birthDay;

    //private String monthBirthtDay;

    private String address;

    private String cellPhone;

    private String email;

    private String password;

    private String zone;

    private String type;

}
