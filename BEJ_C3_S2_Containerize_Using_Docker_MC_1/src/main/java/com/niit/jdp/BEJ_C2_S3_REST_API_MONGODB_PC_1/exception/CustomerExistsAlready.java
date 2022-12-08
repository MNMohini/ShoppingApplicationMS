/*
 * Author Name: Mohini
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.BEJ_C2_S3_REST_API_MONGODB_PC_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Customer with specified Id already exists")
public class CustomerExistsAlready extends Exception {
}






















