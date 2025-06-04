package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersDto {
    private String orderId;
    private OrderDetailDto orderDetailDto;
    private CustomerDto customerDto;
    private double total;
    private String date;
}
