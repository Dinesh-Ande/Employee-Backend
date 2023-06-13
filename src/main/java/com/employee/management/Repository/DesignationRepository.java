package com.employee.management.Repository;

import com.employee.management.Model.Entity.Designation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {
    Designation findDesignationById(Long id);

    @Query("select d from Designation d where d.name=?1")
    List<Designation> findAllDesignationByQuery(String query, Pageable pageable);

    @Query("select count(*) from Designation")
    Integer countAll();
}

