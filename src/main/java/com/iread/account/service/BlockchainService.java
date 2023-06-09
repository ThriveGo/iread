package com.iread.account.service;

public interface BlockchainService {

    void storeUserDataOnBlockchain(Long userId, String username);

    boolean verifyUserDataOnBlockchain(Long userId, String username);
}
