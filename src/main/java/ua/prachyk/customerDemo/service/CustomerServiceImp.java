package ua.prachyk.customerDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.prachyk.customerDemo.model.Customer;
import ua.prachyk.customerDemo.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;



@Service
public class CustomerServiceImp implements CustomerService{

   private CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Optional<Customer> getById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
       customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
       customerRepository.delete(id);
    }

    @Override
    public Optional<List<Customer>> getAll() {
        return Optional.of(customerRepository.findAll());
    }
}
