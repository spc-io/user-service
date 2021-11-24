package com.ong.userservice.util;

import com.ong.userservice.dto.TransactionRequestDto;
import com.ong.userservice.dto.TransactionResponseDto;
import com.ong.userservice.dto.TransactionStatus;
import com.ong.userservice.dto.UserDto;
import com.ong.userservice.entity.User;
import com.ong.userservice.entity.UserTransaction;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class EntityDtoUtil {

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static User toEntity(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    public static UserTransaction toEntity(TransactionRequestDto requestDto) {
        UserTransaction transaction = new UserTransaction();
        transaction.setUserId(requestDto.getUserId());
        transaction.setAmount(requestDto.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        return transaction;
    }

    public static TransactionResponseDto toDto(TransactionRequestDto requestDto, TransactionStatus status) {
        TransactionResponseDto responseDto = new TransactionResponseDto();
        responseDto.setAmount(requestDto.getAmount());
        responseDto.setUserId(requestDto.getUserId());
        responseDto.setStatus(status);
        return responseDto;
    }
}
