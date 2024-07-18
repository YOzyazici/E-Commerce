package com.pair.customerService.business.abstracts;

import com.pair.customerService.business.dtos.request.create.CreatedIndividualCustomerRequest;
import com.pair.customerService.business.dtos.request.update.UpdatedIndividualCustomerRequest;
import com.pair.customerService.business.dtos.response.create.CreatedIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.get.GetIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.getAll.GetAllIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.update.UpdatedIndividualCustomerResponse;

import java.util.List;
import java.util.UUID;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse addIndividualCustomer(CreatedIndividualCustomerRequest createdIndividualCustomerRequest);
    UpdatedIndividualCustomerResponse updateIndividualCustomer(UpdatedIndividualCustomerRequest updatedIndividualCustomerRequest);
    GetIndividualCustomerResponse getIndividualCustomer(UUID id);
    List<GetAllIndividualCustomerResponse> getAllIndividualCustomers();
    void deleteIndividualCustomer(UUID id);
    void setStatus(UUID id);
}
