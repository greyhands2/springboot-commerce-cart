package com.starq.commercecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.starq.commercecart.model.Employee;

// we do not need to add the @Repository annotation because Spring Data JpaRepository already implicitly uses the @Repository annotation

//this is where communication with the mysql databbase is done..
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
