package com.simple.SpringBoot.DAO.DTO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"User\"")
public class UserDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;
}
