package com.pair.customerService.api.controllers;

import com.pair.customerService.business.abstracts.AddressService;
import com.pair.customerService.business.dtos.AddressDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/customerservice/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDTO add(@RequestBody AddressDTO addressDTO){
        return addressService.add(addressDTO);
    }
}
