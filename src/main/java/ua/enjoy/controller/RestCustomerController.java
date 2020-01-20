package ua.enjoy.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.enjoy.model.Customer;
import ua.enjoy.service.CustomerServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/rest/customer")
public class RestCustomerController {
    private final CustomerServiceImpl customerService;

    public RestCustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> all = customerService.getAll();
        if (all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getById (@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer byId = customerService.getById(id);
        if (Objects.isNull(byId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> create(@RequestBody @Valid Customer customer) {
        HttpHeaders headers = new HttpHeaders();

        if (Objects.isNull(customer)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerService.create(customer);
        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> deleteById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        if (Objects.isNull(customer)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> update(@RequestBody @Valid Customer customer, @PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        if (Objects.isNull(customer) || id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customer.setId(id);
        customerService.create(customer);
        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
    }
}
