package com.pair.customerService.business.concretes;

import com.pair.customerService.business.abstracts.AddressService;
import com.pair.customerService.business.dtos.AddressDTO;
import com.pair.customerService.dataAccess.abstracts.AddressRepository;
import com.pair.customerService.entities.concretes.Address;
import com.pair.customerService.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public AddressDTO add(AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.DtoToEntity(addressDTO);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.EntityToDto(address);
    }
}
