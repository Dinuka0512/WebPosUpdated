package org.example.bo.custom;

import org.example.bo.SuperBO;
import org.example.dto.CustomerDto;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDto> getAllDetails();
    boolean saveCustomer(CustomerDto dto);
}
