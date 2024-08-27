package com.tarker.booking_api.presentation.controllers.user;

import com.tarker.booking_api.core.application.usecases.user.getAllUsers.IGetAllUserUseCase;
import com.tarker.booking_api.core.application.usecases.user.getAllUsers.GetAllUserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class GetAllUserController {
    private final IGetAllUserUseCase getAllUserCaseUse;

    public GetAllUserController(IGetAllUserUseCase getAllUserCaseUse) {
        this.getAllUserCaseUse = getAllUserCaseUse;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllUserModel>> execute() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getAllUserCaseUse.execute());
    }
}
