package com.easyfund;

import com.easyfund.dto.AccountsContactDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @ComponentScans()
 * @EnableJpaRepository()
 * @EntityScan()
 */
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = AccountsContactDto.class)
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservice REST API Documentation",
                description = "EasyBank Accounts Microservices REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Marikannan Rajendran",
                        email = "kannannglabs@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.easybank.com/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "EasyBank Accounts Microservices REST API Documentation",
                url = "https://easybank.com/swagger-ui/index.html"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
