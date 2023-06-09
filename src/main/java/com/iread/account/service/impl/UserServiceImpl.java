package com.iread.account.service.impl;

import com.iread.account.dao.UserMapper;
import com.iread.account.model.User;
import com.iread.account.service.BlockchainService;
import com.iread.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BlockchainService blockchainService;

    public void registerUser(String username, String password){
        User existingUser = userMapper.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("Username already exists!");
        }
        // 创建用户并保存到数据库
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insertUser(user);
        // 将用户信息存储到区块链
        blockchainService.storeUserDataOnBlockchain(user.getId(), user.getUsername());
    }

    public boolean authenticateUser(String username, String password){
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found!");
        }
        // 验证密码
        if (!user.getPassword().equals(password)) {
            return false;
        }
        // 验证用户信息是否在区块链上
        return blockchainService.verifyUserDataOnBlockchain(user.getId(), user.getUsername());
    }
}
