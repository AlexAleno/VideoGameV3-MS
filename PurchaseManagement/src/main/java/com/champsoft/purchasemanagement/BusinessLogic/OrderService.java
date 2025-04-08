package com.champsoft.purchasemanagement.BusinessLogic;

import com.example.videogamev3.GameManagement.DataAccess.Game;
import com.example.videogamev3.PurchaseManagement.DataAccess.Order;
import com.example.videogamev3.PurchaseManagement.DataAccess.OrderRepository;
import com.example.videogamev3.PurchaseManagement.DataMapper.OrderRequestMapper;
import com.example.videogamev3.PurchaseManagement.Presentation.OrderRequestModel;
import com.example.videogamev3.UserManagement.DataAccess.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private final String USER_MANAGEMENT_BASE_URL = "http://localhost:8080/api/v1/user";
    private final String GAME_MANAGEMENT_BASE_URL = "http://localhost:8080/api/v1/game";

    private final OrderRequestMapper orderRequestMapper;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate, ObjectMapper objectMapper, OrderRequestMapper orderRequestMapper) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.orderRequestMapper = orderRequestMapper;
    }


    private User getUserFromUserManagement(String uuid){
        String url = USER_MANAGEMENT_BASE_URL+"/"+uuid;
        try {
            String response = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(response, User.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null; // User not found
            } else {
                throw new RuntimeException("Error fetching user: " + ex.getMessage()); // Or a custom exception
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching user: " + ex.getMessage()); // Or a custom exception
        }
    }

    private Game getGameFromGameManagement(String uuid){
        String url = GAME_MANAGEMENT_BASE_URL+"/"+uuid;
        try {
            String response = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(response, Game.class);
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null; // User not found
            } else {
                throw new RuntimeException("Error fetching user: " + ex.getMessage()); // Or a custom exception
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching user: " + ex.getMessage()); // Or a custom exception
        }
    }


    public void addOrder(OrderRequestModel orderRequestModel, String uuid) {
        Order order = orderRequestMapper.orderRequestModelToOrder(orderRequestModel, uuid);
        User user = getUserFromUserManagement(uuid);
        order.setUser(user);
        orderRepository.save(order);
    }

}





