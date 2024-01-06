package com.ensa.client.service;


import com.ensa.client.DTO.SendMoneyRequest;
import com.ensa.client.DTO.WalletBalanceRequest;
import org.springframework.stereotype.Service;

public interface WalletService {
    Double getWalletBalance(WalletBalanceRequest walletBalanceRequest);
    void sendMoney(SendMoneyRequest sendMoneyRequest);

}
