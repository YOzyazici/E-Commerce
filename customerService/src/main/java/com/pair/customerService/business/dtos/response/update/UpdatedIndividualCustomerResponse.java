package com.pair.customerService.business.dtos.response.update;

import com.pair.customerService.entities.enums.GenderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedIndividualCustomerResponse {

    private UUID id;
    private LocalDateTime updatedDate;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private GenderType genderType;
    private String fatherName;
    private String motherName;
    private String nationalityNo;
    private String email;
    private String phoneNumber;
    private boolean isActive;
}
