package ua.prachyk.customerDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.prachyk.customerDemo.model.Customer;
import ua.prachyk.customerDemo.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;



@Service
@Transactional(readOnly = true)
public class CustomerServiceImp implements CustomerService {

   private CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer getById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

   @Override
    public void save(Customer customer) {

       customerRepository.save(customer);

    }

    @Override
    public void delete(Long id) {

       customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {

        return customerRepository.findAll();
    }
}
