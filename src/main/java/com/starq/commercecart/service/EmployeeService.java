package com.starq.commercecart.service;

import java.util.List;
import com.starq.commercecart.model.Employee;
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
