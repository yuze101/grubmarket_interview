package com.interview.test.feature.employee;

import com.interview.test.exception.EmployeeNotFoundException;
import com.interview.test.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.interview.test.feature.address.AddressService;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressService addressService;

    public EmployeeService(EmployeeRepository employeeRepository, AddressService addressService) {
        this.employeeRepository = employeeRepository;
        this.addressService = addressService;
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee existingEmployee = getEmployeeById(id);
        addressService.deleteAllAddressesForEmployee(id);
        employeeRepository.delete(existingEmployee);
    }

    public List<Employee> searchEmployees(String keyword) {
        return employeeRepository.searchByKeyword(keyword);
    }
}