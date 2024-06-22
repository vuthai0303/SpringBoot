package com.simple.SpringBoot.Model.Object;

import com.simple.SpringBoot.DAO.DTO.UserDTO;
import lombok.Data;

@Data
public class User {
    private int id;

    private String username;

    private String email;

    private String phone;

    public User() {}

    public User(UserDTO dto) {
        this.id = dto.getId();
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.phone = dto.getPhone();
    }

    public UserDTO toDto() {
        UserDTO dto = new UserDTO();
        dto.setId(this.id);
        dto.setUsername(this.username);
        dto.setEmail(this.email);
        dto.setPhone(this.phone);
        return dto;
    }
}
