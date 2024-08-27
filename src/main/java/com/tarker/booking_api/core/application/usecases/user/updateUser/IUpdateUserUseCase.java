package com.tarker.booking_api.core.application.usecases.user.updateUser;

public interface IUpdateUserUseCase {
    UpdateUserModel execute(Long userId, UpdateUserModel updateUserModel);
}
