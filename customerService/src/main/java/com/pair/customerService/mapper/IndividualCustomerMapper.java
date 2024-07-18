package com.pair.customerService.mapper;

import com.pair.customerService.business.dtos.request.create.CreatedIndividualCustomerRequest;
import com.pair.customerService.business.dtos.request.update.UpdatedIndividualCustomerRequest;
import com.pair.customerService.business.dtos.response.create.CreatedIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.get.GetIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.getAll.GetAllIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.update.UpdatedIndividualCustomerResponse;
import com.pair.customerService.entities.concretes.IndividualCustomer;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IndividualCustomerMapper {
    IndividualCustomerMapper INSTANCE = Mappers.getMapper(IndividualCustomerMapper.class);

    IndividualCustomer createdRequestToIndividualCustomer(CreatedIndividualCustomerRequest createdIndividualCustomerRequest);

    @Mapping(source = "customer.email",target = "email",defaultValue = "null")
    @Mapping(source = "customer.phoneNumber",target = "phoneNumber",defaultValue = "null")
    @Mapping(source = "customer.active",target = "active")
        // TODO: 18.07.2024 diğerlerine de eklenecek 
    CreatedIndividualCustomerResponse createdCustomerToResponse(IndividualCustomer individualCustomer);


    IndividualCustomer updatedRequestToIndividualCustomer(UpdatedIndividualCustomerRequest updatedIndividualCustomerRequest);
    @Mapping(source = "customer.email",target = "email",defaultValue = "null")
    @Mapping(source = "customer.phoneNumber",target = "phoneNumber",defaultValue = "null")
    UpdatedIndividualCustomerResponse updatedCustomerToResponse(IndividualCustomer individualCustomer);

    @Mapping(source = "customer.email",target = "email",defaultValue = "null")
    @Mapping(source = "customer.phoneNumber",target = "phoneNumber",defaultValue = "null")
    GetIndividualCustomerResponse getCustomerToResponse(IndividualCustomer individualCustomer);

    @Mapping(source = "customer.email",target = "email",defaultValue = "null")
    @Mapping(source = "customer.phoneNumber",target = "phoneNumber",defaultValue = "null")
    GetAllIndividualCustomerResponse getAllCustomerToResponse(IndividualCustomer individualCustomerList);
}
