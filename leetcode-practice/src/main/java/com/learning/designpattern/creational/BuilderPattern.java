package com.learning.designpattern.creational;

import lombok.Data;

@Data
class User {
    private String userId;
    private String userName;
    private String email;

    private User(UserBuilder userBuilder) {
        this.userId = userBuilder.userId;
        this.userName = userBuilder.userName;
        this.email = userBuilder.email;

    }

    static class UserBuilder {
        private String userId;
        private String userName;
        private String email;

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        User user = new User.UserBuilder().setUserId("1").setUserName("dev").setEmail("dev@gmail.com").build();
        System.out.println(user);
    }
}
