package com.sbrf.reboot.dto;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String eMail;

    public Customer(long customerId, String customerName, String customerEmail) {
        id = customerId;
        name = customerName;
        eMail = customerEmail;
    }
}
