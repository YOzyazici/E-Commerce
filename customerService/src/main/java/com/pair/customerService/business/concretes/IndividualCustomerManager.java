package com.pair.customerService.business.concretes;

import com.pair.customerService.business.abstracts.CustomerService;
import com.pair.customerService.business.abstracts.IndividualCustomerService;
import com.pair.customerService.business.dtos.request.create.CreatedIndividualCustomerRequest;
import com.pair.customerService.business.dtos.request.update.UpdatedIndividualCustomerRequest;
import com.pair.customerService.business.dtos.response.create.CreatedIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.get.GetIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.getAll.GetAllIndividualCustomerResponse;
import com.pair.customerService.business.dtos.response.update.UpdatedIndividualCustomerResponse;
import com.pair.customerService.business.rules.IndividualCustomerBusinessRules;
import com.pair.customerService.dataAccess.abstracts.CustomerRepository;
import com.pair.customerService.dataAccess.abstracts.IndividualCustomerRepository;
import com.pair.customerService.entities.concretes.Customer;
import com.pair.customerService.entities.concretes.IndividualCustomer;
import com.pair.customerService.mapper.CustomerMapper;
import com.pair.customerService.mapper.IndividualCustomerMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final CustomerService customerService;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;


    @Override
    public CreatedIndividualCustomerResponse addIndividualCustomer(CreatedIndividualCustomerRequest createdIndividualCustomerRequest) {
    individualCustomerBusinessRules.checkNatioanlityNo(createdIndividualCustomerRequest.getNationalityNo());
    individualCustomerBusinessRules.nationalityNoCanNotBeDuplicated(createdIndividualCustomerRequest.getNationalityNo());

    IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.createdRequestToIndividualCustomer(createdIndividualCustomerRequest);
    Customer customer = CustomerMapper.INSTANCE.createdRequestToCustomer(createdIndividualCustomerRequest.getCustomerRequest());
    customerService.saveCustomer(customer);
    individualCustomer.setCustomer(customer);
    individualCustomerRepository.save(individualCustomer);
    return IndividualCustomerMapper.INSTANCE.createdCustomerToResponse(individualCustomer);
    }

    @Override
    public UpdatedIndividualCustomerResponse updateIndividualCustomer(UpdatedIndividualCustomerRequest updatedIndividualCustomerRequest) {
       individualCustomerBusinessRules.individualCustomerShouldBeExist(updatedIndividualCustomerRequest.getId());

       Optional<IndividualCustomer> foundIndividualCustomer = individualCustomerRepository.findById(updatedIndividualCustomerRequest.getId());
       IndividualCustomer individualCustomer = IndividualCustomerMapper.INSTANCE.updatedRequestToIndividualCustomer(updatedIndividualCustomerRequest);
       Customer customer = CustomerMapper.INSTANCE.updatedRequestToCustomer(updatedIndividualCustomerRequest.getUpdatedCustomerRequest());
       UUID customerId = foundIndividualCustomer.get().getCustomer().getId();
       customer.setId(customerId);
       individualCustomer.setCustomer(customer);
       individualCustomer.setNationalityNo(foundIndividualCustomer.get().getNationalityNo());
       customerService.saveCustomer(customer);
       individualCustomerRepository.save(individualCustomer);
       return IndividualCustomerMapper.INSTANCE.updatedCustomerToResponse(individualCustomer);
    }

    @Override
    public GetIndividualCustomerResponse getIndividualCustomer(UUID id) {
        individualCustomerBusinessRules.individualCustomerShouldBeExist(id);
        individualCustomerBusinessRules.individualCustomerShouldBeActive(id);

        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(id);
        return IndividualCustomerMapper.INSTANCE.getCustomerToResponse(individualCustomer.get());
    }

    @Override
    public List<GetAllIndividualCustomerResponse> getAllIndividualCustomers() {

       List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAllActiveIndividualCustomers();
       List<GetAllIndividualCustomerResponse> responses = new ArrayList<>();
       for (IndividualCustomer individualCustomer : individualCustomers) {
           GetAllIndividualCustomerResponse getAllIndividualCustomerResponse = IndividualCustomerMapper.INSTANCE.getAllCustomerToResponse(individualCustomer);
           responses.add(getAllIndividualCustomerResponse);
       }
       return responses;
    }

    @Override
    public void deleteIndividualCustomer(UUID id) {
       individualCustomerBusinessRules.individualCustomerShouldBeExist(id);
        // TODO: 18.07.2024 active kontrolu boyle mi olmalı? 
       individualCustomerBusinessRules.checkCustomerNotActive(id);

       Optional<IndividualCustomer> individualCustomer =  individualCustomerRepository.findById(id);
       customerService.deleteCustomer(individualCustomer.get().getCustomer().getId());
    }

    @Override
    public void setStatus(UUID id) {
        individualCustomerBusinessRules.individualCustomerShouldBeExist(id);
        individualCustomerBusinessRules.checkCustomerActive(id);

        IndividualCustomer individualCustomer =  individualCustomerRepository.findById(id).orElseThrow();
        customerService.setActiveCustomer(individualCustomer.getCustomer().getId());
    }


}
