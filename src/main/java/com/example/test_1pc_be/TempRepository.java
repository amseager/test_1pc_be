package com.example.test_1pc_be;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempRepository extends JpaRepository<Temp, Long> {
}
