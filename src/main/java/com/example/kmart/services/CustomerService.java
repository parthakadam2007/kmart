package com.example.kmart.services;
import com.example.kmart.models.CustomerDTO;
import java.util.List;
public interface CustomerService {
    public List<CustomerDTO> getAllCustomers();
    public CustomerDTO saveCustomer(CustomerDTO customerDTO);
    public CustomerDTO getCustomerById(Long id);
    public CustomerDTO getCustomerByEmail(String email);
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
}
