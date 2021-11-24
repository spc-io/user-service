package com.ong.userservice.controller;

import com.ong.userservice.dto.TransactionRequestDto;
import com.ong.userservice.dto.TransactionResponseDto;
import com.ong.userservice.entity.UserTransaction;
import com.ong.userservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class UserTransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Mono<TransactionResponseDto> createTransaction(@RequestBody Mono<TransactionRequestDto> requestDtoMono) {
        return requestDtoMono.flatMap(this.transactionService::createTransaction);
    }

    @GetMapping
    public Flux<UserTransaction> getByUserId(@RequestParam("userid") int userId) {
        return this.transactionService.getByUserId(userId);
    }
}
