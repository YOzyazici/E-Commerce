package com.pair.customerService.business.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {

    private int cityId;

    private String cityName;

    private String street;

    private String houseFlatNumber;

    private String description;

    private int customerId;


}
