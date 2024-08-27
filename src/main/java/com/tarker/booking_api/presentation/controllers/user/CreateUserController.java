package com.tarker.booking_api.presentation.controllers.user;

import com.tarker.booking_api.core.application.usecases.user.createUser.CreateUserModel;
import com.tarker.booking_api.core.application.usecases.user.createUser.ICreateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/users")
public class CreateUserController {
    private final ICreateUserUseCase createUserUseCase;

    public CreateUserController(ICreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserModel> execute(@RequestBody CreateUserModel createUserModel) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createUserUseCase.execute(createUserModel));
    }
}
