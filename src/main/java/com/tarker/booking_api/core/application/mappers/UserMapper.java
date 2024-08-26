package com.tarker.booking_api.core.application.mappers;

import com.tarker.booking_api.core.application.usecases.user.getAllUsers.GetAllUserModel;
import com.tarker.booking_api.core.domain.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    GetAllUserModel toModel(UserEntity userEntity);
}
