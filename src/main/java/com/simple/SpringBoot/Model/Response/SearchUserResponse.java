package com.simple.SpringBoot.Model.Response;

import com.simple.SpringBoot.Model.Object.User;
import lombok.Data;

import java.util.List;

@Data
public class SearchUserResponse {
    private List<UserResponse> searchUser;

    public SearchUserResponse(List<User> user) {
        this.searchUser = user.stream().map(UserResponse::new).toList();
    }

    @Data
    private static class UserResponse{
        private int id;
        private String username;
        private String email;
        private String phone;

        public UserResponse(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.phone = user.getPhone();
        }
    }
}
