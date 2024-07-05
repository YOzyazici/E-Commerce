package com.pair.customerService.entities.concretes;

import com.pair.corePackage.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "adresses")
public class Address extends BaseEntity {

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house_flat_number", nullable = false)
    private String houseFlatNumber;

    @Column(name = "description", nullable = false)
    private String description;

    @JoinColumn(name = "customer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "city_id")
    private City city;

}