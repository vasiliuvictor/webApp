package com.example.backend.persistance.repositories;

import com.example.backend.persistance.domain.backend.PasswordResetToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by Andrei.Vasiliu on 3/27/2018.
 */
public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken,Long>{

    PasswordResetToken findByToken(String token);

    @Query("select ptr from PasswordResetToken  ptr inner join ptr.user u where ptr.user.id = ?1")
    Set<PasswordResetToken> findAllByUserId(long userId);
}
