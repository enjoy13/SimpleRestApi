package ua.enjoy.service;

import ua.enjoy.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(long id);

    List<Customer> getAll ();

    void create(Customer customer);

    void deleteById(long id);
}
