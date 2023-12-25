package com.demo.shopping.service;

import com.demo.shopping.dto.PageableResponse;
import com.demo.shopping.dto.UserDto;
import com.demo.shopping.model.User;

public interface UserService {

    UserDto createUser(UserDto userDto);

    PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy,String sortDir);

    Object deleteUser(int userId);

    UserDto getUserById(int userId);

    UserDto updateByUserId(int userId,UserDto userDto);
}
