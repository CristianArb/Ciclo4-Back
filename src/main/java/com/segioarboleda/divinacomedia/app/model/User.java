/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.segioarboleda.divinacomedia.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Index;

/**
 *
 * @author cterr
 */
@Data //para generar los getters and setters
@NoArgsConstructor //paraa generar constructor vacio
@AllArgsConstructor //para generar constructor con todos sus parametros
@Entity
@Table(name = "user")//, indexes = @Index(name = "index_email", columnList = "user_email", unique = true))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_mail", unique = true, length = 50, nullable = false)
    private String email;

    @Column(name = "user_password", unique = true, length = 50, nullable = false)
    private String password;

    @Column(name = "user_name", unique = true, length = 50, nullable = false)
    private String name;

}
