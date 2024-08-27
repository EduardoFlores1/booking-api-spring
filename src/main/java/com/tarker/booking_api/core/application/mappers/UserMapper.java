package com.tarker.booking_api.core.application.mappers;

import com.tarker.booking_api.core.application.usecases.user.createUser.CreateUserModel;
import com.tarker.booking_api.core.application.usecases.user.getAllUsers.GetAllUserModel;
import com.tarker.booking_api.core.application.usecases.user.getUser.GetUserByIdModel;
import com.tarker.booking_api.core.domain.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    GetAllUserModel entityToGetAllUser(UserEntity userEntity);
    GetUserByIdModel entityToGetUser(UserEntity userEntity);
    UserEntity createUserToEntity(CreateUserModel createUserModel);
}
