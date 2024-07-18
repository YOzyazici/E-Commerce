package com.pair.customerService.business.concretes;

import com.pair.customerService.business.abstracts.CustomerService;
import com.pair.customerService.business.dtos.response.get.GetCustomerResponse;
import com.pair.customerService.dataAccess.abstracts.CustomerRepository;
import com.pair.customerService.entities.concretes.Customer;
import com.pair.customerService.mapper.CustomerMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;


    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerRepository.softDelete(id);
    }

    @Override
    public void setActiveCustomer(UUID id) {
        customerRepository.setActiveCustomer(id);
    }

    @Override
    public GetCustomerResponse getCustomer(UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow(null);
        return CustomerMapper.INSTANCE.getCustomerToResponse(customer);
    }
}
