package com.pair.customerService.business.dtos.request.update;

import com.pair.customerService.business.dtos.request.create.CreatedCustomerRequest;
import com.pair.customerService.entities.enums.GenderType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdatedIndividualCustomerRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private UpdatedCustomerRequest updatedCustomerRequest;
    private LocalDate birthDate;
    private GenderType genderType;
    private String fatherName;
    private String motherName;
}
