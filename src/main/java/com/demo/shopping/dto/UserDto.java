package com.demo.shopping.dto;

import com.demo.shopping.model.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int userId;

    private String name;
    private String email;
    private String password;
   private double balance;
    private List<Address> addresses = new ArrayList<>();
}
