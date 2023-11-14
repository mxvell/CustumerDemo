package ua.prachyk.customerDemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.prachyk.customerDemo.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
