package com.ensa.client.web;

import com.ensa.client.DTO.SendMoneyRequest;
import com.ensa.client.DTO.WalletBalanceRequest;
import com.ensa.client.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final WalletService walletService;

    @GetMapping("/balance")
    @ResponseStatus(HttpStatus.OK)
    public Double getWalletBalance(@RequestBody WalletBalanceRequest walletBalanceRequest){
        return walletService.getWalletBalance(walletBalanceRequest);
    }

    @PutMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public void sendMoney(SendMoneyRequest sendMoneyRequest){
        walletService.sendMoney(sendMoneyRequest);
    }
}
