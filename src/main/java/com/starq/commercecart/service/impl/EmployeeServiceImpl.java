package com.starq.commercecart.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.starq.commercecart.service.EmployeeService;
import com.starq.commercecart.repository.EmployeeRepository;
import com.starq.commercecart.model.Employee;

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
}
