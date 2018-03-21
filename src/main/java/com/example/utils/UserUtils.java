package com.example.utils;

import com.example.backend.persistance.domain.backend.User;

public class UserUtils {

    private UserUtils(){
        throw  new AssertionError("Non instantiable");
    }

    public static User createBasicUser(String username,String email){
        User user = new User();
        user.setUsername(username);
        user.setPassword("admin");
        user.setEmail(email);
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
