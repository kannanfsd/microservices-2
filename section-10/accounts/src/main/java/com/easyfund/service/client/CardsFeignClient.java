package com.easyfund.service.client;

import com.easyfund.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cards", fallback = CardsFallback.class)
public interface CardsFeignClient {
    @GetMapping(value="/api/v1/fetch", consumes = "application/json")
    ResponseEntity<CardsDto> fetchCardDetails(
            @RequestHeader("easyfund-correlation-id") String correlationId,
            @RequestParam String mobileNumber);
}
