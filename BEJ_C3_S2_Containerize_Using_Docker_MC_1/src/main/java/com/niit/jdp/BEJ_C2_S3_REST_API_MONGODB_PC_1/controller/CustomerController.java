/*
 * Author Name: Mohini
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.controller;

import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.domain.Customer;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerExistsAlready;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception.CustomerNotFoundException;
import com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private ICustomerService iCustomerService;

    @Autowired
    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @PostMapping("/insertData")
    public ResponseEntity<?> saveFun(@RequestBody Customer customer) throws CustomerExistsAlready {
        try {
            return new ResponseEntity<>(iCustomerService.save(customer), HttpStatus.CREATED);
        } catch (CustomerExistsAlready e) {
            throw new CustomerExistsAlready();
        } catch (Exception e) {
            return new ResponseEntity<>("Error!!!try Sometime later", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<?> fetchFun1() {
        return new ResponseEntity<>(iCustomerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/fetchByProduct/{productName}")
    public ResponseEntity<?> fetchFun2(@PathVariable String productName) {
        return new ResponseEntity<>(iCustomerService.getByProductName(productName), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?> delete(@PathVariable int customerId) throws CustomerNotFoundException {
        try {
            iCustomerService.delete(customerId);
            return new ResponseEntity<>("successfully deleted one record", HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
