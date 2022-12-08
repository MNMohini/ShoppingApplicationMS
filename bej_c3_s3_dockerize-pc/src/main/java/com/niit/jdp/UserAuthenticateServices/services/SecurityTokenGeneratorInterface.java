package com.niit.jdp.UserAuthenticateServices.services;

import com.niit.jdp.UserAuthenticateServices.domain.User;

import java.util.Map;

public interface SecurityTokenGeneratorInterface {
    Map<String,String> generateToken(User user);
}

