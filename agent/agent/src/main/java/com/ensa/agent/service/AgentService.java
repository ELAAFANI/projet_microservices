package com.ensa.agent.service;

import com.ensa.agent.DTO.AddAmountToWalletRequest;
import com.ensa.agent.DTO.AddClientRequest;
import org.springframework.stereotype.Service;

@Service
public interface AgentService {
    void addClient(AddClientRequest addClientRequest);
    void addAmountToWallet(AddAmountToWalletRequest addAmountToWalletRequest);
}
