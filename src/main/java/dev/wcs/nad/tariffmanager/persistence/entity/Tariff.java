package dev.wcs.nad.tariffmanager.persistence.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tariff")
@Getter
@Setter
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "tariff_options",
            joinColumns = @JoinColumn(name = "tariff_id"),
            inverseJoinColumns = @JoinColumn(name = "options_id"))
    private Set<Option> possibleOptions = new LinkedHashSet<>();

    @ManyToOne()
    @JoinColumn(name = "department_id")
    private Department department;

}