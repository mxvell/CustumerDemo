package ua.prachyk.customerDemo.service;

import org.springframework.stereotype.Service;
import ua.prachyk.customerDemo.model.Customer;
import ua.prachyk.customerDemo.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerService  {
    Optional <Customer> getById(Long id);
    void save (Customer customer);
    void delete(Long id);
    Optional<List<Customer>>getAll();
}
