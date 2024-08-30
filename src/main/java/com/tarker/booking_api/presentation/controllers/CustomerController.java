package com.tarker.booking_api.presentation.controllers;

import com.tarker.booking_api.core.application.usecases.customer.createCustomer.CreateCustomerModel;
import com.tarker.booking_api.core.application.usecases.customer.createCustomer.ICreateCustomerUseCase;
import com.tarker.booking_api.core.application.usecases.customer.deleteCustomer.IDeleteCustomerByIdUseCase;
import com.tarker.booking_api.core.application.usecases.customer.getAllCustomers.GetAllCustomerModel;
import com.tarker.booking_api.core.application.usecases.customer.getAllCustomers.IGetAllCustomerUseCase;
import com.tarker.booking_api.core.application.usecases.customer.getCustomer.GetCustomerByIdModel;
import com.tarker.booking_api.core.application.usecases.customer.getCustomer.IGetCustomerByIdUseCase;
import com.tarker.booking_api.core.application.usecases.customer.updateCustomer.IUpdateCustomerUseCase;
import com.tarker.booking_api.core.application.usecases.customer.updateCustomer.UpdateCustomerModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {
    private final IGetAllCustomerUseCase getAllCustomerUseCase;
    private final IGetCustomerByIdUseCase getCustomerByIdUseCase;
    private final ICreateCustomerUseCase createCustomerUseCase;
    private final IUpdateCustomerUseCase updateCustomerUseCase;
    private final IDeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    public CustomerController(IGetAllCustomerUseCase getAllCustomerUseCase, IGetCustomerByIdUseCase getCustomerByIdUseCase, ICreateCustomerUseCase createCustomerUseCase, IUpdateCustomerUseCase updateCustomerUseCase, IDeleteCustomerByIdUseCase deleteCustomerByIdUseCase) {
        this.getAllCustomerUseCase = getAllCustomerUseCase;
        this.getCustomerByIdUseCase = getCustomerByIdUseCase;
        this.createCustomerUseCase = createCustomerUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<GetAllCustomerModel>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getAllCustomerUseCase.execute());
    }

    @GetMapping("get-customer-by-id/{customerId}")
    public ResponseEntity<GetCustomerByIdModel> getOne(@PathVariable Long customerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getCustomerByIdUseCase.execute(customerId));
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCustomerModel> create(@RequestBody CreateCustomerModel createCustomerModel) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createCustomerUseCase.execute(createCustomerModel));
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<UpdateCustomerModel> update(@PathVariable Long customerId, @RequestBody UpdateCustomerModel updateCustomerModel) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateCustomerUseCase.execute(customerId, updateCustomerModel));
    }

    @DeleteMapping("/delete-by-id/{customerId}")
    public ResponseEntity<Void> delete(@PathVariable Long customerId) {
        deleteCustomerByIdUseCase.execute(customerId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
