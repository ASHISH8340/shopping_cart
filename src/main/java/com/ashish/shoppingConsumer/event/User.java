package com.ashish.shoppingConsumer.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String name;
    private String email;
    private String password;

    private double balance;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id_fk")
//    private Address address;


//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Address> address=new ArrayList<>();
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="fk_user_id",referencedColumnName = "userId")
//    private List<Address> address;

//    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    private List<Address> addresses = new ArrayList<>();

// ---- Uni directional --------
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Address> addresses = new ArrayList<>();
// -------------------------------------

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();


}
