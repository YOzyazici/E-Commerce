package com.pair.customerService.business.dtos.request.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedCustomerRequest {
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 11, max = 11)
    private String phoneNumber;


}
