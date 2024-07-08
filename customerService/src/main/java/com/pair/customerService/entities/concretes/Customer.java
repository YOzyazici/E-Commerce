package com.pair.customerService.entities.concretes;

import com.pair.corePackage.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_active")
    private boolean isActive = true;

    @OneToOne(mappedBy = "customer")
    private IndividualCustomer individualCustomer;

    @OneToOne(mappedBy = "customer")
    private CorporateCustomer corporateCustomer;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

}
