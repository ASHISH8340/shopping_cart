package com.demo.shopping.service;

import com.demo.shopping.dto.PageableResponse;
import com.demo.shopping.dto.UserDto;
import com.demo.shopping.model.User;
import com.demo.shopping.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private ModelMapper mapper;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    User user;
    @BeforeEach
    public void init(){
        user = User.builder()
                .name("Amith")
               .email("amit@gmail.com")
               .date_of_birth(null)
               .password("12345").build();

    }

    @Test
    public void createUserTest(){
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        UserDto user1= userService.createUser(mapper.map(user, UserDto.class));
        Assertions.assertNotNull(user1);

    }

    @Test
    public void getAllUserTest(){
        User user1 = User.builder()
                .name("Amith")
                .email("amit@gmail.com")
                .date_of_birth(null)
                .password("12345").build();

        User user2 = User.builder()
                .name("Amith")
                .email("amit@gmail.com")
                .date_of_birth(null)
                .password("12345").build();


        List<User> userList = Arrays.asList(user,user1,user2);
        Page<User> page = new PageImpl<>(userList);
        Mockito.when(userRepository.findAll((Pageable) Mockito.any())).thenReturn(page);

        PageableResponse<UserDto> allUser = userService.getAllUser(1,2,"name","asc");
        Assertions.assertEquals(3,allUser.getContent().size());


    }



}
