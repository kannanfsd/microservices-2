package com.easyfund.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString
public class Accounts extends BaseEntity{

    @Id
    private Long accountNumber;

    private Long customerId;

    private String accountType;

    private String branchAddress;

}
