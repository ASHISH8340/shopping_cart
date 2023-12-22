package com.demo.shopping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    private String state;
    private String city;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="user_id")
//    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

}
