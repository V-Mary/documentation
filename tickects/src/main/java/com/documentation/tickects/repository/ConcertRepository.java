package com.documentation.tickects.repository;

import com.documentation.tickects.models.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Integer> {
}
