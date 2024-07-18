package com.pair.customerService.business.dtos.response.get;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCustomerResponse {

    private UUID id;
    private LocalDateTime createdDate;
    private String email;
    private String phoneNumber;
    private boolean isActive = true;

}
