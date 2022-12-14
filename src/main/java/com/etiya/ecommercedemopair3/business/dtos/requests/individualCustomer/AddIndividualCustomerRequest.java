package com.etiya.ecommercedemopair3.business.dtos.requests.individualCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddIndividualCustomerRequest {

    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private int customerNumber;
}
