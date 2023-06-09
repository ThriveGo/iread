package com.iread.account.service;

public interface UserService {

    void registerUser(String username, String password);

    boolean authenticateUser(String username, String password);
}
