package com.demo.shopping.controller;

import com.demo.shopping.dto.PageableResponse;
import com.demo.shopping.dto.UserDto;
import com.demo.shopping.model.User;
import com.demo.shopping.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @Operation(summary = "create new user !!",description = "this is create user api")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description= "Success | OK"),
//            @ApiResponse(responseCode = "1000000", description = "new user created !!")
//    })
    public ResponseEntity<UserDto> creteUser(@RequestBody UserDto userdto){
        return new  ResponseEntity<>(userService.createUser(userdto), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<PageableResponse<UserDto>> getAllUsers(
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "name") String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir

    ){
        return  new ResponseEntity<>(userService.getAllUser(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable int userId){
        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.GONE);
    }

    @GetMapping("{userId}")
    public UserDto getByUserId(@PathVariable int userId){
        return (userService.getUserById(userId));
}

    @PutMapping("/updateUser/{userId}")
    public UserDto getByUserId(@PathVariable int userId,@RequestBody UserDto userDto){
        return(userService.updateByUserId(userId,userDto));
    }



}
