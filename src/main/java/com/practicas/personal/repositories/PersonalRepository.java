package com.practicas.personal.repositories;

import com.practicas.personal.models.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonalRepository extends JpaRepository<Personal,Long> {
    public Personal findByUsername(String username);
}
