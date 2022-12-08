/*
 * Author Name: Mohini
 * Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.UserAuthenticateServices.controller;

import com.niit.jdp.UserAuthenticateServices.domain.User;
import com.niit.jdp.UserAuthenticateServices.exceptions.UserNotFoundException;
import com.niit.jdp.UserAuthenticateServices.services.SecurityTokenGeneratorInterface;
import com.niit.jdp.UserAuthenticateServices.services.UserInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private UserInterfaceService userInterfaceService;
    private SecurityTokenGeneratorInterface securityTokenGeneratorInterface;
    @Autowired
    public UserController(UserInterfaceService userInterfaceService, SecurityTokenGeneratorInterface securityTokenGeneratorInterface) {
        this.userInterfaceService = userInterfaceService;
        this.securityTokenGeneratorInterface = securityTokenGeneratorInterface;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveFun(@RequestBody User user){
        return  new ResponseEntity<>(userInterfaceService.saveData(user), HttpStatus.CREATED);
    }
    @GetMapping("/api/v1/fetchAll")
    public ResponseEntity<?> fetchFun(){
        return new ResponseEntity<>(userInterfaceService.getAllUsers(),HttpStatus.FOUND);
    }
    @GetMapping("/api/v1/fetchById/{userId}")
    public ResponseEntity<?> fetchFunction(@PathVariable int userId){
        return new ResponseEntity<>(userInterfaceService.getByUserId(userId),HttpStatus.FOUND);
    }
    @GetMapping("/login")
    public ResponseEntity<?>fetchFunction1(@RequestBody User user) throws UserNotFoundException {
        try {
          userInterfaceService.loginCheck(user.getUserName(), user.getPassword());
            Map<String,String> secretKey= new HashMap<>();
            secretKey=securityTokenGeneratorInterface.generateToken(user);
          return new ResponseEntity<>(secretKey,HttpStatus.OK);
        }catch (UserNotFoundException exception){
            throw new UserNotFoundException();
        }catch (Exception ex){
            return new ResponseEntity<>("Error!!",HttpStatus.CONFLICT);
        }

    }
}
