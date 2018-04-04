package com.example.backend.service;

import com.example.backend.persistance.domain.backend.PasswordResetToken;
import com.example.backend.persistance.domain.backend.User;
import com.example.backend.persistance.repositories.PasswordResetTokenRepository;
import com.example.backend.persistance.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Andrei.Vasiliu on 4/4/2018.
 */
@Service
@Transactional
public class PasswordResetTokenService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Value("${token.expiration.length.minutes}")
    private int tokenExpirationInMinutes;

    private static final Logger LOG = LoggerFactory.getLogger(PasswordResetTokenService.class);


    @Transactional
    public PasswordResetToken createPasswordResetTokenForEmail(String email){
        PasswordResetToken passwordResetToken = null;

        User user = userRepository.findByEmail(email);

        if(null != user){
            String token = UUID.randomUUID().toString();
            LocalDateTime now = LocalDateTime.now(Clock.systemUTC());
            passwordResetToken = new PasswordResetToken(token,user,now,tokenExpirationInMinutes);

            passwordResetToken = passwordResetTokenRepository.save(passwordResetToken);
            LOG.debug("Succesfully created token {} for user {}",token,user.getUsername());

        }else {
            LOG.warn("We couldn't find a user for the give email {}",email);
        }
    return passwordResetToken;
    }

    public PasswordResetToken findByToken(String token){
        return passwordResetTokenRepository.findByToken(token);
    }


}
