package com.tarker.booking_api.presentation.controllers.user;

import com.tarker.booking_api.core.application.usecases.user.deleteUser.IDeleteUserByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/users")
public class DeleteUserByIdController {
    private final IDeleteUserByIdUseCase deleteUserByIdUseCase;

    public DeleteUserByIdController(IDeleteUserByIdUseCase deleteUserByIdUseCase) {
        this.deleteUserByIdUseCase = deleteUserByIdUseCase;
    }

    @DeleteMapping("/deleteById/{userId}")
    public ResponseEntity<Void> execute(@PathVariable Long userId) {
        deleteUserByIdUseCase.execute(userId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
