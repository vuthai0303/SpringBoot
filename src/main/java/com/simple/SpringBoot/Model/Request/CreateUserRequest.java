package com.simple.SpringBoot.Model.Request;

import com.simple.SpringBoot.DAO.DTO.UserDTO;
import lombok.Data;

@Data
public class CreateUserRequest {
    private UserRequest newUser;

    public UserDTO toDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(newUser.getUsername());
        userDTO.setEmail(newUser.getEmail());
        userDTO.setPhone(newUser.getPhone());
        return userDTO;
    }

    @Data
    private static class UserRequest{
        private String username;
        private String email;
        private String phone;
    }
}
