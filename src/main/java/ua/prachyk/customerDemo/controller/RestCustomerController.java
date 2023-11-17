package ua.prachyk.customerDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.prachyk.customerDemo.model.Customer;
import ua.prachyk.customerDemo.service.CustomerService;
import ua.prachyk.customerDemo.service.CustomerServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class RestCustomerController {
    private final CustomerServiceImp customerService;

    @Autowired
    public RestCustomerController(CustomerServiceImp customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{id}")

    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = this.customerService.getById(customerId);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Validated Customer customer) {
        HttpHeaders headers = new HttpHeaders();
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save(customer);
        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save(customer);
        return new ResponseEntity<>(customer,headers, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable ("id")Long id){
         Customer customer = this.customerService.getById(id);
         if (customer == null){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         this.customerService.delete(id);
         return new ResponseEntity<>(customer,HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customerList = this.customerService.getAll();
        if (customerList.isEmpty()){
            return new ResponseEntity<>(customerList,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }
}

















