/*
 * Author Name: Mohini
 * Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.UserAuthenticateServices.services;

import com.niit.jdp.UserAuthenticateServices.domain.User;
import com.niit.jdp.UserAuthenticateServices.exceptions.UserNotFoundException;
import com.niit.jdp.UserAuthenticateServices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserInterfaceService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveData(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User loginCheck(String userName, String password) throws UserNotFoundException {
        User userObject= userRepository.findByUserNameAndPassword(userName,password);
        if(userObject==null){
            throw new UserNotFoundException();
        }
        return userObject;
    }

    @Override
    public Optional<User> getByUserId(int userId) {
        return userRepository.findById(userId);
    }
}
