package com.customerService.intsv.utils;

import com.customerService.intsv.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthorityUtils {
    public static Boolean hasRole(String role, User user) {
        return user.getAuthorities()
                .stream()
                .filter(auth -> auth.getAuthority().equals(role))
                .count() > 0;
    }
}
