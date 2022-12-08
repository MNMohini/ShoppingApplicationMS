package com.niit.jdp.UserAuthenticateServices.services;

import com.niit.jdp.UserAuthenticateServices.domain.User;
import com.niit.jdp.UserAuthenticateServices.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserInterfaceService {
    public User saveData(User user);
    public List<User> getAllUsers();
    public User loginCheck(String userName, String password) throws UserNotFoundException;
    public Optional<User> getByUserId(int userId);
}
