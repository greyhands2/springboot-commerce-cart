package com.starq.commercecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.starq.commercecart.model.Employee;

// we do not need to add the @Repository annotation because Spring Data JpaRepository already implicitly uses the @Repository annotation
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
