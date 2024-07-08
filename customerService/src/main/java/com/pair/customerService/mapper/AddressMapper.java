package com.pair.customerService.mapper;

import com.pair.customerService.business.dtos.AddressDTO;
import com.pair.customerService.entities.concretes.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "address.description", target = "desc", defaultValue = "null")
    AddressDTO EntityToDto(Address address);  //response

    @InheritInverseConfiguration
    Address DtoToEntity(AddressDTO addressDTO);  //request
}