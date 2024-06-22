package com.simple.SpringBoot.DAO.Repository.user;

import com.simple.SpringBoot.DAO.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Integer> {

}
