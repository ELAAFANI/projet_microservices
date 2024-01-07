package com.ensa.agent.service;

import com.ensa.agent.DTO.AddAmountToWalletRequest;
import com.ensa.agent.DTO.AddClientRequest;
import com.ensa.agent.entity.Client;
import com.ensa.agent.entity.Wallet;
import com.ensa.agent.repo.ClientRepository;
import com.ensa.agent.repo.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AgentServiceImpl implements AgentService {

    private final ClientRepository clientRepository;
    private final WalletRepository walletRepository;
    @Override
    public void addClient(AddClientRequest addClientRequest) {
        Client client = Client.builder()
                .cin(addClientRequest.getCIN())
                .email(addClientRequest.getEmail())
                .firstName(addClientRequest.getFirstName())
                .lastName(addClientRequest.getLastName())
                .address(addClientRequest.getAddress())
                .password("0000")
                .build();
        Wallet wallet = Wallet.builder()
                .balance(0D)
                .build();
        client.setWallet(wallet);
        clientRepository.save(client);
        wallet.setClient(client);
        walletRepository.save(wallet);

    }

    @Override
    public void addAmountToWallet(AddAmountToWalletRequest addAmountToWalletRequest) {
        Optional<Wallet> wallet = walletRepository.findByClientId(addAmountToWalletRequest.getClientId());
        if (wallet.isPresent()) {
            wallet.get().setBalance(wallet.get().getBalance() + addAmountToWalletRequest.getAmount());
            walletRepository.save(wallet.get());
        }
        else {
            throw new RuntimeException("Wallet not Found");
        }
    }
}
