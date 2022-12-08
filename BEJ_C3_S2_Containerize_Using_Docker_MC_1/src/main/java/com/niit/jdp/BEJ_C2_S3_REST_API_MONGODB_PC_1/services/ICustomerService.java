package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.services;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerExistsAlready;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {
    String save(Customer customer) throws CustomerExistsAlready;

    List<Customer> getAllCustomer();

    List<Customer> getByProductName(String productName);

    boolean delete(int customerId) throws CustomerNotFoundException;
}
