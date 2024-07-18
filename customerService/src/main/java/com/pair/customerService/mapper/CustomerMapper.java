package com.pair.customerService.mapper;

import com.pair.customerService.business.dtos.request.create.CreatedCustomerRequest;
import com.pair.customerService.business.dtos.request.update.UpdatedCustomerRequest;
import com.pair.customerService.business.dtos.response.get.GetCustomerResponse;
import com.pair.customerService.entities.concretes.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer createdRequestToCustomer(CreatedCustomerRequest request);

    Customer updatedRequestToCustomer(UpdatedCustomerRequest request);

    GetCustomerResponse getCustomerToResponse(Customer customer);



}
