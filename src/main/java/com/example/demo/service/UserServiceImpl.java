package com.example.demo.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.login.UserRegistration;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(UserRegistration user) {

        JdbcTemplate jdbc = new JdbcTemplate(dataSource);

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        jdbc.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, 1)",
                user.getUsername(), encodedPassword);

        jdbc.update("INSERT INTO authorities (username, authority) VALUES (?, ?)",
                user.getUsername(), "ROLE_EMPLOYEE");
    }
}
