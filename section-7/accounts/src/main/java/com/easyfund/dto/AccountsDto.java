package com.easyfund.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
@Data
public class AccountsDto {

    @Schema(
            description = "Account number of the Customer"
    )
    @NotEmpty(message = "Account number cannot be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Type of the Account", example = "Savings"
    )
    @NotEmpty(message = "Account type cannot be a null or empty")
    private String accountType;

    @Schema(
            description = "Branch address of the bank"
    )
    @NotEmpty(message = "Branch address cannot be a null or empty")
    private String branchAddress;

}
