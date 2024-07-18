package com.pair.customerService.api.controllers;

import com.pair.customerService.business.abstracts.IndividualCustomerService;
import com.pair.customerService.business.dtos.request.create.CreatedIndividualCustomerRequest;
import com.pair.customerService.business.dtos.request.update.UpdatedIndividualCustomerRequest;
import com.pair.customerService.business.dtos.response.create.CreatedIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.get.GetIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.getAll.GetAllIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.update.UpdatedIndividualCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/customerservice/api/v1/individualcustomer")
public class IndividualCustomerController {
    private final IndividualCustomerService individualCustomerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedIndividualCustomerResponse addIndividualCustomer(@RequestBody @Valid CreatedIndividualCustomerRequest createdIndividualCustomerRequest){
        return individualCustomerService.addIndividualCustomer(createdIndividualCustomerRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedIndividualCustomerResponse updateIndividualCustomer(@RequestBody @Valid UpdatedIndividualCustomerRequest updatedIndividualCustomerRequest){
        return individualCustomerService.updateIndividualCustomer(updatedIndividualCustomerRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetIndividualCustomerResponse getIndividualCustomer( @PathVariable UUID id){
        return individualCustomerService.getIndividualCustomer(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllIndividualCustomerResponse> getAllIndividualCustomer(){
        return individualCustomerService.getAllIndividualCustomers();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIndividualCustomer(@PathVariable UUID id){
        individualCustomerService.deleteIndividualCustomer(id);
    }

    @PutMapping("/setActive/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void setActiveIndividualCustomer(@PathVariable UUID id){
        individualCustomerService.setStatus(id);
    }
}
