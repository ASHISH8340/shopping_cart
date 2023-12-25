package com.demo.shopping.service.serviceimpl;

import com.demo.shopping.dto.AddressDto;
import com.demo.shopping.dto.PageableResponse;
import com.demo.shopping.dto.UserDto;
import com.demo.shopping.exception.UserNameNotFoundException;
import com.demo.shopping.helper.Helper;
import com.demo.shopping.model.Address;
import com.demo.shopping.model.User;
import com.demo.shopping.repositories.AddressRepository;
import com.demo.shopping.repositories.UserRepository;
import com.demo.shopping.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        if( userDto.getName().isEmpty()){
            throw new UserNameNotFoundException("UserName not be a blank");

        }


       User user= modelMapper.map(userDto,User.class);

//        String userId=UUID.randomUUID().toString();
//        user.setUserId(userId);
        user.getAddresses().forEach(address -> address.setUser(user));

        User savedUser=userRepository.save(user);
        UserDto userDto1 = modelMapper.map(savedUser, UserDto.class);

        return userDto1;




    }

    @Override
    public PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase(("desc")) ?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending()) );
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<User> page = userRepository.findAll(pageable);
        PageableResponse<UserDto> response= Helper.getPageableResponse(page, UserDto.class);

        return response;
    }

    @Override
    public Object deleteUser(int userId) {
        Optional<User> users = userRepository.findById(userId);
        if(users.isEmpty()){
            throw new UserNameNotFoundException("UserId not be a found !!");
        }
        User user = users.get();
        userRepository.delete(user);

        return user;
    }

    @Override
    public UserDto getUserById(int userId) {
        Optional<User> findById=userRepository.findById(userId);
        if(findById.isEmpty()){
            throw new UserNameNotFoundException("User Id doesn't exist !!");
        }
        User user = findById.get();
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public UserDto updateByUserId(int userId, UserDto userDto) {
        Optional<User> findById=userRepository.findById(userId);
        if(findById.isEmpty()){
            throw new UserNameNotFoundException("User Id doesn't exist !!");
        }
        User user = findById.get();
        user.setBalance(userDto.getBalance());
        User save = userRepository.save(user);
        UserDto userDto1=modelMapper.map(user,UserDto.class);
        return userDto1;
    }


}
