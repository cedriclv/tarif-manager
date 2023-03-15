package dev.wcs.nad.tariffmanager.persistence.repository;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.wcs.nad.tariffmanager.persistence.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findByName(String name);
    
}
