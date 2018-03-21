package com.example.backend.service;

import com.example.backend.persistance.domain.backend.Plan;
import com.example.backend.persistance.domain.backend.User;
import com.example.backend.persistance.domain.backend.UserRole;
import com.example.backend.persistance.repositories.PlanRepository;
import com.example.backend.persistance.repositories.RoleRepository;
import com.example.backend.persistance.repositories.UserRepository;
import com.example.utils.PlansEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles){

        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);

        Plan plan = new Plan(plansEnum);

        if(!planRepository.exists(plansEnum.getId())){
            plan = planRepository.save(plan);
        }

        user.setPlan(plan);

        for(UserRole ur : userRoles){
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);

        user = userRepository.save(user);

        return user;

    }
}
