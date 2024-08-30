package com.tarker.booking_api.presentation.controllers;

import com.tarker.booking_api.core.application.usecases.user.createUser.CreateUserModel;
import com.tarker.booking_api.core.application.usecases.user.createUser.ICreateUserUseCase;
import com.tarker.booking_api.core.application.usecases.user.deleteUser.IDeleteUserByIdUseCase;
import com.tarker.booking_api.core.application.usecases.user.getAllUsers.IGetAllUserUseCase;
import com.tarker.booking_api.core.application.usecases.user.getAllUsers.GetAllUserModel;
import com.tarker.booking_api.core.application.usecases.user.getUser.GetUserByIdModel;
import com.tarker.booking_api.core.application.usecases.user.getUser.IGetUserByIdUseCase;
import com.tarker.booking_api.core.application.usecases.user.updateUser.IUpdateUserUseCase;
import com.tarker.booking_api.core.application.usecases.user.updateUser.UpdateUserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    private final IGetAllUserUseCase getAllUserCaseUse;
    private final IGetUserByIdUseCase getUserUseCase;
    private final ICreateUserUseCase createUserUseCase;
    private final IUpdateUserUseCase updateUserUseCase;
    private final IDeleteUserByIdUseCase deleteUserByIdUseCase;

    public UserController(IGetAllUserUseCase getAllUserCaseUse, IGetUserByIdUseCase getUserUseCase, ICreateUserUseCase createUserUseCase, IUpdateUserUseCase updateUserUseCase, IDeleteUserByIdUseCase deleteUserByIdUseCase) {
        this.getAllUserCaseUse = getAllUserCaseUse;
        this.getUserUseCase = getUserUseCase;
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserByIdUseCase = deleteUserByIdUseCase;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<GetAllUserModel>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getAllUserCaseUse.execute());
    }

    @GetMapping("/get-user-by-id/{userId}")
    public ResponseEntity<GetUserByIdModel> getOne(@PathVariable Long userId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getUserUseCase.execute(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserModel> create(@RequestBody CreateUserModel createUserModel) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createUserUseCase.execute(createUserModel));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UpdateUserModel> update(@PathVariable Long userId, @RequestBody UpdateUserModel updateUserModel) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateUserUseCase.execute(userId, updateUserModel));
    }

    @DeleteMapping("/delete-by-id/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        deleteUserByIdUseCase.execute(userId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
