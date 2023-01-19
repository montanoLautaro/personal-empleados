package com.practicas.personal.repositories;

import com.practicas.personal.models.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal,Long> {
}
