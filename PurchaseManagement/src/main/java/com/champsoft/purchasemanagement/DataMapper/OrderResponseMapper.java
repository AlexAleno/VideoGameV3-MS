package com.champsoft.purchasemanagement.DataMapper;


import com.example.videogamev3.GameManagement.DataAccess.Genre;
import com.example.videogamev3.GameManagement.Presentation.DTOS.GameRequestModel;
import com.example.videogamev3.PurchaseManagement.DataAccess.Order;
import com.example.videogamev3.PurchaseManagement.DataAccess.OrderId;
import com.example.videogamev3.PurchaseManagement.Presentation.OrderResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class, GameRequestModel.class, OrderId.class, LocalDateTime.class, Genre.class})
public interface OrderResponseMapper {
    @Mapping(target = "orderId", expression = "java(order.getOrderId().getUuid())")
    @Mapping(target = "orderDate", expression = "java(order.getOrderDate().toString())")
    @Mapping(target = "userId", expression = "java(order.getUser().getUserId().getUuid())")
    OrderResponseModel orderToOrderResponseModel(Order order);
}
