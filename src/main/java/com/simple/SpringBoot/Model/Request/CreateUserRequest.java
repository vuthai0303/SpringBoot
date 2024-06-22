package com.simple.SpringBoot.Model.Request;

import com.simple.SpringBoot.DAO.DTO.UserDTO;
import com.simple.SpringBoot.Model.Object.User;
import lombok.Data;

@Data
public class CreateUserRequest {
    private UserRequest newUser;

    public User toUser(){
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());
        return user;
    }

    @Data
    private static class UserRequest{
        private String username;
        private String email;
        private String phone;
    }
}
