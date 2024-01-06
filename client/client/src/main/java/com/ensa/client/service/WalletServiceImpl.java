package com.ensa.client.service;

import com.ensa.client.DTO.SendMoneyRequest;
import com.ensa.client.DTO.WalletBalanceRequest;
import com.ensa.client.entity.Client;
import com.ensa.client.repo.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final ClientRepository clientRepository;
    @Override
    public Double getWalletBalance(WalletBalanceRequest walletBalanceRequest) {
        Optional<Client> client = clientRepository.findClientByEmailAndPassword(walletBalanceRequest.getEmail(),walletBalanceRequest.getPassword());
        if (client.isPresent()) {
            return client.get().getWallet().getBalance();
        }
        else {
            throw new RuntimeException("Client not Found");
        }
    }

    @Override
    public void sendMoney(SendMoneyRequest sendMoneyRequest) {
        Optional<Client> sender = clientRepository.findClientByEmailAndPassword(sendMoneyRequest.getSenderEmail(),sendMoneyRequest.getSenderPassword());
        Optional<Client> receiver = clientRepository.findClientByEmail(sendMoneyRequest.getReceiverEmail());
        if (sender.isPresent()) {
            if(sender.get().getWallet().getBalance() < sendMoneyRequest.getAmount()){
                throw new RuntimeException("Balance is lower than the transaction amount");
            }
            else{
                if(receiver.isPresent()){
                    sender.get().getWallet().setBalance(sender.get().getWallet().getBalance() - sendMoneyRequest.getAmount());
                    receiver.get().getWallet().setBalance(sender.get().getWallet().getBalance() + sendMoneyRequest.getAmount());
                }
                else {
                    throw new RuntimeException("Receiver not Found");
                }
            }

        }
        else {
            throw new RuntimeException("Sender not Found");
        }

    }
}
