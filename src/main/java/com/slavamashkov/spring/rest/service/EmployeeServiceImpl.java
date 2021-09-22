package com.slavamashkov.spring.rest.service;

import com.slavamashkov.spring.rest.dao.EmployeeDAO;
import com.slavamashkov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    /**
     * Description
     * @return return
     */
    @Override
    @Transactional // Spring take responsibility for open/close transaction
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    /**
     * Description
     * @param employee description
     */
    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    /**
     * Description
     * @param id description
     * @return return
     */
    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    /**
     * Description
     * @param id description
     */
    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
