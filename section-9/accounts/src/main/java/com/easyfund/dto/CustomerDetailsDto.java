package com.easyfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer, Accounts, Loans & Cards Information"
)
public class CustomerDetailsDto {
    @Schema(description = "Name of the Customer", example = "Easy Bank")
    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 2, max = 30, message = "The length of the customer name should be between 2 and 30")
    private String name;

    @Schema(description = "Email address of the Customer", example = "customer@easybank.com")
    @NotEmpty(message = "email can not be null or empty")
    @Email(message = "Enter the valid email address")
    private String email;

    @Schema(description = "Mobile number of the Customer", example = "9090909090")
    @NotEmpty(message = "mobile number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Accounts details of the Customer")
    private AccountsDto accountsDto;

    @Schema(description = "Loans details of the Customer")
    private LoansDto loansDto;

    @Schema(description = "Cards details of the Customer")
    private CardsDto cardsDto;
}
