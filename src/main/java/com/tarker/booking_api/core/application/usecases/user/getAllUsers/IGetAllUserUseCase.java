package com.tarker.booking_api.core.application.usecases.user.getAllUsers;

import java.util.List;

public interface IGetAllUserUseCase {
    List<GetAllUserModel> execute();
}
