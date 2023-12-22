//package com.demo.shopping.controller;
//
//import com.demo.shopping.dto.UserDto;
//import com.demo.shopping.model.User;
//import com.demo.shopping.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class UserControllerTest {
//    @MockBean
//    private UserService userService;
//
//    @Autowired
//    private ModelMapper mapper;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    UserDto user;
//
//    @BeforeEach
//    public void init(){
//        user = UserDto.builder()
//                .name("Amith")
//                .email("amit@gmail.com")
//                .date_of_birth(null)
//                .password("12345").build();
//
//    }
//
//    @Test
//    public void createUserTest() throws Exception{
//        Mockito.when(userService.createUser(Mockito.any())).thenReturn(user);
//
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(convertObjectToJsonString(user)))
//                        .andReturn().getResponse().getStatus();
//
//
//    }
//
//
//    private String convertObjectToJsonString(Object user){
//        try{
//            return new ObjectMapper().writeValueAsString(user);
//
//        }catch(Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//}
