package com.easyfund.service;

import com.easyfund.dto.CustomerDetailsDto;

public interface ICustomerService {
    /**
     *
     * @param mobileNumber
     * @return
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
