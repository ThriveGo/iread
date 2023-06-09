package com.iread.account.service.impl;

import com.iread.account.service.BlockchainService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BlockchainServiceImpl implements BlockchainService {
    @Value("${blockchain.node.url}")
    private String blockchainNodeUrl;

    public void storeUserDataOnBlockchain(Long userId, String username) {
        // 使用区块链节点API将用户数据存储到区块链上
    }

    public boolean verifyUserDataOnBlockchain(Long userId, String username) {
        // 使用区块链节点API验证用户数据是否存在于区块链上
        return true;
    }
}
