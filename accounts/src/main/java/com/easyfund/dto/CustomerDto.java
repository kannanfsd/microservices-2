package com.easyfund.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 2, max = 30, message = "The length of the customer name should be between 2 and 30")
    private String name;

    @NotEmpty(message = "email can not be null or empty")
    @Email(message = "Enter the valid email address")
    private String email;

    @NotEmpty(message = "mobile number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;

}
