package com.simple.SpringBoot.Model.Response;

import com.simple.SpringBoot.Model.Object.User;
import lombok.Data;

@Data
public class UserInfoResponse {
    private UserResponse user;

    public UserInfoResponse(User user) {
        this.user = new UserResponse(user);
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
