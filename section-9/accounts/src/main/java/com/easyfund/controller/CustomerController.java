package com.easyfund.controller;

import com.easyfund.dto.CustomerDetailsDto;
import com.easyfund.dto.ErrorResponseDto;
import com.easyfund.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Customers in EasyBank",
        description = "CRUD REST APIs in EasyBank in accounts services."
)
@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {

    private final ICustomerService customerService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(
            summary = "Fetch CustomerDetails REST API",
            description = "REST API to fetch customer with accounts, loans and cards"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                responseCode = "500",
                description = "Http Status Internal Error",
                content = @Content(
                        schema = @Schema(implementation = ErrorResponseDto.class)
                )
            )}
    )
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestHeader("easyfund-correlation-id") String correlationId,
                                                                   @RequestParam
                                                                   @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                                   String mobileNumber) {
            logger.debug("easyfund-correlation-id found: {}", correlationId);
            CustomerDetailsDto customerDetailsDto = customerService.fetchCustomerDetails(mobileNumber, correlationId);
            return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
    }
}
