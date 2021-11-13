package com.firsov.spring.rest.service;



import com.firsov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);


    public void removeEmployee(int id);

}
