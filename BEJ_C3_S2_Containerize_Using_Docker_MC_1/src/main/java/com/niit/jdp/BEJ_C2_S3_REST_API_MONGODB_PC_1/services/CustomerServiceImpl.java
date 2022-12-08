/*
 * Author Name: Mohini
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.services;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerExistsAlready;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotFoundException;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public String save(Customer customer) throws CustomerExistsAlready {
        if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
            throw new CustomerExistsAlready();
        }
        customerRepository.save(customer);
        return "Data Saved";
    }

    @Override
    public List<Customer> getAllCustomer() {

        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getByProductName(String productName) {
        return customerRepository.findAllCustomerProductName(productName);
    }

    @Override
    public boolean delete(int customerId) throws CustomerNotFoundException {
        if (customerRepository.findById(customerId).isEmpty()) {
            throw new CustomerNotFoundException();
        } else
            customerRepository.deleteById(customerId);
        return true;
    }

}
