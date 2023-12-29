package com.github.alinaberlin.restate.repositories;

import com.github.alinaberlin.restate.models.Realtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtorRepository extends JpaRepository<Realtor, Long> {
}
