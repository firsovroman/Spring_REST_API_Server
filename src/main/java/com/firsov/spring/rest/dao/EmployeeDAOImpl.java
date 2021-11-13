package com.firsov.spring.rest.dao;

import com.firsov.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionfactory;


    @Override
    @Transactional
    public List<Employee> getAllEmployees() {

        Session session = sessionfactory.getCurrentSession().getSession();
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee){

        Session session = sessionfactory.getCurrentSession().getSession();

        session.saveOrUpdate(employee);

    }

    @Override
    @Transactional
    public Employee getEmployee(int id){

        Session session = sessionfactory.getCurrentSession();

        Employee employee = session.get(Employee.class, id);

        return employee;

    }

    @Override
    @Transactional
    public void removeEmployee(int id) {

        Session session = sessionfactory.getCurrentSession();

//        session.delete(getEmployee(id));

        Query<Employee> query = session.createQuery("delete from Employee where id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }


}
