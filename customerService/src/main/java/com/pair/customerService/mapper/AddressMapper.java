package com.pair.customerService.mapper;

import com.pair.customerService.business.dtos.AddressDTO;
import com.pair.customerService.entities.concretes.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO AddresstoAddressDTO(Address address);  //response
    Address AddressDTOtoAddressEntity(AddressDTO addressDTO);  //request
}