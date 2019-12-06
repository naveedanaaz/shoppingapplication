package com.productapp.model.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.productapp.model.entities.Orders;
import com.productapp.model.entities.Product;



public interface OrdersService  {
public List<Orders> saveOrder(Product product,User user,Long storeId);
}
