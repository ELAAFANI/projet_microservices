package com.ensa.agent.web;

import com.ensa.agent.DTO.AddAmountToWalletRequest;
import com.ensa.agent.DTO.AddClientRequest;
import com.ensa.agent.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/agent")
@RequiredArgsConstructor
public class AgentController {
    private final AgentService agentService;

    @PostMapping("/addClient")
    @ResponseStatus(HttpStatus.CREATED)
    public void addClient(@RequestBody AddClientRequest addClientRequest){
        agentService.addClient(addClientRequest);
    }

    @PutMapping("/updateBalance")
    @ResponseStatus(HttpStatus.OK)
    public void addAmountToWallet(@RequestBody AddAmountToWalletRequest addAmountToWalletRequest){
        agentService.addAmountToWallet(addAmountToWalletRequest);
    }
}
