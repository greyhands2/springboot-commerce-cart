package com.starq.commercecart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.starq.commercecart.service.EmployeeService;
import com.starq.commercecart.repository.EmployeeRepository;
import com.starq.commercecart.model.Employee;
import com.starq.commercecart.exception.ResourceNotFoundException;

//We do not need to add @Transaction annotation here because Spring dataJpa internally provides @Transaction to all it's methods

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //two types of dependency injection. 1.) Setter-based , 2.) Constructor-based.
    // you use Constructor-based whenever you have Mandatory parameters , while you use Setter-based when you have parameters that are Optional

    // In our case here we are using the Employee Repository as a mandatory parameter so we use Constructor-based dependency injection
    private EmployeeRepository employeeRepository;

    //from Spring 4.3 whenever a class is configured as a Spring Bean and has only one constructor, the @Autowired annotation can be omitted because Spring will use that constructor and inject all necessary dependencies
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id){
        // Optional<Employee> employee = employeeRepository.findById(id);
        // if(employee.isPresent()){
        //     return employee.get();
        // } else{
        //     throw new ResourceNotFoundException("Employee", "Id", id);
        // }

        // or using lambda
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        
    }

    @Override
    public Employee updateEmployee(Employee employee, long id){
        //check if employee exists
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());

        existingEmployee.setLastName(employee.getLastName());

        existingEmployee.setEmail(employee.getEmail());
        
        employeeRepository.save(existingEmployee);
        
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //check if employee exists
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }

}
