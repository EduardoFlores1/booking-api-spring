package com.tarker.booking_api.presentation.controllers.user;

import com.tarker.booking_api.core.application.usecases.user.getUser.GetUserByIdModel;
import com.tarker.booking_api.core.application.usecases.user.getUser.IGetUserByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class GetUserByIdController {
    private final IGetUserByIdUseCase getUserUseCase;

    public GetUserByIdController(IGetUserByIdUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @GetMapping("/getById/{userId}")
    public ResponseEntity<GetUserByIdModel> execute(@PathVariable Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getUserUseCase.execute(userId));
    }
}
