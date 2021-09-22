package com.slavamashkov.spring.rest.dao;

import com.slavamashkov.spring.rest.entity.Employee;

import java.util.List;
/**
 * Interface for employee's Data Access Object (DAO)
 */
public interface EmployeeDAO {
    /**
     * Description
     * @return return
     */
    List<Employee> getAllEmployees();

    /**
     * Description
     * @param employee description
     */
    void saveEmployee(Employee employee);

    /**
     * Description
     * @param id description
     * @return return
     */
    Employee getEmployee(int id);

    /**
     * Description
     * @param id description
     */
    void deleteEmployee(int id);
}
