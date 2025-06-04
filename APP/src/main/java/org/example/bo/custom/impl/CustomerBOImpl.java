package org.example.bo.custom.impl;

import org.example.bo.custom.CustomerBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.CustomerDAO;
import org.example.dao.custom.impl.CustomerDAOImpl;
import org.example.dto.CustomerDto;
import org.example.entity.Customer;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    private CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDao(DAOFactory.getDaoType.CUSTOMER);
    @Override
    public ArrayList<CustomerDto> getAllDetails() {
        ArrayList<Customer> allDetails = customerDAO.getAll();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        //HERE CONVERT THIS TO DTO
        for(Customer customer : allDetails){
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustId(),
                    customer.getFname(),
                    customer.getLname(),
                    customer.getEmail(),
                    customer.getContact()
            );

            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    @Override
    public boolean saveCustomer(CustomerDto dto) {
        return customerDAO.save((dto != null) ? new Customer(dto.getCustId(), dto.getFname(), dto.getLname(), dto.getEmail(), dto.getContact()) : null);
    }

}
