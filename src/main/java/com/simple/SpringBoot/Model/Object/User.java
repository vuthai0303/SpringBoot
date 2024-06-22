package com.simple.SpringBoot.Model.Object;

import com.simple.SpringBoot.DAO.DTO.UserDTO;
import lombok.Data;

@Data
public class User {
    private int id;

    private String username;

    private String email;

    private String phone;

    public User(UserDTO dto) {
        this.id = dto.getId();
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
    }
}
