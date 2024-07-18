package com.pair.customerService.business.rules;

import com.pair.corePackage.business.abstracts.MessageService;
import com.pair.corePackage.utils.exceptions.types.BusinessException;
import com.pair.customerService.business.abstracts.CustomerService;
import com.pair.customerService.business.dtos.response.get.GetCustomerResponse;
import com.pair.customerService.business.messages.Messages;
import com.pair.customerService.dataAccess.abstracts.IndividualCustomerRepository;
import com.pair.customerService.entities.concretes.Customer;
import com.pair.customerService.entities.concretes.IndividualCustomer;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.pqc.legacy.math.linearalgebra.PolynomialRingGF2;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class IndividualCustomerBusinessRules {
    private final MessageService messageService;
    private final IndividualCustomerRepository individualCustomerRepository;
    private final CustomerService customerService;

    public void nationalityNoCanNotBeDuplicated(String nationalityNo) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findByNationalityNo(nationalityNo);
        if (individualCustomer.isPresent()) {
            throw new BusinessException(messageService.getMessage(Messages.CustomerErrors.IndividualCustomerWithThisIDNumberExist));
        }
    }

    // TODO: 18.07.2024 kurtuldu' nun yöntem 
    public void checkNatioanlityNo(String nationalityNo){
        String regex = "^[1-9]{1}[0-9]{9}[02468]{1}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nationalityNo);

        if(!matcher.matches()){
            throw new  BusinessException(messageService.getMessage(Messages.CustomerErrors.CheckNationalityNo));
        }
    }

    public void individualCustomerShouldBeExist(UUID individualCustomerId){
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(individualCustomerId);
        if(individualCustomer.isEmpty()){
            throw new BusinessException(messageService.getMessage(Messages.CustomerErrors.IndividualCustomerShouldBeExists));
        }
    }

    public void individualCustomerShouldBeActive(UUID individualCustomerId){
        Optional<IndividualCustomer> individualCustomers = individualCustomerRepository.findByIdActiveIndividualCustomers(individualCustomerId);
        if (individualCustomers.isEmpty()){
            throw new BusinessException(messageService.getMessage(Messages.CustomerErrors.IndividualCustomerShouldBeExists));
        }
    }

    public void checkCustomerNotActive(UUID individualCustomerId){
        // TODO: 18.07.2024 böyle mi önceki proje gibi mi olmalı? 
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(individualCustomerId);
        GetCustomerResponse getCustomerResponse = customerService.getCustomer(individualCustomer.get().getCustomer().getId());
        if (!getCustomerResponse.isActive()){
            throw new BusinessException(messageService.getMessage(Messages.CustomerErrors.CheckCustomerNotActive));
        }
    }

    public void  checkCustomerActive(UUID individualCustomerId){
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(individualCustomerId);
        GetCustomerResponse getCustomerResponse = customerService.getCustomer(individualCustomer.get().getCustomer().getId());
        if (getCustomerResponse.isActive()){
            throw new BusinessException(messageService.getMessage(Messages.CustomerErrors.CheckCustomerActive));
        }
    }
}
