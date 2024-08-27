package com.tarker.booking_api.core.application.usecases.user.getUser;

public interface IGetUserByIdUseCase {
    GetUserByIdModel execute(Long userId);
}
