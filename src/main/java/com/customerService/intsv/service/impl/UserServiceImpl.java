package com.customerService.intsv.service.impl;

import com.customerService.intsv.repository.UserRepository;
import com.customerService.intsv.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
