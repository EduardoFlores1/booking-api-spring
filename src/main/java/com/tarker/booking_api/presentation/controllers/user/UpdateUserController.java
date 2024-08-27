package com.tarker.booking_api.presentation.controllers.user;

import com.tarker.booking_api.core.application.usecases.user.updateUser.IUpdateUserUseCase;
import com.tarker.booking_api.core.application.usecases.user.updateUser.UpdateUserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/users")
public class UpdateUserController {
    private final IUpdateUserUseCase updateUserUseCase;

    public UpdateUserController(IUpdateUserUseCase updateUserUseCase) {
        this.updateUserUseCase = updateUserUseCase;
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UpdateUserModel> execute(@PathVariable Long userId, @RequestBody UpdateUserModel updateUserModel) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateUserUseCase.execute(userId, updateUserModel));
    }
}
