package com.champsoft.purchasemanagement.Presentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseModel {
    private String orderId;
    private String orderDate;
    private double totalPrice;
    private String userId;
}
