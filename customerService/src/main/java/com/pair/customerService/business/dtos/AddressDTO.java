package com.pair.customerService.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDTO {

    private UUID cityId;

    private String cityName;

    private String street;

    private String houseFlatNumber;

    private String desc;

    private UUID customerId;

}
