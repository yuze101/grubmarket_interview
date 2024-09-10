package com.interview.test.feature.address;

import com.interview.test.model.Address;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/{employeeId}/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses(@PathVariable Long employeeId) {
        List<Address> addresses = addressService.getAllAddressesForEmployee(employeeId);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@PathVariable Long employeeId, @Valid @RequestBody Address address) {
        Address createdAddress = addressService.createAddress(employeeId, address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @Valid @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}