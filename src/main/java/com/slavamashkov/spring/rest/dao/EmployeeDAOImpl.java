package com.slavamashkov.spring.rest.dao;

import com.slavamashkov.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO class responsible for providing
 * CRUD operations on database table
 * */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    // Field injection isn't recommended, but this is not critical here
    @Autowired // DI on sessionFactory bean from application_context
    private SessionFactory sessionFactory;

    /**
     * Description
     * @return List of all Employees in table
     */
    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee ", Employee.class);
        // Get all employees and save them as List
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    /**
     * Description
     * @param employee description
     */
    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    /**
     * Description
     * @param id description
     * @return return
     */
    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    /**
     * Description
     * @param id description
     */
    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
