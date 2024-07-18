package com.pair.customerService.business.abstracts;

import com.pair.corePackage.utils.constants.Paths;
import com.pair.customerService.business.dtos.response.get.GetCustomerResponse;
import com.pair.customerService.entities.concretes.Customer;

import java.util.UUID;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void deleteCustomer(UUID id);
    void setActiveCustomer(UUID id);
    GetCustomerResponse getCustomer(UUID id);

}
