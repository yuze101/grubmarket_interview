package com.interview.test.feature.address;

import com.interview.test.model.Address;
import com.interview.test.model.Employee;
import com.interview.test.feature.employee.EmployeeRepository;
import com.interview.test.exception.AddressNotFoundException;
import com.interview.test.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;

    public AddressService(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Address> getAllAddressesForEmployee(Long employeeId) {
        return addressRepository.findByEmployeeId(employeeId);
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address not found with id " + id));
    }

    public Address createAddress(Long employeeId, Address address) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + employeeId));
        address.setEmployee(employee);
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address updatedAddress) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address not found with id " + id));
        updatedAddress.setId(id);
        updatedAddress.setEmployee(address.getEmployee());
        return addressRepository.save(updatedAddress);
    }

    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException("Address not found with id " + id);
        }
        addressRepository.deleteById(id);
    }

    public void deleteAllAddressesForEmployee(Long employeeId) {
        List<Address> addresses = addressRepository.findByEmployeeId(employeeId);
        addressRepository.deleteAll(addresses);
    }
}