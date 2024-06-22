package com.simple.SpringBoot.Model.Request;

import com.simple.SpringBoot.DAO.DTO.UserDTO;
import com.simple.SpringBoot.Model.Object.User;
import lombok.Data;

@Data
public class UpdateUserRequest {
    private UserRequest newUser;

    public User toUser(){
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());
        return user;
    }

    @Data
    private static class UserRequest{
        private String email;
        private String phone;
    }
}
