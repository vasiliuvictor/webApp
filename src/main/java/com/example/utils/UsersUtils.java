package com.example.utils;

import com.example.backend.persistance.domain.backend.User;

public class UsersUtils {

    private UsersUtils(){
        throw  new AssertionError("Non instantiable");
    }

    public static User createBasicUser(){
        User user = new User();
        user.setUsername("FirstUser");
        user.setPassword("secret");
        user.setEmail("First_email@yahoo.com");
        user.setFirstName("Alien");
        user.setLastName("Mars");
        user.setPhoneNumber("0751013288");
        user.setCountry("Galaxy");
        user.setEnabled(true);
        user.setDescription("The first Alien user");
        user.setProfileImageUrl("http://images.ro");

        return user;
    }
}
