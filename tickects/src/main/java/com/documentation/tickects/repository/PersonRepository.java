package com.documentation.tickects.repository;

import com.documentation.tickects.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
