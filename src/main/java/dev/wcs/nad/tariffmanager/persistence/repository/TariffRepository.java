package dev.wcs.nad.tariffmanager.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.wcs.nad.tariffmanager.persistence.entity.Tariff;

@Repository
public interface TariffRepository extends CrudRepository<Tariff, Long> {
    List<Tariff> findByName(String name);

}
