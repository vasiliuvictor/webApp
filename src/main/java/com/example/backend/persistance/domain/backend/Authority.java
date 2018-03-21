package com.example.backend.persistance.domain.backend;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Andrei.Vasiliu on 3/21/2018.
 */
public class Authority implements GrantedAuthority{

    private final String authority;

    public Authority(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority(){
        return authority;
    }
}
