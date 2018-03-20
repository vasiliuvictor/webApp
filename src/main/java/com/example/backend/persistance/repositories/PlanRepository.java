package com.example.backend.persistance.repositories;

import com.example.backend.persistance.domain.backend.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends CrudRepository<Plan,Integer> {
}
