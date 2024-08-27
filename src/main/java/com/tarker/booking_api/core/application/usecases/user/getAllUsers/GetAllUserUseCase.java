package com.tarker.booking_api.core.application.usecases.user.getAllUsers;

import com.tarker.booking_api.core.application.mappers.UserMapper;
import com.tarker.booking_api.core.application.repositories.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GetAllUserUseCase implements IGetAllUserUseCase {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public GetAllUserUseCase(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<GetAllUserModel> execute() {
        return userRepository.getAllUsers()
                .stream()
                .map(userMapper::entityToGetAllUser)
                .toList();
    }
}
