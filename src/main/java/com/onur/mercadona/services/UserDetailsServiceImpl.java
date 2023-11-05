package com.onur.mercadona.services;

import com.onur.mercadona.model.Admin;
import com.onur.mercadona.repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminRepository.findAdminByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Admin nit found with username: " + username));
        return new User(admin.getUsername(), admin.getPassword(), new ArrayList<>());
    }
}
