package ua.enjoy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.enjoy.model.Customer;
import ua.enjoy.repository.CustomerRepository;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getById(long id) {
        log.info("method getById id = {}", id);
        return customerRepository.findById(id).get();
    }

    public List<Customer> getAll() {
        log.info("method getAll");
        return customerRepository.findAll();
    }

    public void create(Customer customer) {
        log.info("method create customer = {}", customer);
        customerRepository.save(customer);
    }

    public void deleteById(long id) {
        log.info("method deleteById id = {}", id);
        customerRepository.deleteById(id);
    }
}

