package com.demo.shopping.dto;

import com.demo.shopping.model.User;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int addressId;

    private String state;
    private String city;
//    private User user;
}
