package com.sbrf.reboot.repository;

import com.sbrf.reboot.dto.Customer;

import java.util.List;

public interface CustomerRepository {
    boolean createCustomer(String name, String email);

    List<Customer> getAll();
}
