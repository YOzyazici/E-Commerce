package com.pair.customerService.business.concretes;

import com.pair.customerService.business.abstracts.AddressService;
import com.pair.customerService.business.dtos.AddressDTO;
import com.pair.customerService.dataAccess.abstracts.AddressRepository;
import com.pair.customerService.dataAccess.abstracts.CityRepository;
import com.pair.customerService.dataAccess.abstracts.CustomerRepository;
import com.pair.customerService.entities.concretes.Address;
import com.pair.customerService.entities.concretes.City;
import com.pair.customerService.entities.concretes.Customer;
import com.pair.customerService.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CustomerRepository customerRepository;


    @Override
    public AddressDTO add(AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.DtoToEntity(addressDTO);
        Optional<City> optionalCity = cityRepository.findById(addressDTO.getCityId());
        Optional<Customer> optionalCustomer = customerRepository.findById(addressDTO.getCustomerId());
        address.setCustomer(optionalCustomer.get());
        address.setCity(optionalCity.get());
        addressRepository.save(address);
        return AddressMapper.INSTANCE.EntityToDto(address);
    }
}
