package com.pair.customerService.business.dtos.request.create;

import com.pair.customerService.entities.enums.GenderType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedIndividualCustomerRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private CreatedCustomerRequest customerRequest;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private GenderType genderType;
    @NotNull
    private String fatherName;
    @NotNull
    private String motherName;
    @NotNull
    @Size(min = 11,max = 11)
    private String nationalityNo;

}
