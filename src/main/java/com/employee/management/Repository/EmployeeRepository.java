package com.employee.management.Repository;

import com.employee.management.Model.Entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeById(Long id);

    @Query("select count(*) from Employee")
    Integer countAll();

    @Query("select e from Employee e where e.name=?1")
    List<Employee> findAllDesignationByQuery(String query, Pageable pageable);
}
