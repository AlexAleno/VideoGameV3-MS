package com.champsoft.purchasemanagement.Presentation;

import com.example.videogamev3.PurchaseManagement.BusinessLogic.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("{uuid}")
    public void addOrder(@RequestBody OrderRequestModel orderRequestModel, @PathVariable String uuid) {
        orderService.addOrder(orderRequestModel, uuid);
    }

}
