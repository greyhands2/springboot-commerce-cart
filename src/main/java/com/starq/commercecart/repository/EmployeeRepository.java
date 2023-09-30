package com.starq.commercecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.starq.commercecart.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
