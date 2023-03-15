package dev.wcs.nad.tariffmanager.Tariff;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.wcs.nad.tariffmanager.persistence.entity.Department;
import dev.wcs.nad.tariffmanager.persistence.entity.Tariff;
import dev.wcs.nad.tariffmanager.persistence.repository.DepartmentRepository;
import dev.wcs.nad.tariffmanager.persistence.repository.TariffRepository;

@SpringBootTest
public class TariffRepositoryTest {
    
    @Autowired private DepartmentRepository departmentRepository;

    @Autowired private TariffRepository tariffRepository;

    @Test
    public void shouldCreateTarrifWithDepartment(){

        Department department = new Department();
        department.setName("department cedric");
        departmentRepository.save(department);

        Tariff tariff = new Tariff();
        tariff.setName("tariff cedric");
        tariff.setPrice(new BigDecimal(12));
        tariff.setDepartment(department);
        tariffRepository.save(tariff);

        Department departmentFound = departmentRepository.findById(department.getId()).get();        
        Tariff tariffFound = tariffRepository.findById(tariff.getId()).get();
        assertEquals("department cedric", departmentFound.getName());
        assertEquals("tariff cedric", tariffFound.getName());
        assertEquals(tariffFound.getDepartment().getId(),department.getId());
    }
}