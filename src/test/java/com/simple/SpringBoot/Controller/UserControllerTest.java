package com.simple.SpringBoot.Controller;

import com.simple.SpringBoot.DAO.DTO.UserDTO;
import com.simple.SpringBoot.DAO.Repository.user.UserRepository;
import com.simple.SpringBoot.Model.Object.User;
import com.simple.SpringBoot.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private UserDTO getUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("vuthai");
        userDTO.setEmail("test@gmail.com");
        userDTO.setPhone("0384998123");
        return userDTO;
    }

    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("vuthai");
        user.setEmail("test@gmail.com");
        user.setPhone("0384998123");
        return user;
    }

    @Test
    public void testFindAll() {
        // fake data
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(getUserDTO());

        // perform mock method
        when(userRepository.findAll()).thenReturn(userDTOList);
        // perform assert
        assertNotNull(userService.findAllUser());
    }

    @Test
    public void testUserById1() {
        // fake data
        Optional<UserDTO> userDTO = Optional.of(getUserDTO());

        // perform mock method
        when(userRepository.findById(any())).thenReturn(userDTO);
        // perform assert
        assertNotNull(userService.findUserById(1));
    }

    @Test
    public void testUserById2() {
        // fake data
        Optional<UserDTO> userDTO = Optional.empty();

        // perform mock method
        when(userRepository.findById(any())).thenReturn(userDTO);
        // perform assert
        assertThrows(RuntimeException.class, () -> userService.findUserById(1));
    }

    @Test
    public void testCreateUser() {
        // perform mock method
        when(userRepository.save(any())).thenReturn(getUserDTO());
        // perform assert
        assertNotNull(userService.createUser(getUser()));
    }

    @Test
    public void testUpdateUser1() {
        // fake data
        Optional<UserDTO> userDTO = Optional.of(getUserDTO());

        // perform mock method
        when(userRepository.findById(any())).thenReturn(userDTO);
        when(userRepository.save(any())).thenReturn(getUserDTO());
        // perform assert
        assertNotNull(userService.updateUser(1, getUser()));
    }

    @Test
    public void testUpdateUser2() {
        // fake data
        Optional<UserDTO> userDTO = Optional.empty();

        // perform mock method
        when(userRepository.findById(any())).thenReturn(userDTO);
        when(userRepository.save(any())).thenReturn(getUserDTO());
        // perform assert
        assertThrows(RuntimeException.class, () -> userService.updateUser(1, getUser()));
    }

    @Test
    public void testDeleteUser1() {
        // fake data
        Optional<UserDTO> userDTO = Optional.of(getUserDTO());

        // perform mock method
        when(userRepository.findById(any())).thenReturn(userDTO);
        // perform assert
        assertEquals("Deleted user successfull!", userService.deleteUser(1));
    }

    @Test
    public void testDeleteUser2() {
        // fake data
        Optional<UserDTO> userDTO = Optional.empty();

        // perform mock method
        when(userRepository.findById(any())).thenReturn(userDTO);
        // perform assert
        assertThrows(RuntimeException.class, () -> userService.deleteUser(1));
    }
}
