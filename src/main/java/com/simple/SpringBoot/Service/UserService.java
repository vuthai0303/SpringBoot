package com.simple.SpringBoot.Service;

import com.simple.SpringBoot.DAO.DTO.UserDTO;
import com.simple.SpringBoot.DAO.Repository.user.UserRepository;
import com.simple.SpringBoot.Model.Object.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private  final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        List<UserDTO> users = userRepository.findAll();
        return users.stream().map(User::new).toList();
    }

    public User findUserById(int id) {
        Optional<UserDTO> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new User(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public User createUser(User newUser) {
        UserDTO user = userRepository.save(newUser.toDto());
        return new User(user);
    }

    public User updateUser(int id, User updateUser) {
        Optional<UserDTO> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserDTO user = existingUser.get();
            user.setEmail(updateUser.getEmail());
            user.setPhone(updateUser.getPhone());
            return new User(userRepository.save(user));
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public String deleteUser(int id) {
        Optional<UserDTO> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.deleteById(id);
            return "Deleted user successfull 1!";
        } else {
            throw new RuntimeException("User not found");
        }

    }
}
