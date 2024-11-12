package com.easyfund.service.impl;

import com.easyfund.dto.AccountsDto;
import com.easyfund.dto.CardsDto;
import com.easyfund.dto.CustomerDetailsDto;
import com.easyfund.dto.LoansDto;
import com.easyfund.entity.Accounts;
import com.easyfund.entity.Customer;
import com.easyfund.exception.ResourceNotFoundException;
import com.easyfund.mapper.AccountsMapper;
import com.easyfund.mapper.CustomerMapper;
import com.easyfund.repository.AccountsRepository;
import com.easyfund.repository.CustomerRepository;
import com.easyfund.service.ICustomerService;
import com.easyfund.service.client.CardsFeignClient;
import com.easyfund.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;
    /**
     *
     * @param mobileNumber
     * @return
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts", "customerId", customer.getCustomerId().toString())
        );
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        return customerDetailsDto;
    }
}
