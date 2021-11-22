package com.ong.userservice.util;

import com.ong.userservice.dto.UserDto;
import com.ong.userservice.entity.User;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

    private static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    private static User toEntity(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }
}
