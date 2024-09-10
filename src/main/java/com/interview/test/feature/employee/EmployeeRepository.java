package com.interview.test.feature.employee;

import com.interview.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:keyword% OR e.department LIKE %:keyword%")
    List<Employee> searchByKeyword(@Param("keyword") String keyword);
}
